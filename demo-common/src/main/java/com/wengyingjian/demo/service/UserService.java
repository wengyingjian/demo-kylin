package com.wengyingjian.demo.service;

import com.wengyingjian.demo.model.User;
import com.wengyingjian.demo.model.query.UserQuery;
import com.wengyingjian.kylin.common.model.Result;

import java.util.List;

/**
 * Created by wengyingjian on 16/1/24.
 */
public interface UserService {
    public Result<List<User>> getUsers(UserQuery userQuery);

    public Result<Boolean> modifyUser(User user);
}
