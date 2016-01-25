package com.wengyingjian.demo.helper;

import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.SimpleRoutingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by wengyingjian on 16/1/24.
 */
@Component
@PropertySource(value = "rabbitmq.properties")
public class RabbitConfig {


    @Value("${host}")
    private String host;

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConnectionFactory(getConnectionFactory());
    }

    public ConnectionFactory getConnectionFactory() {
        System.out.println("...");
        System.out.println("...");
        System.out.println("host:"+host);
        ConnectionFactory connectionFactory = new SimpleRoutingConnectionFactory() {
            @Override
            public String getHost() {
                return host;
            }
        };

        return connectionFactory;
    }

}
