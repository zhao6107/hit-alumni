package net.i2it.hit.hit_alumni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * 关于捐助的前端控制器
 *
 * @author liuming
 */
@Controller
@RequestMapping(value = {"/donate", "/test"})
public class DonateController {

    @RequestMapping(value = "/form", params = {"itemName", "itemDetail", "itemMoney"}, method = RequestMethod.GET)
    public String payForm(String itemName, String itemDetail, String itemMoney, Map<String, String> map) {
        System.out.println(itemName);
        System.out.println(itemDetail);
        System.out.println(itemMoney);
        map.put("itemName", itemName);
        map.put("itemDetail", itemDetail);
        map.put("itemMoney", itemMoney);
        return "client/payInfo";
    }

    @RequestMapping(value = "/pay", params = {"itemName", "itemDetail", "itemMoney"})
    public String pay(String itemName, String itemDetail, String itemMoney) {
        return "";
    }

}
