package com.listener;

import com.util.StringUtil;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * lvjianqing
 * 加载常量
 */
public class MyServletContextListener implements ServletContextListener {
    private static final Logger logger = Logger.getLogger(MyServletContextListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        logger.info("开始加载系统常量---------------------------");
        ServletContext servlet_context = arg0.getServletContext();
        String contextPath = servlet_context.getContextPath();
        if (StringUtil.isNotEmpty(contextPath) && contextPath.equals("/")) {
            contextPath = "";
        }
        servlet_context.setAttribute("contextPath", contextPath);
        //加载字典类
        logger.info("contextPath:" + contextPath);
    }
}
