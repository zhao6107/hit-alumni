package net.i2it.hit.hit_alumni.controller;

import net.i2it.hit.hit_alumni.constant.ConfigConsts;
import net.i2it.hit.hit_alumni.entity.vo.ItemVO;
import net.i2it.hit.hit_alumni.service.AdminService;
import net.i2it.hit.hit_alumni.service.function.WeChatApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 生成支付二维码的前段控制器
 *
 * @author liuming
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**************************************************
     * 获取全部没结束捐款项目的操作
     **************************************************/

    //列出所有没有结束的捐款项目
    @RequestMapping(value = "/item/list/not-expired", method = RequestMethod.GET)
    public String listNotExpiredItems(ModelMap map) {
        map.put("items", adminService.listNotExpiredItems());
        return "admin/allItems";
    }

    /**************************************************
     * 关于增加捐款项目的操作
     **************************************************/

    //返回添加捐款项目的界面
    @RequestMapping(value = "/item/add", method = RequestMethod.GET)
    public String addNewItem() {
        return "admin/itemForm";
    }

    //处理提交上来的添加捐款项目的信息，结束后返回到
    @RequestMapping(value = "/item/add", method = RequestMethod.POST)
    public String addNewItem(ItemVO itemVO) {
        if (adminService.saveItem(itemVO)) {
            return "redirect:/admin/item/list/not-expired";
        }
        return "redirect:/admin/item/add";
    }

    /**************************************************
     * 关于修改捐款项目的操作
     **************************************************/

    //获取修改捐款项目的界面
    @RequestMapping(value = "/item/{id}/update", method = RequestMethod.GET)
    public String updateItem(@PathVariable int id, ModelMap map) {
        map.put("item", adminService.getItem(id));
        return "admin/itemForm";
    }

    //处理提交上来的添加捐款项目的信息，结束后返回到
    @RequestMapping(value = "/item/{id}/update", method = RequestMethod.POST)
    public String updateItem(@PathVariable int id, ItemVO itemVO) {
        if (adminService.updateItem(id, itemVO)) {
            return "redirect:/admin/item/list/not-expired";
        }
        return "redirect:/admin/item/add";
    }

    /**************************************************
     * 生成捐款二维码的操作
     **************************************************/

    @RequestMapping(value = "/item/qrcode", method = RequestMethod.GET)
    public String createQRCode(ModelMap map) {
        String targetUrl = ConfigConsts.PAY_URL;
        String url = WeChatApi.API_WEB_CODE.replace("APPID", ConfigConsts.APP_ID)
                .replace("SCOPE", "snsapi_base").replace("STATE", "hit-alumni");
        map.put("url", url);
        map.put("targetUrl", targetUrl);
        return "admin/qrCode";
    }

}
