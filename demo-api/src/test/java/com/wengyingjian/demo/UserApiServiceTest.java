package com.wengyingjian.demo;

import com.wengyingjian.demo.model.User;
import com.wengyingjian.demo.service.UserApiService;
import com.wengyingjian.kylin.util.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    public void testGetRedis() {
        User user = userApiService.getCachedUser(1);
        System.out.println(JsonUtil.getJsonFromObject(user));
    }

}
