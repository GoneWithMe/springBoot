package com.study.dao.slave;

import com.study.entity.User;

/**
 * @author liuxin
 * @Title: UserDao
 * @ProjectName springBootTest
 * @Description: TODO
 * @date 2018/7/1214:19
 */
public interface UserDao {
    User getUserByName(String name);
}
