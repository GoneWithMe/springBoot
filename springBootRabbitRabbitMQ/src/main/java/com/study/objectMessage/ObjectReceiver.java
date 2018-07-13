package com.study.objectMessage;

import com.study.entity.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author liuxin
 * @Title: ObjectReceiver
 * @ProjectName springBootTest
 * @Description: TODO
 * @date 2018/7/1314:06
 */
@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {
    @RabbitHandler
    public void receive(User user){
        System.err.println(user);
    }
}
