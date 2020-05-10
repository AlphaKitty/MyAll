package com.zyl.common.spring.mvc.aware.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
public class BeanFactoryAwareImpl implements BeanFactoryAware {

    private static BeanFactory factory;

    public static BeanFactory getBeanFactory() {
        return factory;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        factory = beanFactory;
    }
}
