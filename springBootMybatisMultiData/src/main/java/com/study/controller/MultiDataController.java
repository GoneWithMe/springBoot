package com.study.controller;

import com.study.dao.primary.StaffDao;
import com.study.dao.slave.UserDao;
import com.study.entity.Staff;
import com.study.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxin
 * @Title: MultiDataController
 * @ProjectName springBootTest
 * @Description: TODO
 * @date 2018/7/1214:42
 */
@RestController
public class MultiDataController {
    @Autowired
    private StaffDao staffDao;
    @Autowired
    private UserDao userDao;
    @RequestMapping("getUser")
    public User getUser(){
        return  userDao.getUserByName("刘鑫");
    }
    @RequestMapping("getStaff")
    public Staff getStaff(){
        return staffDao.getStaffByName("暂住证");
    }

}
