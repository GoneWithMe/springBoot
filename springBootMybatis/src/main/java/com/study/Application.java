package com.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liuxin
 * @Title: Application
 * @ProjectName springBootTest
 * @Description: TODO
 * @date 2018/7/1011:04
 */
@SpringBootApplication
@MapperScan("com.study.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
