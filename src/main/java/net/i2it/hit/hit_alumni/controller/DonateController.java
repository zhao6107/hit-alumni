package net.i2it.hit.hit_alumni.controller;

import net.i2it.hit.hit_alumni.business.DonateBusiness;
import net.i2it.hit.hit_alumni.entity.vo.UnifiedOrderResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 关于捐助的前端控制器
 *
 * @author liuming
 */
@Controller
@RequestMapping(value = {"/donate", "/test"})
public class DonateController {

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String payForm(String itemInfo, String code) {
        DonateBusiness donateBusiness = new DonateBusiness();
        UnifiedOrderResultVO unifiedOrderResult = donateBusiness.getUnifiedOrderResult(itemInfo, code);
        System.out.println(unifiedOrderResult.getPrepay_id());
        return "client/payInfo";
    }

    @RequestMapping(value = "/pay", params = {"itemName", "itemDetail", "itemMoney"})
    public String pay(String itemName, String itemDetail, String itemMoney) {
        return "";
    }

    @RequestMapping(value = "/result")
    public String notifyResult() {
        return "";
    }

}
