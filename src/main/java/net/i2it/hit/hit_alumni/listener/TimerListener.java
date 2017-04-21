package net.i2it.hit.hit_alumni.listener;

import net.i2it.hit.hit_alumni.service.function.MenuOption;
import net.i2it.hit.hit_alumni.service.function.RefreshTimer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 定时任务监听器，在web应用启动时启动定时任务用于刷新一些从请求次数受限的微信接口获得的参数值，来实现减少请求次数
 */
public class TimerListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // 这是系统后台运行的用于定时刷新access_token和jsapi_ticket的
        new Thread(new RefreshTimer()).start();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
