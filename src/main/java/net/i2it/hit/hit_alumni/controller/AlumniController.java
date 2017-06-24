package net.i2it.hit.hit_alumni.controller;

import net.i2it.hit.hit_alumni.constant.ConfigConsts;
import net.i2it.hit.hit_alumni.entity.po.AlumniPO;
import net.i2it.hit.hit_alumni.entity.po.BackActivityPO;
import net.i2it.hit.hit_alumni.entity.vo.api.response.WebAccessTokenVO;
import net.i2it.hit.hit_alumni.service.AlumniBackService;
import net.i2it.hit.hit_alumni.service.function.CommonService;
import net.i2it.hit.hit_alumni.service.function.WeChatApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * 校友返校活动
 */
@Controller
@RequestMapping("/hit-alumni/wechat/alumni")
public class AlumniController {

    //todo route优化、文件命名
    //todo 日志系统

    private String datePattern0 = "yyyy-MM-dd";
    private String datePattern1 = "yyyy-MM-dd HH:mm";

    @Autowired
    private AlumniBackService alumniBackService;
    @Autowired
    private CommonService commonService;

    //从微信公众号中的按钮对应的url跳转到返校信息列表页
    @GetMapping(value = "/back-school", params = {"code"})
    public String listActivityFromMenu(HttpServletRequest request, String code, ModelMap map) {
        map.put("jsSdkConfig", commonService.getJsSdkConfig(request));//调用微信页面js sdk功能需要的配置信息
        WeChatApi weChatApi = new WeChatApi();
        WebAccessTokenVO webAccessTokenVO = weChatApi.getWebAccessToken(code);
        if (webAccessTokenVO != null) {//调用api获取access_token失败
            String openId = webAccessTokenVO.getOpenid();
            Map<Long, Object> activityMap = alumniBackService.divideActivities(openId);
            //返回到我的返校活动列表页
            map.put("openId", openId);
            map.put("activities", activityMap);
            return "client/postedActivities";
        }
        map.put("msg", "网络请求出错！");
        return "client/warning_msg";
    }

    //在已知openId时，跳转到返校信息列表页
    @GetMapping(value = "/activities", params = {"openId"})
    public String listActivity(HttpServletRequest request, String openId, ModelMap map) {
        map.put("jsSdkConfig", commonService.getJsSdkConfig(request));//调用微信页面js sdk功能需要的配置信息
        Map<Long, Object> activityMap = alumniBackService.divideActivities(openId);
        //返回到我的返校活动列表页
        map.put("openId", openId);
        map.put("activities", activityMap);
        return "client/postedActivities";
    }

    //获取某个返校活动的信息
    @GetMapping(value = "/back-school/{id}")
    public String getActivityInfo(HttpServletRequest request, @PathVariable("id") Integer id, ModelMap map) {
        map.put("jsSdkConfig", commonService.getJsSdkConfig(request));//调用微信页面js sdk功能需要的配置信息
        map.put("activity", alumniBackService.getActivityInfoById(id));
        return "client/backActivityInfo";
    }

    //用户点击添加返校信息按钮
    @GetMapping(value = "/back-school", params = {"openId"})
    public String getFormPage(HttpServletRequest request, String openId, ModelMap map) {
        map.put("jsSdkConfig", commonService.getJsSdkConfig(request));//调用微信页面js sdk功能需要的配置信息
        //先检验是否存在未结束的返校活动
        if (alumniBackService.getCurActivity(openId) == null) {//不存在时才可以提交新的返校信息
            map.put("openId", openId);
            map.put("alumni", alumniBackService.getAlumniInfo(openId));
            return "client/backAlumniInfo";
        }
        //存在时，先跳转到提示信息页，再返回返校信息列表页
        map.put("targetUrl", ConfigConsts.getServer_domain_url() + "/wechat/alumni/activities?openId=" + openId);
        map.put("msg", "您当前存在未结束的返校活动，无法添加新的返校信息，系统正在为您跳转...");
        return "client/loading";
    }

    @PostMapping(value = "/back-school", params = {"openId", "name", "contactType", "contactInfo"})
    public String handleAlumniInfo(HttpServletRequest request, AlumniPO alumniInfo, ModelMap map) {
        map.put("jsSdkConfig", commonService.getJsSdkConfig(request));//调用微信页面js sdk功能需要的配置信息
        boolean optSuccess;
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

    @GetMapping(value = "/back-school/activity", params = {"openId"})
    public String linkToActivityPage(HttpServletRequest request, String openId, ModelMap map) {
        map.put("jsSdkConfig", commonService.getJsSdkConfig(request));//调用微信页面js sdk功能需要的配置信息
        map.put("openId", openId);
        return "client/backActivityInfo";
    }

    // TODO 参数的获取及赋值待优化
    @RequestMapping(value = "/back-school", method = RequestMethod.POST, params = {"beginDate", "endDate", "alumniNum"})
    public String handleActivityInfo(HttpServletRequest request, ModelMap map,
                                     @RequestParam(value = "id", required = false) Integer id,
                                     @RequestParam("openId") String openId,
                                     @RequestParam("beginDate") String beginDate,
                                     @RequestParam("endDate") String endDate,
                                     @RequestParam("alumniNum") int alumniNum,
                                     @RequestParam(value = "historyMuseumVisitedDate", required = false) String historyMuseumVisitedDate,
                                     @RequestParam(value = "astronauticsMuseumVisitedDate", required = false) String astronauticsMuseumVisitedDate,
                                     @RequestParam(value = "schoolMuseumVisitedDate", required = false) String schoolMuseumVisitedDate,
                                     @RequestParam(value = "meetAlumniAssociation", defaultValue = "0") int meetAlumniAssociation,
                                     @RequestParam(value = "acceptInterview", defaultValue = "0") int acceptInterview,
                                     @RequestParam(value = "giveLecture", defaultValue = "0") int giveLecture,
                                     @RequestParam(value = "needVolunteer", defaultValue = "0") int needVolunteer
    ) {
        map.put("jsSdkConfig", commonService.getJsSdkConfig(request));//调用微信页面js sdk功能需要的配置信息
        BackActivityPO activityInfo = new BackActivityPO(id, openId,
                str2Date(beginDate, datePattern0), str2Date(endDate, datePattern0), alumniNum,
                str2Date(historyMuseumVisitedDate, datePattern1), str2Date(astronauticsMuseumVisitedDate, datePattern1),
                str2Date(schoolMuseumVisitedDate, datePattern1),
                meetAlumniAssociation, acceptInterview, giveLecture, needVolunteer);
        if (!(dateIsValid(activityInfo.getHistoryMuseumVisitedDate(), activityInfo)
                && dateIsValid(activityInfo.getAstronauticsMuseumVisitedDate(), activityInfo)
                && dateIsValid(activityInfo.getSchoolMuseumVisitedDate(), activityInfo))) {
            map.put("msg", "参观项目的日期范围不在返校活动日期范围之内！");
            return "client/warning_msg";
        }
        if (id == null) {//表示是新添加返校活动
            if (alumniBackService.saveActivityInfo(activityInfo)) {
                map.put("msg", "信息提交成功！");
                return "client/success_msg";
            } else {
                map.put("openId", activityInfo.getOpenId());
                return "client/backActivityInfo";
            }
        } else {
            if (alumniBackService.updateActivityInfo(activityInfo)) {
                map.put("msg", "返校活动信息更新成功！");
                return "client/success_msg";
            }
        }
        map.put("msg", "参数处理出错，请重新尝试！");
        return "client/warning_msg";
    }

    // 当字符串类型的变量内容为空字符串时，赋值为null
    private AlumniPO handleAlumniInfo(AlumniPO alumniInfo) {
        alumniInfo.setAcademy("".equals(alumniInfo.getAcademy()) ? null : alumniInfo.getAcademy());
        alumniInfo.setClassNO("".equals(alumniInfo.getClassNO()) ? null : alumniInfo.getClassNO());
        alumniInfo.setCompany("".equals(alumniInfo.getCompany()) ? null : alumniInfo.getCompany());
        alumniInfo.setJob("".equals(alumniInfo.getJob()) ? null : alumniInfo.getJob());
        alumniInfo.setMajor("".equals(alumniInfo.getMajor()) ? null : alumniInfo.getMajor());
        return alumniInfo;
    }

    //将从返校信息页提交的字符串日期信息转为Date类型的日期
    private Date str2Date(String dateStr, String pattern) {
        if (dateStr == null || dateStr.equals("")) {
            return null;
        }
        if (dateStr.contains("T")) {
            dateStr = dateStr.replaceAll("T", " ");
        }
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean dateIsValid(Date targetDate, BackActivityPO activityInfo) {
        if (targetDate == null) {
            return true;
        }
        if (targetDate.after(activityInfo.getBeginDate())
                && targetDate.before(activityInfo.getEndDate())) {
            return true;
        }
        return false;
    }

}
