package com.wengyingjian.demo.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by wengyingjian on 16/2/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {com.wengyingjian.demo.Application.class})
public class MqTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    private String queueName = "helloworld.queue";

    @Test
    public void testSend() {
        AmqpAdmin amqpAdmin = new RabbitAdmin(rabbitTemplate.getConnectionFactory());
        amqpAdmin.declareExchange(new DirectExchange(""));
        amqpAdmin.declareQueue(new Queue(queueName));
        rabbitTemplate.convertAndSend(queueName, "message");
    }

    @Test
    public void testRecv() {
        AmqpAdmin amqpAdmin = new RabbitAdmin(rabbitTemplate.getConnectionFactory());
        amqpAdmin.declareQueue(new Queue(queueName));
        //   Object obj=rabbitTemplate.receiveAndConvert(queueName);

        System.out.println("port:"+rabbitTemplate.getConnectionFactory().getPort());
        rabbitTemplate.receiveAndReply(queueName, new ReceiveAndReplyCallback<String, String>() {
            @Override
            public String handle(String payload) {
                System.out.println("handle");
                return "aaa";
            }
        });


        //  System.out.println(obj);
    }

}
