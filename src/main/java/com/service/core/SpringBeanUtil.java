package com.service.core;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * Created by lvjianqing on 2017/8/15.
 * 获取spring容器中的对象
 */
@Service
public class SpringBeanUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringBeanUtil.applicationContext = applicationContext;
    }

    /**
     * 通过名称在spring容器中获取对象
     *
     * @param beanName
     * @return
     */
    public static Object getSpringBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
}
