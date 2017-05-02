package net.i2it.hit.hit_alumni.listener;

import net.i2it.hit.hit_alumni.constant.ConfigConsts;

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
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
