package com.zyl.common.spring.mvc.aware.impl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Bean实现ApplicationContextAware接口 重写的setApplicationContext方法在服务启动时会自动把Spring容器的整个应用上下文添加到静态的ApplicationContext字段中
 * ApplicationContext字段设置为静态的原因是ApplicationContextAwareImpl可以有其他一些比如自定义Bean配置的静态方法 可以通过类名直接调用 所有private static签名的字段都是为了方便静态方法修改其值
 * ApplicationContextAwareImpl必须是Bean
 */
@Component
public class ApplicationContextAwareImpl implements ApplicationContextAware {

    private static ApplicationContext applicationHolder;

    public static ApplicationContext getApplicationHolder() {
        return applicationHolder;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationHolder = applicationContext;
    }
}
