package net.i2it.hit.hit_alumni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 生成支付二维码的前段控制器
 *
 * @author liuming
 */
@Controller
@RequestMapping("/qrcode")
public class QRCodeController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "admin/qrCode";
    }

    /**
     * 此方法用于后台生成带有链接（支付二维码或者某个含参数url）的二维码，因为与
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create() {
        //二维码生成并返回
        return "admin/qrCode";
    }

}
