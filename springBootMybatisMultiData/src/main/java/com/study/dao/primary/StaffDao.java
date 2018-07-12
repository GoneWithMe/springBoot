package com.study.dao.primary;

import com.study.entity.Staff;

/**
 * @author liuxin
 * @Title: StaffDao
 * @ProjectName springBootTest
 * @Description: TODO
 * @date 2018/7/1214:15
 */
public interface StaffDao {
    Staff getStaffByName(String name);
}
