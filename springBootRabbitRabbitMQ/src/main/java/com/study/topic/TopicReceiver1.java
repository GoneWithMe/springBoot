package com.study.topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author liuxin
 * @Title: TopicReceiver1
 * @ProjectName springBootTest
 * @Description: TODO
 * @date 2018/7/1314:46
 */
@Component
@RabbitListener(queues = "topic.message")
public class TopicReceiver1 {
    @RabbitHandler
    public void process(String messgae){
        System.err.println(messgae);
    }
}
