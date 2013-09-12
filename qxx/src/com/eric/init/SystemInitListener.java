package com.eric.init;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created with IntelliJ IDEA.
 * User: Eric
 * Date: 13-7-30
 * Time: 下午4:51
 * To change this template use File | Settings | File Templates.
 */
public class SystemInitListener implements ServletContextListener {
    private static WebApplicationContext wac;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContextEvent.getServletContext());
        init();
    }

    public void init() {
        System.out.println("init success........");
    }

    public static <T> T getBean(String name) {
        return (T) wac.getBean(name);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
