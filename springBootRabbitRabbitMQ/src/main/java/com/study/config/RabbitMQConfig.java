package com.study.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuxin
 * @Title: RabbitMQConfig
 * @ProjectName springBootTest
 * @Description: TODO
 * @date 2018/7/1217:28
 */
@Configuration
public class RabbitMQConfig {
    @Bean
    public Queue getQueue(){
        return  new Queue("hello");
    }
    @Bean
    public Queue getObjectQueue(){
        return  new Queue("object");
    }
}
