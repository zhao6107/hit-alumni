package net.i2it.hit.hit_alumni.controller;

import net.i2it.hit.hit_alumni.service.UserInfoService;
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
        System.out.println(itemInfo);
        System.out.println(code);
        System.out.println(new UserInfoService().getUserInfoFromWeb(code));
        return "client/payInfo";
    }

    @RequestMapping(value = "/pay", params = {"itemName", "itemDetail", "itemMoney"})
    public String pay(String itemName, String itemDetail, String itemMoney) {
        return "";
    }

}
