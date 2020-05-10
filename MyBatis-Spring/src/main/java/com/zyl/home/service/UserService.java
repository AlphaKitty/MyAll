package com.zyl.home.service;

import com.zyl.home.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> getAll();
    void transactionTest(User user);
}
