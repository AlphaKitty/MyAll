package com.zyl.home.service.impl;

import com.zyl.home.pojo.Comment;
import com.zyl.home.mapper.CommentMapper;
import com.zyl.home.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论表 服务实现类
 * </p>
 *
 * @author zyl
 * @since 2020-04-27
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
