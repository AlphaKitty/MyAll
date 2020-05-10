package com.zyl.common.spring.Filter_Interceptor_Aop.home.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopTest {
    @Before("execution(* com.zyl.*.controller..*.*(..))")
    public void before() {
        System.out.println("Aop Before");
    }
}
