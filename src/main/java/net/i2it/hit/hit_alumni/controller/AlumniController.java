package net.i2it.hit.hit_alumni.controller;

import net.i2it.hit.hit_alumni.constant.ConfigConsts;
import net.i2it.hit.hit_alumni.util.EncryptionUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.PrintWriter;
import java.util.Arrays;

/**
 * 处理和微信服务器之间的网络交互操作
 */
@Controller
@RequestMapping("/alumni")
public class AlumniController {

    @RequestMapping(value = "/back-school")
    public String getForm() {
        return "client/alumniForm";
    }

}
