package net.i2it.hit.hit_alumni.listener;

import net.i2it.hit.hit_alumni.service.TimerTaskService;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 定时任务监听器，在web应用启动时启动定时任务用于刷新一些从请求次数受限的微信接口获得的参数值，来实现减少请求次数
 */
public class TimerListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        new Thread(new TimerTaskService()).start();
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
