package net.i2it.hit.hit_alumni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 处理和微信服务器之间的网络交互操作
 */
@Controller
@RequestMapping("/wechat/alumni")
public class AlumniController {

    @RequestMapping(value = "/back-school")
    public String getForm() {
        return "client/alumniForm";
    }

}
