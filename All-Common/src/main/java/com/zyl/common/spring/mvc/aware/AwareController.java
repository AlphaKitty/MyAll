package com.zyl.common.spring.mvc.aware;

import com.zyl.common.spring.mvc.aware.impl.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;

@Controller
@RequestMapping("aware")
public class AwareController {
    /**
     * 实现ApplicationContextAware来存储和操作Spring容器
     */
    @GetMapping("application")
    public void applicationContextAwareTest() {
        ApplicationContext context = ApplicationContextAwareImpl.getApplicationHolder();
    }

    /**
     * 实现EnvironmentAware来存储和操作Environment
     */
    @GetMapping("evn")
    public void EnvironmentAwareTest() {
        Environment env = EnvironmentAwareImpl.getEnvironmentHolder();
    }

    @GetMapping("servlet")
    public void ServletContextAwareTest() {
        ServletContext servletHolder = ServletContextAwareImpl.getServletHolder();
    }

    @GetMapping("name")
    public void BeanNameAwareTest() {
        String beanName = BeanNameAwareImpl.getBeanName();
    }

    @GetMapping("factory")
    public void BeanFactoryAwareTest() {
        BeanFactory factory = BeanFactoryAwareImpl.getBeanFactory();
    }
}
