package com.zyl.common.spring.Filter_Interceptor_Aop.home.service.impl;

import com.zyl.common.spring.Filter_Interceptor_Aop.home.mapper.UserMapper;
import com.zyl.common.spring.Filter_Interceptor_Aop.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("fiaUserServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("fiaUserMapperImpl")
    private UserMapper userMapper;

    @Override
    public void getAll() {
        userMapper.getAll();
    }
}
