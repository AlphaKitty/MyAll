package com.zyl.common.spring.mvc.aware.impl;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanNameAwareImpl implements BeanNameAware {
    private static String beanName;

    public static String getBeanName() {
        return beanName;
    }

    @Override
    public void setBeanName(String name) {
        beanName = name;
    }
}
