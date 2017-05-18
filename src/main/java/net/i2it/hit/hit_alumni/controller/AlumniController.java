package net.i2it.hit.hit_alumni.controller;

import net.i2it.hit.hit_alumni.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 处理和微信服务器之间的网络交互操作
 */
@Controller
@RequestMapping("/wechat/alumni")
public class AlumniController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/back-school")
    public String getForm(HttpServletRequest request, ModelMap map) {
        map.put("jsSdkConfig", adminService.getJsSdkConfig(request));//调用微信页面js sdk功能需要的配置信息
        return "client/backAlumniInfo";
    }

}
