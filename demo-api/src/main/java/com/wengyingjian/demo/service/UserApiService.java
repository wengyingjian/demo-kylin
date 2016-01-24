package com.wengyingjian.demo.service;

import com.wengyingjian.demo.model.User;
import com.wengyingjian.demo.model.query.UserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by wengyingjian on 16/1/24.
 */
@Service
public class UserApiService {
    @Autowired
    private UserService userService;

    public List<User> getUsers() {
        UserQuery userQuery = new UserQuery();
        return userService.getUsers(userQuery).getData();
    }

    public User getUser(Integer userId) {
        UserQuery userQuery = new UserQuery();
        userQuery.setId(userId);
        List<User> userList = userService.getUsers(userQuery).getData();
        if (CollectionUtils.isEmpty(userList)) {
            return null;
        }
        return userList.get(0);
    }
}
