package com.study.dao;

import com.study.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by liuxin on 2018/7/6.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findByUserNameOrEmail(String username, String email);
}
