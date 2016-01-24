package com.wengyingjian.demo.controller;

import com.wengyingjian.demo.service.UserApiService;
import com.wengyingjian.kylin.common.model.Result;
import com.wengyingjian.kylin.common.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wengyingjian on 16/1/24.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserApiService userService;

    @RequestMapping("find")
    public Result findUser(@RequestParam(value = "user_id", required = false) Integer userId) {
        if (userId == null) {
            return ResultUtil.genSuccessResult(userService.getUsers());
        }
        return ResultUtil.genSuccessResult(userService.getUser(userId));
    }

}
