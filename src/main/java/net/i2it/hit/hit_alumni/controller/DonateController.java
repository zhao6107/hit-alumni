package net.i2it.hit.hit_alumni.controller;

import net.i2it.hit.hit_alumni.business.DonateBusiness;
import net.i2it.hit.hit_alumni.entity.vo.JsSdkConfigVO;
import net.i2it.hit.hit_alumni.entity.vo.PayRequestVO;
import net.i2it.hit.hit_alumni.entity.vo.SimpleOrderInfoVO;
import net.i2it.hit.hit_alumni.entity.vo.api.response.UnifiedOrderResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * 关于捐助的前端控制器
 *
 * @author liuming
 */
@Controller
@RequestMapping(value = {"/donate", "/test"})
public class DonateController {

    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public String pay(HttpServletRequest request, String itemInfo, String code, ModelMap map) {
        DonateBusiness donateBusiness = new DonateBusiness();
        SimpleOrderInfoVO simpleOrderInfo = donateBusiness.getSimpleOrderInfo(itemInfo);
        UnifiedOrderResultVO unifiedOrderResult = null;
        if (simpleOrderInfo != null) {
            unifiedOrderResult = donateBusiness.getUnifiedOrderResult(code, simpleOrderInfo);
        }
        PayRequestVO payRequestVO = donateBusiness.getPayRequestInfo("prepay_id=" + ((unifiedOrderResult != null) ? unifiedOrderResult.getPrepay_id() : "0123456789"));
        JsSdkConfigVO jsSdkConfigVO = donateBusiness.getJsSdkConfig(request);
        map.put("simpleOrder", simpleOrderInfo);
        map.put("payInfo", payRequestVO);
        map.put("jsSdkConfig", jsSdkConfigVO);
        return "client/payInfo";
    }

    @RequestMapping(value = "/result")
    public String notifyResult() {
        return "client/payResult";
    }

}
