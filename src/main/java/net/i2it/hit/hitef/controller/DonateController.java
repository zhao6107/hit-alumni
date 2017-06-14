package net.i2it.hit.hitef.controller;

import com.alibaba.fastjson.JSON;
import net.i2it.hit.hitef.constant.ConfigConsts;
import net.i2it.hit.hitef.domain.DonateFormVO;
import net.i2it.hit.hitef.domain.PrepayInfoVO;
import net.i2it.hit.hitef.entity.vo.DonatorVO;
import net.i2it.hit.hitef.entity.vo.api.request.PayRequestVO;
import net.i2it.hit.hitef.service.DonateService;
import net.i2it.hit.hitef.service.FundInfoService;
import net.i2it.hit.hitef.service.function.CommonService;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
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
@RequestMapping(value = {"/hitef/wechat/donate", "/hitef/wechat/test"})
public class DonateController {

    @Autowired
    private DonateService donateService;
    @Autowired
    private CommonService commonService;

    // 统一下单
    @GetMapping(params = {"code"})
    public String pay(String payInfo, String code, HttpServletRequest request, ModelMap modelMap) {
        modelMap.put("jsSdkConfig", commonService.getJsSdkConfig(request));//调用微信页面js sdk功能需要的配置信息
        PrepayInfoVO prepayInfoVO = donateService.getPrepayVO(payInfo);
        Map<String, Object> map = donateService.getPayRequestInfo(code, prepayInfoVO);
        modelMap.put("fundItemId", prepayInfoVO.getId());//统一下单后，商户订单号
        modelMap.put("out_trade_no", map.get("out_trade_no"));//统一下单后，商户订单号
        modelMap.put("payInfo", map.get("payRequestVO"));//页面发起js_api字符需要的配置信息
        return "client/payAction";
    }

    //支付成功后微信服务器发起通知的地址，需要返回特定信息，不然微信服务器会一直发信息请求确认
    @RequestMapping("/resultNofity")
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
    @GetMapping(params = {"action=getDonatorFormPage"})
    public String updateDonatorInfo(String outTradeNo, HttpServletRequest request, ModelMap map) {
        map.put("out_trade_no", outTradeNo);//支付单的对应的唯一id
        map.put("donateInfo", donateService.getDonateInfo(outTradeNo));
        map.put("jsSdkConfig", commonService.getJsSdkConfig(request));//调用微信页面js sdk功能需要的配置信息
        return "client/donatorForm";
    }

    //捐赠者信息提交之后，转入支付过程结束提示页面
    @PostMapping(params = {"action=updateDonatorInfo"})
    public String updateDonatorInfo(String outTradeNo, String comment, DonatorVO donatorVO, HttpServletRequest request, ModelMap map) {
        comment = "".equals(comment) ? null : comment;//但内容为空字符串时，赋值为null
        donatorVO = processDonatorVO(donatorVO);//但对象中的变量内容为空字符串时，赋值为null
        donateService.updateDonatorInfo(outTradeNo, comment, donatorVO);
        map.put("donatorName", donatorVO.getTrueName().equals("匿名") ? "校友" : donatorVO.getTrueName());
        map.put("out_trade_no", donateService.createCer(outTradeNo));//某个支付单对应的支付捐赠证书
        map.put("jsSdkConfig", commonService.getJsSdkConfig(request));//调用微信页面js sdk功能需要的配置信息
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
