package com.study;

import com.study.config.Sender;
import com.study.fanout.FanoutSender;
import com.study.many.Sender1;
import com.study.many.Sender2;
import com.study.objectMessage.ObjectSender;
import com.study.topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuxin
 * @Title: RabbitMQTest
 * @ProjectName springBootTest
 * @Description: TODO
 * @date 2018/7/1217:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQTest {
    @Autowired
    private Sender helloSender;
    @Autowired
    private Sender1 sender1;
    @Autowired
    private Sender2 sender2;
    @Autowired
    private ObjectSender objectSender;
    @Autowired
    private TopicSender topicSender;
    @Autowired
    private FanoutSender fanoutSender;
    @Test
    public void hello() throws Exception {
        helloSender.send();
    }
    @Test
    public void oneToMany() throws Exception {
        for (int i=0;i<100;i++){
            sender1.send("this is message"+i);
            sender2.send("this is message"+i);
        }
    }
    @Test
    public void objectMessage(){
        objectSender.send();
    }
    @Test
    public void topicTest(){
        topicSender.send1();
        topicSender.send2();
    }
    @Test
    public void famousTest(){
        fanoutSender.send();
    }
}
