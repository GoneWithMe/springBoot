package com.study.mapper;

import com.study.entity.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author liuxin
 * @Title: userMapper
 * @ProjectName springBootTest
 * @Description: 对user表的操作mapper
 * @date 2018/7/1011:09
 */
public interface userMapper {
    @Select("SELECT * FROM users WHERE name = #{name}")
    @Results({
            @Result(property = "userSex",  column = "user_sex"),
            @Result(property = "nickName", column = "nick_name")
    })
    User getUserByName(String name);
}
