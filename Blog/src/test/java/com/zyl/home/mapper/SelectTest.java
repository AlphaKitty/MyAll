package com.zyl.home.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyl.home.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SelectTest {

    @Autowired
    private TestMapper testMapper;

    /**
     * testMapper本身被动态代理 被代理时参数会以invoke方法的args形式传递进去
     */
    @Test
    public void testSelect() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", 11111);
        List<User> users = testMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }
}
