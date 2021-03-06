package com.study.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liuxin
 * @Title: TopicSender
 * @ProjectName springBootTest
 * @Description: TODO
 * @date 2018/7/1314:42
 */
@Component

public class TopicSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void send1(){
        String context = "hi, i am message 1";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("exchange","topic.message",context);
    }
    public void send2(){
        String context = "hi, i am messages 2";
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("exchange","topic.messages",context);
    }
}
