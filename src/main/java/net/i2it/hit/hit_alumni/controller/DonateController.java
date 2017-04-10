package net.i2it.hit.hit_alumni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 关于捐助的前端控制器
 *
 * @author liuming
 */
@Controller
@RequestMapping(value = {"/donate", "/test"})
public class DonateController {

    @RequestMapping(value = "/info", params = {"itemName", "itemDetail", "itemMoney"})
    public String payForm(String itemName, String itemDetail, String itemMoney) {
        System.out.println(itemName);
        System.out.println(itemDetail);
        System.out.println(itemMoney);
        return "";
    }

    @RequestMapping(value = "/pay", params = {"itemName", "itemDetail", "itemMoney"})
    public String pay(String itemName, String itemDetail, String itemMoney) {
        return "";
    }

}
