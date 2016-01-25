package com.wengyingjian.demo;

import com.wengyingjian.demo.model.User;
import com.wengyingjian.demo.service.UserApiService;
import com.wengyingjian.kylin.util.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Field;

/**
 * Created by wengyingjian on 16/1/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UserApiServiceTest {
    @Autowired
    private UserApiService userApiService;


    @Test
    public void testRedisSet() {
        User user = new User();
        user.setId(1);
        user.setUserName("andy");
        userApiService.setCachedUser(user);
    }

    @Test
    public void testRedisGet() {
        User user = userApiService.getCachedUser(1);
        System.out.println(JsonUtil.getJsonFromObject(user));
    }

    @Test
    public void testMqSend() throws Exception {
//
//        Field field = RabbitTemplate.class.getDeclaredField("connectionFactory");
//        field.setAccessible(true);
//        ConnectionFactory connectionFactory=(ConnectionFactory)field.get(userApiService.getRabbitTemplate());
//        System.out.println(connectionFactory.getHost());
//        System.out.println(connectionFactory.getPort());

        User user = new User();
        user.setId(10);
        user.setUserName("andy");
        userApiService.sendUserToQueue(user);
    }

}
