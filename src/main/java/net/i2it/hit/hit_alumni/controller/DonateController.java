package net.i2it.hit.hit_alumni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 关于捐助的前端控制器
 * @author liuming
 */
@Controller
@RequestMapping(value = { "/donate", "/test" })
public class DonateController {

	@RequestMapping("/pay")
	public String pay() {
		return "";
	}

}
