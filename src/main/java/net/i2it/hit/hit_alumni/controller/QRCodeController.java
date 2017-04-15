package net.i2it.hit.hit_alumni.controller;

import net.i2it.hit.hit_alumni.constant.ConfigConsts;
import net.i2it.hit.hit_alumni.service.WeChatApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    public String index(ModelMap map) {
        String targetUrl = ConfigConsts.SERVER_DOMAIN + "/test/pay";
        String url = WeChatApiService.API_WEB_CODE.replace("APPID", ConfigConsts.APP_ID)
                .replace("SCOPE", "snsapi_base").replace("STATE", "hit-alumni");
        map.put("url", url);
        map.put("targetUrl", targetUrl);
        return "admin/qrCode";
    }

    /**
     * 此方法用于后台生成带有链接（支付二维码或者某个含参数url）的二维码，因为与
     *
     * @return
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create() {
        // 二维码生成并返回
        return "admin/qrCode";
    }

}
