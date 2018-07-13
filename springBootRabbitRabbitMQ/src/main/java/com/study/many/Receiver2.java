package com.study.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author liuxin
 * @Title: Receiver2
 * @ProjectName springBootTest
 * @Description: TODO
 * @date 2018/7/1313:48
 */
@Component
@RabbitListener(queues = "hello")
public class Receiver2 {
    @RabbitHandler
    public  void receive(String message){
        System.err.println("receiver2 "+message);
    }
}
