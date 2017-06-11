package net.i2it.hit.hitef.listener;

import net.i2it.hit.hitef.constant.CacheConsts;
import net.i2it.hit.hitef.service.function.MenuOption;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 网站每次启动时需要对微信公众号进行初始化的设置监听器
 * Created by liuming on 2017/4/21.
 */
public class WeChatInitListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // 系统启动时，开启菜单创建操作
        while (true) {
            //保证获得access_token，在进行菜单的创建
            if (CacheConsts.LAST_REFRESH_TIME != 0 && new MenuOption().create()) {
                System.out.println(">>> 微信菜单创建成功...");
                break;
            }
            try {
                Thread.sleep(15 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
