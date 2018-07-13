package com.study.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liuxin
 * @Title: Sender1
 * @ProjectName springBootTest
 * @Description: TODO
 * @date 2018/7/1313:49
 */
@Component
public class Sender2 {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void send(String message){
        rabbitTemplate.convertAndSend("hello",message);
    }
}
