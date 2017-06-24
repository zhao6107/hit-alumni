package net.i2it.hit.hit_alumni.service.function;

import com.alibaba.fastjson.JSON;
import net.i2it.hit.hit_alumni.constant.ConfigConsts;
import net.i2it.hit.hit_alumni.entity.vo.api.request.MenuVO;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 创建微信菜单的具体操作业务
 * Created by liuming on 2017/4/21.
 */
public class MenuOption {

    public boolean create() {
        String menuStr = null;
        try {
            menuStr = this.getMenuStr();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new WeChatApi().createMenu(menuStr);
    }

    private String getMenuStr() throws UnsupportedEncodingException {
        MenuVO menu = new MenuVO();
        //从左数第一个一级菜单
        MenuVO.Button button0 = menu.new Button();
        //从左数第一个一级菜单的二级菜单
        MenuVO.ViewButton button00 = menu.new ViewButton();
        MenuVO.ViewButton button01 = menu.new ViewButton();
        MenuVO.Button button1 = menu.new Button();
        MenuVO.ViewButton button10 = menu.new ViewButton();
        MenuVO.Button button2 = menu.new Button();
        MenuVO.ViewButton button20 = menu.new ViewButton();

        button00.setName("联系我们");
        button00.setType("view");
        button00.setUrl("http://alumni.hit.edu.cn:8080/hitaa/aastaff.php");
        button01.setName("校友刊物");
        button01.setType("view");
        button01.setUrl("http://alumni.hit.edu.cn:8080/hitaa/hitren1.php");
        button0.setName("校友总会");
        button0.setSub_button(new MenuVO.Button[]{button00, button01});

        button10.setName("校友返校");
        button10.setType("view");
        String url10 = WeChatApi.API_WEB_CODE.replace("APPID", ConfigConsts.getApp_id())
                .replace("REDIRECT_URI", URLEncoder.encode(ConfigConsts.getServer_domain_url() + "/hit-alumni/wechat/alumni/back-school", "utf-8"))
                .replace("SCOPE", "snsapi_base").replace("STATE", "hit-alumni");
        button10.setUrl(url10);
        button1.setName("校友服务");
        button1.setSub_button(new MenuVO.Button[]{button10});

        button20.setName("校友捐赠");
        button20.setType("view");
        button20.setUrl(ConfigConsts.getDonate_url());
        button2.setName("校友捐赠");
        button2.setSub_button(new MenuVO.Button[]{button20});

        menu.setButton(new MenuVO.Button[]{button0, button1, button2});

        return JSON.toJSONString(menu);
    }

}