package net.i2it.hit.hitef.controller;

import net.i2it.hit.hitef.domain.FundItemDO;
import net.i2it.hit.hitef.service.FundInfoService;
import net.i2it.hit.hitef.service.function.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hitef/wechat")
public class FundItemController {

    private static final String PAGE_URI = "redirect:/hitef/wechat/items?type=1";

    @Autowired
    private CommonService commonService;
    @Autowired
    private FundInfoService fundInfoService;

    @GetMapping(value = "/items")
    public String showFundItemsByType(@RequestParam(value = "q", required = false) String q,
                                      @RequestParam(value = "type", required = false) Integer type,
                                      @RequestParam(value = "opt", required = false) String opt,
                                      HttpServletRequest request, ModelMap map) {
        if (q != null) {
            map.put("jsSdkConfig", commonService.getJsSdkConfig(request));//调用微信页面js sdk功能需要的配置信息
            if ("school".equals(q)) {
                map.put("fundItems", fundInfoService.getSchoolNormalFundItems());
                return "client/fundList";
            } else if ("academy".equals(q)) {
                map.put("fundItems", fundInfoService.getAcademyNormalFundItems());
                return "client/fundList";
            }
        }

        if (opt != null && "add".equals(opt)) {//新增基金信息动作
            map.put("opt", "add");
            map.put("fundTypes", fundInfoService.getAllFundTypes());
            return "admin/fundItemForm";
        }
        if (type != null && type == 0) {//终止的基金项目
            map.put("fundItems", fundInfoService.getStopedFundInfos());
        } else {//正常进行的基金项目
            map.put("fundItems", fundInfoService.getNormalFundInfos());
        }
        return "admin/fundItems";
    }

    @PostMapping(value = "/items")
    public String addFundItem(FundItemDO fundItem) {
        int tmp = (int) (System.currentTimeMillis() / 1000);
        fundItem.setStatus(1);
        fundItem.setCtime(tmp);
        fundItem.setUtime(tmp);
        fundInfoService.isSaved(fundItem);
        return PAGE_URI;
    }

    @GetMapping(value = "/items/{id}")
    public String updateFundItem(@PathVariable(value = "id", required = false) Integer id,
                                 @RequestParam(value = "opt", required = false) String opt, ModelMap map) {
        if (id == null) {
            return PAGE_URI;
        }
        //先判断该id的基金项目是否存在
        FundItemDO fundItemDO = fundInfoService.getFundItemById(id);
        if (fundItemDO == null) {//不存在
            return PAGE_URI;
        }
        //基金项目存在时
        if (opt == null || "update".equals(opt)) {//修改基金项目信息
            map.put("opt", "update");
            map.put("fundTypes", fundInfoService.getAllFundTypes());
            map.put("fundItem", fundItemDO);
            return "admin/fundItemForm";
        } else if ("stop".equals(opt) && fundInfoService.isStoped(id)) {
            return PAGE_URI;
        }
        return PAGE_URI;
    }

    @PutMapping("/items/{id}")
    public String updateFundItem(@PathVariable("id") Integer id, FundItemDO fundItem) {
        if (id == null) {
            return PAGE_URI;
        }
        //先判断该id的基金项目是否存在
        FundItemDO fundItemDO = fundInfoService.getFundItemById(id);
        if (fundItemDO == null) {//不存在
            return PAGE_URI;
        }
        //基金项目存在
        fundItem.setId(id);
        fundItem.setUtime((int) (System.currentTimeMillis() / 1000));//获取1970年1月1日0时起的秒数
        if (fundInfoService.isUpdated(fundItem)) {//更新成功
            return PAGE_URI;
        }
        return PAGE_URI;
    }

}
