package net.i2it.hit.hitef.listener;

import net.i2it.hit.hitef.constant.ConfigConsts;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;

/**
 * 网站每次启动时需要对web项目的配置进行初始化的设置监听器
 * Created by liuming on 2017/5/2.
 */
public class WebInitListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //加载系统配置信息
        try {
            ConfigConsts.load();
            //将这个信息放到应用的上下文中
            servletContextEvent.getServletContext().setAttribute("globalUrlPrefix", ConfigConsts.getServer_domain_url());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
