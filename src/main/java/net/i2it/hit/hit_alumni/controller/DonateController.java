package net.i2it.hit.hit_alumni.controller;

import net.i2it.hit.hit_alumni.constant.ConfigConsts;
import net.i2it.hit.hit_alumni.entity.po.ItemPO;
import net.i2it.hit.hit_alumni.entity.vo.DonatorVO;
import net.i2it.hit.hit_alumni.entity.vo.SimpleOrderInfoVO;
import net.i2it.hit.hit_alumni.entity.vo.api.request.JsSdkConfigVO;
import net.i2it.hit.hit_alumni.service.AdminService;
import net.i2it.hit.hit_alumni.service.DonateService;
import net.i2it.hit.hit_alumni.service.function.WeChatApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 关于捐助的前端控制器
 *
 * @author liuming
 */
@Controller
@RequestMapping(value = {"/donate", "/test"})
public class DonateController {

    @Autowired
    private DonateService donateService;
    @Autowired
    private AdminService adminService;

    /**
     * 对应着直接信息填写支付页面
     *
     * @param request
     * @param itemInfo
     * @param code
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/pay", method = RequestMethod.GET)
    public String pay(HttpServletRequest request, String itemInfo, String code, ModelMap modelMap) {
        SimpleOrderInfoVO simpleOrderInfo = donateService.getSimpleOrderInfo(itemInfo);
        Map<String, Object> map = donateService.getPayRequestInfo(code, simpleOrderInfo);
        JsSdkConfigVO jsSdkConfigVO = donateService.getJsSdkConfig(request);
        modelMap.put("item_no", simpleOrderInfo.getItemId());
        modelMap.put("payInfo", map.get("payRequestVO"));
        modelMap.put("jsSdkConfig", jsSdkConfigVO);
        modelMap.put("out_trade_no", map.get("out_trade_no"));
        modelMap.put("serverUrl", ConfigConsts.getServer_domain_url());
        return "client/payAction";
    }

    /**
     * 支付成功后微信服务器通知地址
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/notify")
    public void notifyResult(HttpServletRequest request, HttpServletResponse response) {
        //获取支付成功后微信服务器返回的支付成功通知
        response.setContentType("text/xml");
        PrintWriter out = null;
        ServletInputStream in;
        StringBuffer sb = new StringBuffer();
        try {
            out = response.getWriter();

            in = request.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            while ((len = in.read(bytes)) > 0) {
                sb.append(new String(bytes, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //对通知中的信息可以进行二次校验
        if (donateService.updatePayState(sb.toString())) {
            out.write("SUCCESS");
            out.flush();
        }
    }

    @RequestMapping(value = "/donator-info", method = RequestMethod.GET)
    public String updateDonatorInfo(String item_no, String out_trade_no, ModelMap map) {
        donateService.updateRaisedFund(item_no, out_trade_no);
        map.put("out_trade_no", out_trade_no);
        return "client/donatorForm";
    }

    @RequestMapping(value = "/donator-info", method = RequestMethod.POST)
    public String updateDonatorInfo(String out_trade_no, String comment, DonatorVO donatorVO, ModelMap map) {
        donateService.updateDonatorInfo(out_trade_no, comment, donatorVO);
        map.put("out_trade_no", donateService.createCer(out_trade_no));
        return "client/payResult";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listItems(ModelMap map) {
        map.put("items", adminService.listNotExpiredItems());
        return "client/allItems";
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public String listItems(@PathVariable int id, ModelMap map) {
        ItemPO item = adminService.getItem(id);
        map.put("item", item);
        map.put("redirectUrl", ConfigConsts.getPay_url());
        map.put("targetUrl", WeChatApi.API_WEB_CODE.replace("APPID", ConfigConsts.getApp_id())
                .replace("SCOPE", "snsapi_base").replace("STATE", "hit-alumni"));
        return "client/payForm";
    }

}
