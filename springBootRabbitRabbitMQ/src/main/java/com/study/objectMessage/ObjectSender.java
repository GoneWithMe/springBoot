package com.study.objectMessage;

import com.study.entity.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author liuxin
 * @Title: ObjectSender
 * @ProjectName springBootTest
 * @Description: TODO
 * @date 2018/7/1314:01
 */
@Component
public class ObjectSender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    public void send(){
        this.rabbitTemplate.convertAndSend("object",new User("123","刘鑫","男","山东"));
    }
}
