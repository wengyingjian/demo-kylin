package com.wengyingjian.demo.dao.mapper;

import com.wengyingjian.demo.model.User;
import com.wengyingjian.demo.model.query.UserQuery;

import java.util.List;

/**
 * Created by wengyingjian on 16/1/24.
 */
public interface UserMapper {
    List<User> selectUsers(UserQuery userQuery);

    int updateUser(User user);
}
