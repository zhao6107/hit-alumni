package net.i2it.hit.hit_alumni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.i2it.hit.hit_alumni.business.DonateBusiness;
import net.i2it.hit.hit_alumni.entity.vo.PayRequestVO;
import net.i2it.hit.hit_alumni.entity.vo.SimpleOrderInfoVO;
import net.i2it.hit.hit_alumni.entity.vo.api.response.UnifiedOrderResultVO;

/**
 * 关于捐助的前端控制器
 *
 * @author liuming
 */
@Controller
@RequestMapping(value = {"/donate", "/test"})
public class DonateController {

    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public String payForm(String itemInfo, String code, ModelMap map) {
        System.out.println(itemInfo);
        DonateBusiness donateBusiness = new DonateBusiness();
        SimpleOrderInfoVO simpleOrderInfo = donateBusiness.getSimpleOrderInfo(itemInfo);
        System.out.println(simpleOrderInfo.getItemName() + " " + simpleOrderInfo.getItemDetail());
        UnifiedOrderResultVO unifiedOrderResult = donateBusiness.getUnifiedOrderResult(code, simpleOrderInfo);
        PayRequestVO payRequestVO = donateBusiness.getPayRequestInfo("prepay_id=" + unifiedOrderResult.getPrepay_id());
        map.put("simpleOrder", simpleOrderInfo);
        map.put("payInfo", payRequestVO);
        return "client/payInfo";
    }

    @RequestMapping(value = "/pay2")
    public String pay() {
        return "client/payResult";
    }

    @RequestMapping(value = "/result")
    public String notifyResult() {
        return "client/payResult";
    }

}
