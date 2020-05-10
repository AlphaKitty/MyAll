package com.zyl.common.spring.mvc.aware.impl;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 因为Spring框架的使用基本是基于声明式的 直接操作的一般是容器中的Bean 如果要对容器本身或对环境等进行操作就需要别的途径
 * 继承了Aware接口的的接口基本都是用来在Spring容器初始化时提供一个Bean之外的对象句柄 可以随时查看和进行操作
 */
@Component
public class EnvironmentAwareImpl implements EnvironmentAware {

    private static Environment environmentHolder;

    @Override
    public void setEnvironment(Environment environment) {
        environmentHolder = environment;
    }

    public static Environment getEnvironmentHolder(){
        return environmentHolder;
    }
}
