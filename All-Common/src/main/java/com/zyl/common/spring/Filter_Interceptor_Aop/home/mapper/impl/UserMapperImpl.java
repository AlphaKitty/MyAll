package com.zyl.common.spring.Filter_Interceptor_Aop.home.mapper.impl;

import com.zyl.common.spring.Filter_Interceptor_Aop.home.mapper.UserMapper;
import org.springframework.stereotype.Repository;

@Repository("fiaUserMapperImpl")
public class UserMapperImpl implements UserMapper {
    @Override
    public void getAll() {
        System.out.println("getAll");
    }
}
