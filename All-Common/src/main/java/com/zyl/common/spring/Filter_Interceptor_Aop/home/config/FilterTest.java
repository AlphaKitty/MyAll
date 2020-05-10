package com.zyl.common.spring.Filter_Interceptor_Aop.home.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class FilterTest implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // System.out.println("Filter Before");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
        // System.out.println("Filtering");
    }

    @Override
    public void destroy() {
        // System.out.println("Filter After");
    }
}
