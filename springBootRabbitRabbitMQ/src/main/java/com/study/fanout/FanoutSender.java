package com.study.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liuxin
 * @Title: FanoutSender
 * @ProjectName springBootTest
 * @Description: TODO
 * @date 2018/7/1315:08
 */
@Component
public class FanoutSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void send(){
        rabbitTemplate.convertAndSend("fanoutExchange","","this is message");
    }
}
