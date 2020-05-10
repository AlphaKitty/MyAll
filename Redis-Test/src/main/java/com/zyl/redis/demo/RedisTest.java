package com.zyl.redis.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping(value = "test")
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("test")
    public void test() throws JsonProcessingException {
        // String jsonObject = new ObjectMapper().writeValueAsString(new User("123", "张友谅"));
        // stringRedisTemplate.opsForValue().set("user", jsonObject);
        // System.out.println(stringRedisTemplate.opsForValue().get("user"));

        stringRedisTemplate.opsForValue().setIfAbsent("lockKey", "operatorId", 30, TimeUnit.SECONDS);

    }
}
