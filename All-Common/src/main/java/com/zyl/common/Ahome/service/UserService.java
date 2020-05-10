package com.zyl.common.Ahome.service;

import com.zyl.common.Ahome.pojo.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    void transactionTest(User user, String id);
}
