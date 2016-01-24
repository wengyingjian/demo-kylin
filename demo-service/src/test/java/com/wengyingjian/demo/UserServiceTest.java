package com.wengyingjian.demo;

import com.wengyingjian.demo.model.User;
import com.wengyingjian.demo.model.query.UserQuery;
import com.wengyingjian.demo.service.UserService;
import com.wengyingjian.kylin.util.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by wengyingjian on 16/1/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUserServiceGet() {

        System.out.println();
        UserQuery userQuery = new UserQuery();
        List<User> userList = userService.getUsers(userQuery).getData();
        System.out.println("found Users:" + JsonUtil.getJsonFromObject(userList));

        User old = userList.get(0);
        old.setId(2);
        old.setUserName("andy");
        boolean result = userService.modifyUser(old).getData();

        System.out.println("modify user:" + result);

        userQuery.setId(old.getId());
        System.out.println("found user:" + JsonUtil.getJsonFromObject(userService.getUsers(userQuery).getData()));
    }

}
