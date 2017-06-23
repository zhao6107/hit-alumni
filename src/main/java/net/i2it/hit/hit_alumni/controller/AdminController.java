package net.i2it.hit.hit_alumni.controller;

import net.i2it.hit.hit_alumni.entity.Pager;
import net.i2it.hit.hit_alumni.entity.po.BackActivityPO;
import net.i2it.hit.hit_alumni.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 管理后台
 *
 * @author liuming
 */
@Controller
@RequestMapping("/hit-alumni/wechat/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**************************************************
     * 获取返校信息列表
     **************************************************/

    @GetMapping("/activities")
    public String listActivityRecordByPage(@RequestParam(value = "page", required = false) Integer pageIndex,
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

}
