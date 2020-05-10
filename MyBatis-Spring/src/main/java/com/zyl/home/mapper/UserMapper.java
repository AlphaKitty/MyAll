package com.zyl.home.mapper;

import com.zyl.home.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> getAll();
    void deleteUser(@Param("id") String id);
    void addUser(User user);
}
