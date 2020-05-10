package com.zyl.common.spring.mvc.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("request")
public class RequestContextHolderController {

    /**
     * 可以在Controller之外的地方使用Request入参
     */
    @GetMapping("holder")
    public void getLocalRequest() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request;
        if (null != requestAttributes)
            request = ((ServletRequestAttributes) requestAttributes).getRequest();
    }
}
