package com.study.entity;

/**
 * @author liuxin
 * @Title: StaffDao
 * @ProjectName springBootTest
 * @Description: TODO
 * @date 2018/7/1214:17
 */
public class Staff {
    private String id;
    private String staffName;
    private String staffNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }
}
