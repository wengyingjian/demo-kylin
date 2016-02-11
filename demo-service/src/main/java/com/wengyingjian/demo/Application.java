package com.wengyingjian.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by wengyingjian on 16/1/23.
 */

@SpringBootApplication
@ComponentScan(basePackages = "com.wengyingjian")
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@PropertySource("classpath:rabbitmq.properties")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
