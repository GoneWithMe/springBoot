package com.study.controller;

import com.study.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

/**
 * Created by liuxin on 2018/7/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    public void test(){
        stringRedisTemplate.opsForValue().set("aa","111");
        Assert.assertEquals("111",stringRedisTemplate.opsForValue().get("aa"));
    }

    @Test
    public void test1() throws InterruptedException {
        User user=new User("aa@126.com", "aa", "aa123456", "aa","123");
        ValueOperations<String,User> operations = redisTemplate.opsForValue();
        operations.set("liu",user);
        operations.set("xin",user,1, TimeUnit.SECONDS);
        //Thread.sleep(1000);
        Boolean isExist= redisTemplate.hasKey("xin");
        if (isExist) {
            System.out.println("key is exist");
        } else {
            System.err.println("key is not exist");
        }
    }
}
