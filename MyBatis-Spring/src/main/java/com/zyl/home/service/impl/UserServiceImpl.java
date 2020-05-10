package com.zyl.home.service.impl;

import com.zyl.home.mapper.UserMapper;
import com.zyl.home.pojo.User;
import com.zyl.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public void transactionTest(User user) {
        userMapper.addUser(user);
        int a = 1/0;
        userMapper.deleteUser(user.getId());
    }
}
