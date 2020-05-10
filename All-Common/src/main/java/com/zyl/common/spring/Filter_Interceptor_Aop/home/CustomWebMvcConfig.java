package com.zyl.common.spring.Filter_Interceptor_Aop.home;

import com.zyl.common.spring.Filter_Interceptor_Aop.home.config.InterceptorTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class CustomWebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private InterceptorTest interceptorTest;

    // 自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorTest)
                .addPathPatterns("/**");
    }

    // 自定义跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }

    // 自定义视图/跳转/返回状态
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 把/test的请求响应返回为error视图
        registry.addViewController("/test").setViewName("error");
        // 把/index请求重定向到/test/test
        registry.addRedirectViewController("/index", "/test/test");
        // 把/404请求返回指定状态
        registry.addStatusController("/404", HttpStatus.NOT_FOUND);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static").addResourceLocations("classpath:/static/");
    }
}
