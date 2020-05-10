package com.zyl.common.Ahome.controller;

import com.zyl.common.Ahome.pojo.User;
import com.zyl.common.Ahome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping("common")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 测试request的内容
     */
    @GetMapping("request")
    public void requestTest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Encoding: " + request.getCharacterEncoding());
        System.out.println("--------------------------------------");
        Enumeration<String> attributeNames = request.getAttributeNames();
        System.out.println("AttributeNames:");
        while (attributeNames.hasMoreElements())
            System.out.println(attributeNames.nextElement());
        System.out.println("--------------------------------------");
        System.out.println("ContentType: " + request.getContentType());
        System.out.println("--------------------------------------");
        System.out.println("ParameterNames:");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements())
            System.out.println(parameterNames.nextElement());
        System.out.println("--------------------------------------");
        System.out.println("ParameterMap");
        request.getParameterMap().forEach((k, v) -> System.out.println("k: " + k + ", v: " + Arrays.toString(v)));
        System.out.println("--------------------------------------");
        System.out.println("Protocol: " + request.getProtocol());
        System.out.println("--------------------------------------");
        System.out.println("Scheme: " + request.getScheme());
        System.out.println("--------------------------------------");
        System.out.println("ServerName: " + request.getServerName());
        System.out.println("--------------------------------------");
        System.out.println("ServerPort: " + request.getServerPort());
        System.out.println("--------------------------------------");
        System.out.println("RemoteAddr: " + request.getRemoteAddr());
        System.out.println("--------------------------------------");
        System.out.println("RemoteHost: " + request.getRemoteHost());
        System.out.println("--------------------------------------");
        System.out.println("Locale: " + request.getLocale().getDisplayName());
        System.out.println("--------------------------------------");
        System.out.println("RemotePort: " + request.getRemotePort());
        System.out.println("--------------------------------------");
        System.out.println("LocalName: " + request.getLocalName());
        System.out.println("--------------------------------------");
        System.out.println("LocalAddr: " + request.getLocalAddr());
        System.out.println("--------------------------------------");
        System.out.println("LocalPort: " + request.getLocalPort());
        System.out.println("--------------------------------------");
        System.out.println("ServletContext: " + request.getServletContext().getFilterRegistrations());
        userService.getAll();
    }

    @GetMapping("all")
    public void getAll() {
        List<User> all = userService.getAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    /**
     * 事务测试 事务注解标记的方法内部出现异常会回滚该方法已经进行的数据库操作
     */
    @PostMapping("transaction")
    public void transactionTest(@RequestBody User user, @RequestParam String id){
        userService.transactionTest(user, id);
    }
}
