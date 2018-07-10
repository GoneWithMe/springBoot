package com.study.controller;

import com.study.entity.User;
import com.study.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxin
 * @Title: UserController
 * @ProjectName springBootTest
 * @Description: TODO
 * @date 2018/7/1011:08
 */
@RestController
public class UserController {
    @Autowired
    private  userMapper userMapper;
    @RequestMapping("getUserByName")
    public User getUser(String name){
           return userMapper.getUserByName(name);
    }
}
