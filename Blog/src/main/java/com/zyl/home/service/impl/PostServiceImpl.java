package com.zyl.home.service.impl;

import com.zyl.home.pojo.Post;
import com.zyl.home.mapper.PostMapper;
import com.zyl.home.service.IPostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 帖子表 服务实现类
 * </p>
 *
 * @author zyl
 * @since 2020-04-27
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

}
