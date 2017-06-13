package net.i2it.hit.hitef.controller;

import net.i2it.hit.hitef.constant.ConfigConsts;
import net.i2it.hit.hitef.entity.Pager;
import net.i2it.hit.hitef.entity.po.BackActivityPO;
import net.i2it.hit.hitef.domain.DonateRecordDO;
import net.i2it.hit.hitef.entity.po.QRCodeItemPO;
import net.i2it.hit.hitef.entity.vo.ItemVO;
import net.i2it.hit.hitef.service.AdminService;
import net.i2it.hit.hitef.service.function.WeChatApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 生成支付二维码的前段控制器
 *
 * @author liuming
 */
@Controller
@RequestMapping("/wechat/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**************************************************
     * 获取捐款项目集合的操作
     **************************************************/

    @GetMapping(value = "/items")
    public String listNotExpiredItems(@RequestParam(value = "status", required = false) String status,
                                      ModelMap map) {
        if ("on".equals(status)) {//正常进行的捐款项目（没有终止或者结束）
            map.put("status", "on");
            map.put("items", adminService.listNotExpiredItems());
            return "admin/allItems";
        } else if ("off".equals(status)) {//已经结束的捐款项目
            map.put("items", adminService.listExpiredItems());
            map.put("status", "off");
            return "admin/allItems";
        }
        return "redirect:/wechat/admin/items?status=on";//正常进行的捐款项目（没有终止或者结束）
    }

    /**************************************************
     * 关于增加捐款项目的操作
     **************************************************/

    //返回添加捐款项目的界面
    @GetMapping(value = "/items", params = {"opt"})
    public String addNewItem(String opt, ModelMap map) {
        if ("add".equals(opt)) {//增加新的捐款项目操作
            map.put("opt", "add");
            return "admin/itemForm";
        }
        return "redirect:/wechat/admin/items?status=on";
    }

    //处理提交上来的添加捐款项目的信息，结束后返回到
    @PostMapping(value = "/items")
    public String addNewItem(ItemVO itemVO) {
        if (adminService.saveItem(itemVO)) {
            return "redirect:/wechat/admin/items?status=on";
        }
        return "redirect:/wechat/admin/items?opt=add";
    }

    /**************************************************
     * 关于修改捐款项目的操作
     **************************************************/

    //获取修改捐款项目的界面
    @GetMapping(value = "/items/{id}")
    public String updateItem(@PathVariable("id") int id,
                             @RequestParam(value = "opt", required = false) String opt, ModelMap map) {
        if ("update".equals(opt)) {
            map.put("opt", "update");
            map.put("item", adminService.getItem(id));
            return "admin/itemForm";
        } else if ("finish".equals(opt)) {
            adminService.updateItemTimeEnd(id);
            return "redirect:/wechat/admin/items?status=on";
        } else if ("recover".equals(opt)) {
            adminService.recoverItem(id);
            return "redirect:/wechat/admin/items?status=on";
        }
        return "redirect:/wechat/admin/items/" + id;
    }

    //处理提交上来的添加捐款项目的信息，结束后返回到
    @PostMapping(value = "/items/{id}")
    public String updateItem(@PathVariable("id") int id, ItemVO itemVO) {
        if (adminService.updateItem(id, itemVO)) {
            return "redirect:/wechat/admin/items?status=on";
        }
        return "redirect:/wechat/admin/items/" + id;
    }

    /**************************************************
     * 获取捐款成功的列表
     **************************************************/

    @GetMapping("/donate")
    public String listDonateRecordByPage(@RequestParam(value = "page", required = false, defaultValue = "1") Integer pageIndex,
                                         ModelMap map) {
        Pager<DonateRecordDO> pageData;
        if (pageIndex != null && pageIndex > 0) {
            pageData = adminService.getDonatePage(pageIndex, 20);
        } else {
            pageData = adminService.getDonatePage(1, 20);
        }
        map.put("pageDonates", pageData);
        return "admin/donateList";
    }

    @GetMapping("/donate/{id}")
    public String getDonateInfo(@PathVariable("id") String id, ModelMap map) {
        map.put("donateInfo", adminService.getDonateInfo(id));
        return "admin/donateInfo";
    }

    /**************************************************
     * 获取返校信息列表
     **************************************************/

    @GetMapping("/activities")
    public String listActivityRecordByPage(@RequestParam(value = "page", required = false, defaultValue = "1") Integer pageIndex,
                                           ModelMap map) {
        Pager<BackActivityPO> pageData;
        if (pageIndex != null && pageIndex > 0) {
            pageData = adminService.getActivityPage(pageIndex, 20);
        } else {
            pageData = adminService.getActivityPage(1, 20);
        }
        map.put("pageActivities", pageData);
        return "admin/activityList";
    }

    @GetMapping("/activities/{id}")
    public String getAlumniInfo(@PathVariable("id") String id, ModelMap map) {
        map.put("alumniInfo", adminService.getAlumniInfo(id));
        return "admin/alumniInfo";
    }

    /**************************************************
     * 对二维码方式筹款的项目进行管理
     **************************************************/
    @GetMapping("/qrcode-items")
    public String listQRCodeItems(@RequestParam(value = "opt", required = false) String opt, ModelMap map) {
        if ("add".equals(opt)) {
            map.put("opt", opt);
            return "admin/qrcodeItem";
        }
        map.put("items", adminService.getAllQRCodeItems());
        return "admin/qrcodeItems";
    }

    @PostMapping("/qrcode-items")
    public String addQRCodeItem(QRCodeItemPO item, ModelMap map) {
        adminService.addQRCodeItem(item);
        return "redirect:/wechat/admin/qrcode-items";
    }

    @GetMapping("/qrcode-items/{id}")
    public String listQRCodeItems(@PathVariable("id") int id,
                                  @RequestParam(value = "opt", required = false) String opt, ModelMap map) {
        if ("update".equals(opt)) {
            map.put("opt", opt);
            map.put("item", adminService.getQRCodeItem(id));
            return "admin/qrcodeItem";
        } else if ("del".equals(opt)) {
            adminService.delQRCodeItem(id);
            return "redirect:/wechat/admin/qrcode-items";
        }else if("qrcode".equals(opt)){
            String targetUrl = ConfigConsts.getPay_url();
            String url = WeChatApi.API_WEB_CODE.replace("APPID", ConfigConsts.getApp_id())
                    .replace("SCOPE", "snsapi_base").replace("STATE", "hit-alumni");
            map.put("url", url);
            map.put("targetUrl", targetUrl);
            map.put("item", adminService.getQRCodeItem(id));
            return "admin/qrCode";
        }
        map.put("items", adminService.getAllQRCodeItems());
        return "admin/qrcodeItems";
    }

    @PostMapping("/qrcode-items/{id}")
    public String updateQRCodeItem(QRCodeItemPO item, ModelMap map) {
        adminService.updateQRCodeItem(item);
        return "redirect:/wechat/admin/qrcode-items";
    }

}
