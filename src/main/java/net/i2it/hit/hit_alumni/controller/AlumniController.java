package net.i2it.hit.hit_alumni.controller;

import net.i2it.hit.hit_alumni.entity.po.AlumniPO;
import net.i2it.hit.hit_alumni.entity.po.BackActivityPO;
import net.i2it.hit.hit_alumni.entity.vo.api.response.WebAccessTokenVO;
import net.i2it.hit.hit_alumni.service.function.AlumniBackService;
import net.i2it.hit.hit_alumni.service.function.WeChatApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 处理和微信服务器之间的网络交互操作
 */
@Controller
@RequestMapping("/wechat/alumni")
public class AlumniController {

    @Autowired
    private AlumniBackService alumniBackService;

    @RequestMapping(value = "/back-school", method = RequestMethod.GET, params = {"code"})
    public String getFormPage(HttpServletRequest request, String code, ModelMap map) {
//        WeChatApi weChatApi = new WeChatApi();
//        WebAccessTokenVO webAccessTokenVO = weChatApi.getWebAccessToken(code);
//        if (webAccessTokenVO != null) {//是否之前已经填过信息
//            String openId = webAccessTokenVO.getOpenid();
//            map.put("openId", openId);
//            map.put("alumni", alumniBackService.getAlumniInfo(openId));
//        }
//        map.put("jsSdkConfig", alumniBackService.getJsSdkConfig(request));//调用微信页面js sdk功能需要的配置信息
//        return "client/backAlumniInfo";
        map.put("msg", "功能正在开发中...");
        return "client/warning_msg";
    }

    @RequestMapping(value = "/back-school", method = RequestMethod.POST, params = {"openId", "name", "contactType", "contactInfo"})
    public String handleAlumniInfo(HttpServletRequest request, AlumniPO alumniInfo, ModelMap map) {
        map.put("jsSdkConfig", alumniBackService.getJsSdkConfig(request));//调用微信页面js sdk功能需要的配置信息
        boolean optSuccess = false;
        if (alumniBackService.getAlumniInfo(alumniInfo.getOpenId()) == null) {//数据库中是不是已经存在记录
            optSuccess = alumniBackService.saveAlumniInfo(handleAlumniInfo(alumniInfo));//不存在则增加
        } else {
            optSuccess = alumniBackService.updateAlumniInfo(handleAlumniInfo(alumniInfo));//存在则更新
        }
        if (optSuccess) {//持久化到数据的操作成功
            map.put("openId", alumniInfo.getOpenId());
            return "client/backActivityInfo";
        } else {
            map.put("alumni", alumniInfo);
            return "client/backAlumniInfo";
        }
    }

    @RequestMapping(value = "/back-school", method = RequestMethod.POST, params = {"beginDate", "endDate", "alumniNum"})
    public String handleActivityInfo(HttpServletRequest request, BackActivityPO activityInfo, ModelMap map) {
        map.put("jsSdkConfig", alumniBackService.getJsSdkConfig(request));//调用微信页面js sdk功能需要的配置信息
        if (alumniBackService.getCurActivity(activityInfo.getOpenId()) == null) {//不存在已经提交，并且还没结束的返校活动
            if (alumniBackService.saveActivityInfo(activityInfo)) {
                map.put("msg", "信息提交成功！");
                return "client/success_msg";
            } else {
                map.put("openId", activityInfo.getOpenId());
                return "client/backActivityInfo";
            }
        } else {
            map.put("msg", "您当前存在尚未结束的返校活动，无法提交信息的返校信息！");
            return "client/warning_msg";
        }
    }

    private AlumniPO handleAlumniInfo(AlumniPO alumniInfo) {
        alumniInfo.setAcademy("".equals(alumniInfo.getAcademy()) ? null : alumniInfo.getAcademy());
        alumniInfo.setClassNO("".equals(alumniInfo.getClassNO()) ? null : alumniInfo.getClassNO());
        alumniInfo.setCompany("".equals(alumniInfo.getCompany()) ? null : alumniInfo.getCompany());
        alumniInfo.setJob("".equals(alumniInfo.getJob()) ? null : alumniInfo.getJob());
        alumniInfo.setMajor("".equals(alumniInfo.getMajor()) ? null : alumniInfo.getMajor());
        return alumniInfo;
    }

}
