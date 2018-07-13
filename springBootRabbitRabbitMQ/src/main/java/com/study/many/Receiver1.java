package com.study.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author liuxin
 * @Title: Receiver1
 * @ProjectName springBootTest
 * @Description: TODO
 * @date 2018/7/1313:46
 */
@RabbitListener(queues = "hello")
@Component
public class Receiver1 {
    @RabbitHandler
    public void receive(String message){
        System.err.println("receiver1 "+message);
    }
}
