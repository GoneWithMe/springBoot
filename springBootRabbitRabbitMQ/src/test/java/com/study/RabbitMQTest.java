package com.study;

import com.study.config.Sender;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Test
    public void hello() throws Exception {
        helloSender.send();
    }
    @Test
    public void oneToMany() throws Exception {
        for (int i=0;i<100;i++){
            neoSender.send(i);
        }
    }
}
