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
@RequestMapping("/admin")
public class QRCodeController {

    @RequestMapping(value = "/qrcode", method = RequestMethod.GET)
    public String index(ModelMap map) {
        String targetUrl = ConfigConsts.SERVER_DOMAIN + "/test/pay/";
        String url = WeChatApiService.API_WEB_CODE.replace("APPID", ConfigConsts.APP_ID)
                .replace("SCOPE", "snsapi_base").replace("STATE", "hit-alumni");
        map.put("url", url);
        map.put("targetUrl", targetUrl);
        return "admin/qrCode";
    }

}
