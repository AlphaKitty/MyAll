package com.zyl.common.Ahome.service.impl;

import com.zyl.common.Ahome.mapper.UserMapper;
import com.zyl.common.Ahome.pojo.User;
import com.zyl.common.Ahome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void transactionTest(User user, String id) {
        userMapper.addUser(user);
        int a = 1/0;
        userMapper.deleteUser(id);
    }
}
