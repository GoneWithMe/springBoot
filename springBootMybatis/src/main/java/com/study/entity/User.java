package com.study.entity;

/**
 * @author liuxin
 * @Title: User
 * @ProjectName springBootTest
 * @Description: TODO
 * @date 2018/7/1011:03
 */
public class User {
    private Integer id;
    private String userSex;
    private String nickName;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
