package com.wengyingjian.demo;

import com.wengyingjian.demo.service.UserService;
import com.wengyingjian.kylin.hessian.client.utils.HessianProxyUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by wengyingjian on 16/1/24.
 */
@SpringBootApplication(scanBasePackages = {"com.wengyingjian.kylin", "com.wengyingjian.demo"})
@PropertySource("demo-api.properties")
public class Application {

    @Value("${userService.url}")
    private String userServiceUrl;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public UserService userService() {
        Object object = HessianProxyUtil.buildRemotingService(userServiceUrl, "userService", UserService.class);
        return UserService.class.cast(object);
    }
}
