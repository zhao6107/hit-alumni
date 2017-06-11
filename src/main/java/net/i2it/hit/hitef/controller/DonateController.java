package net.i2it.hit.hitef.controller;

import net.i2it.hit.hitef.constant.ConfigConsts;
import net.i2it.hit.hitef.domain.FundInfo;
import net.i2it.hit.hitef.domain.PrepayVO;
import net.i2it.hit.hitef.entity.po.ItemPO;
import net.i2it.hit.hitef.entity.vo.DonatorVO;
import net.i2it.hit.hitef.entity.vo.SimpleOrderInfoVO;
import net.i2it.hit.hitef.service.AdminService;
import net.i2it.hit.hitef.service.DonateService;
import net.i2it.hit.hitef.service.FundInfoService;
import net.i2it.hit.hitef.service.function.CommonService;
import net.i2it.hit.hitef.service.function.WeChatApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 关于捐助的前端控制器
 *
 * @author liuming
 */
@Controller
//@RequestMapping(value = {"/hitef/wechat/donate", "/hitef/wechat/test"})
@RequestMapping(value = {"/wechat/donate", "/wechat/test"})
public class DonateController {

    @Autowired
    private DonateService donateService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private FundInfoService fundInfoService;
    @Autowired
    private CommonService commonService;

    //显示捐款倡议书
    @RequestMapping(value = "/call", method = RequestMethod.GET)
    public String callOn(HttpServletRequest request, ModelMap map) {
        map.put("jsSdkConfig", donateService.getJsSdkConfig(request));//调用微信页面js sdk功能需要的配置信息
        return "client/donateCall";
    }

    //显示所有的筹款项目页面
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listItems(HttpServletRequest request, ModelMap map) {
        map.put("fundItems", fundInfoService.getNormalFundInfos());
        map.put("jsSdkConfig", donateService.getJsSdkConfig(request));//调用微信页面js sdk功能需要的配置信息
        return "client/fundList";
    }

    //进入某一个筹款项目的页面
    @RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
    public String showOneItem(@PathVariable("id") int id, HttpServletRequest request, ModelMap map) {
        map.put("jsSdkConfig", commonService.getJsSdkConfig(request));//调用微信页面js sdk功能需要的配置信息
        FundInfo fundInfo = fundInfoService.getFundItemById(id);
        map.put("item", fundInfo);//获取某个筹款项目的信息
        map.put("redirectUrl", ConfigConsts.getPay_url());//对应着实际支付动作的url页面
        //拉取用户openid的url拼接
        map.put("targetUrl", WeChatApi.API_WEB_CODE.replace("APPID", ConfigConsts.getApp_id())
                .replace("SCOPE", "snsapi_base").replace("STATE", "hit-alumni"));
        return "client/payForm";
    }

    // 实际的支付动作发生界面
    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public String pay(HttpServletRequest request, String itemInfo, String code, ModelMap modelMap) {
        modelMap.put("jsSdkConfig", commonService.getJsSdkConfig(request));//调用微信页面js sdk功能需要的配置信息
        PrepayVO prepayVO = donateService.getPrepayVO(itemInfo);
        Map<String, Object> map = donateService.getPayRequestInfo(code, prepayVO);
        modelMap.put("item_no", prepayVO.getId());//筹款项目的唯一id
        modelMap.put("payInfo", map.get("payRequestVO"));//页面发起js_api字符需要的配置信息
        modelMap.put("out_trade_no", map.get("out_trade_no"));//统一下单后，商户订单号
        modelMap.put("serverUrl", ConfigConsts.getServer_domain_url());//对应着服务的根目录url
        return "client/payAction";
    }

    //支付成功后微信服务器发起通知的地址，需要返回特定信息，不然微信服务器会一直发信息请求确认
    @RequestMapping(value = "/notify")
    @ResponseBody
    public String notifyResult(HttpServletRequest request, HttpServletResponse response) {
        //获取支付成功后微信服务器返回的支付成功通知
        response.setContentType("text/xml");
        ServletInputStream in;
        StringBuffer sb = new StringBuffer();
        try {
            in = request.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = in.read(bytes)) > 0) {
                sb.append(new String(bytes, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //对通知中的信息可以进行二次校验
        if (donateService.updatePayState(sb.toString())) {
            return "SUCCESS";
        }
        return "";
    }

    //成功支付后进入捐赠者信息填写页
    @RequestMapping(value = "/donator-info", method = RequestMethod.GET)
    public String updateDonatorInfo(String item_no, String out_trade_no, HttpServletRequest request, ModelMap map) {
        map.put("out_trade_no", out_trade_no);//支付单的对应的唯一id
        map.put("donateInfo", donateService.getDonateInfo(out_trade_no));
        map.put("jsSdkConfig", donateService.getJsSdkConfig(request));//调用微信页面js sdk功能需要的配置信息
        return "client/donatorForm";
    }

    //捐赠者信息提交之后，转入支付过程结束提示页面
    @RequestMapping(value = "/donator-info", method = RequestMethod.POST)
    public String updateDonatorInfo(String out_trade_no, String comment, DonatorVO donatorVO, HttpServletRequest request, ModelMap map) {
        comment = "".equals(comment) ? null : comment;//但内容为空字符串时，赋值为null
        donatorVO = processDonatorVO(donatorVO);//但对象中的变量内容为空字符串时，赋值为null
        donateService.updateDonatorInfo(out_trade_no, comment, donatorVO);
        map.put("out_trade_no", donateService.createCer(out_trade_no));//某个支付单对应的支付捐赠证书
        map.put("jsSdkConfig", donateService.getJsSdkConfig(request));//调用微信页面js sdk功能需要的配置信息
        return "client/payResult";
    }

    private DonatorVO processDonatorVO(DonatorVO donatorVO) {
        donatorVO.setCompany("".equals(donatorVO.getCompany()) ? null : donatorVO.getCompany());
        donatorVO.setEntryYear("".equals(donatorVO.getEntryYear()) ? null : donatorVO.getEntryYear());
        donatorVO.setJob("".equals(donatorVO.getJob()) ? null : donatorVO.getJob());
        donatorVO.setMailAddr("".equals(donatorVO.getMailAddr()) ? null : donatorVO.getMailAddr());
        donatorVO.setMajor("".equals(donatorVO.getMajor()) ? null : donatorVO.getMajor());
        donatorVO.setPhone("".equals(donatorVO.getPhone()) ? null : donatorVO.getPhone());
        donatorVO.setTrueName("".equals(donatorVO.getTrueName()) ? null : donatorVO.getTrueName());
        return donatorVO;
    }

    @GetMapping("/tmp")
    public String tmp(ModelMap map) {
        map.put("msg", "功能开发中...");
        return "client/warning_msg";
    }

}
