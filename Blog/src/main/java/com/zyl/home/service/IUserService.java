package com.zyl.home.service;

import com.zyl.home.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author zyl
 * @since 2020-04-27
 */
public interface IUserService extends IService<User> {

    List<User> getAll();
}
