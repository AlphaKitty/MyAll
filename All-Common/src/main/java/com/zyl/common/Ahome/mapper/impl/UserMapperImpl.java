package com.zyl.common.Ahome.mapper.impl;

import com.zyl.common.Ahome.mapper.UserMapper;
import com.zyl.common.Ahome.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// @Repository
// public class UserMapperImpl implements UserMapper {
public class UserMapperImpl {
    // @Autowired
    // private SqlSessionTemplate sqlSessionTemplate;

    // @Override
    public List<User> getAll() {
        // UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        // return mapper.getAll();
        return null;
    }
}
