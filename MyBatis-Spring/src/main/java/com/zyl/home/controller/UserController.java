package com.zyl.home.controller;

import com.zyl.home.pojo.User;
import com.zyl.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("all")
    public void getAll(){
        for (User user : userService.getAll()) {
            System.out.println(user);
        }
    }

    @PostMapping("transaction")
    public void transactionTest(User user){
        userService.transactionTest(user);
    }
}
