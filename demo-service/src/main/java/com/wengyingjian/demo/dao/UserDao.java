package com.wengyingjian.demo.dao;

import com.wengyingjian.demo.dao.mapper.UserMapper;
import com.wengyingjian.demo.model.User;
import com.wengyingjian.demo.model.query.UserQuery;
import com.wengyingjian.kylin.common.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wengyingjian on 16/1/24.
 */
@Repository
public class UserDao {

    @Autowired
    private UserMapper slaveUserMapper;
    @Autowired
    private UserMapper masterUserMapper;

    public List<User> findUsers(UserQuery userQuery) {
        return slaveUserMapper.selectUsers(userQuery);
    }

    public boolean updateUser(User user) {
        int result = masterUserMapper.updateUser(user);
        System.out.println("affected rows : " + result);
        return result == 0 ? false : true;
    }
}
