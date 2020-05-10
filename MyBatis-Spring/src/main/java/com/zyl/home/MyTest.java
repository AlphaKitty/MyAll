package com.zyl.home;

import com.zyl.home.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserController userController = context.getBean("userController", UserController.class);
        userController.getAll();
    }
}
