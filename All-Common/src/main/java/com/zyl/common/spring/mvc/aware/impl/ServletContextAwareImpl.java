package com.zyl.common.spring.mvc.aware.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

@Component
public class ServletContextAwareImpl implements ServletContextAware {

    private static ServletContext servletHolder;

    public static ServletContext getServletHolder() {
        return servletHolder;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        servletHolder = servletContext;
    }
}
