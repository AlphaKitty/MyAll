package com.zyl.home.mapper.impl;

import com.zyl.home.mapper.UserMapper;
import com.zyl.home.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserMapperImpl implements UserMapper {

    // TODO: 2020/4/20 zylTodo 应该是这样 但抛出了需要Factory和Template的异常 后面要看看
    // 如果继承了SqlSessionDaoSupport 就不用再手动注入SqlSessionTemplate
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List<User> getAll() {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        return mapper.getAll();
    }

    @Override
    public void deleteUser(String id) {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        mapper.deleteUser(id);
    }

    @Override
    public void addUser(User user) {
        UserMapper mapper = sqlSessionTemplate.getMapper(UserMapper.class);
        mapper.addUser(user);
    }

}
