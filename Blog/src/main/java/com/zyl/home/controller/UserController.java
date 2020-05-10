package com.zyl.home.controller;


import com.zyl.home.pojo.User;
import com.zyl.home.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zyl
 * @since 2020-04-27
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @PostMapping("all")
    public List<User> getAllUser() {
        List<User> userList = userService.getAll();
        for (User user : userList) {
            System.out.println(user);
        }
        return userList;
    }
}
