package com.example.controller;

import com.example.common.Result;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Java学习指南
 * mybatis
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserMapper userMapper;

    @PostMapping("/login")
    public Result<User> login(@RequestBody User user) {
        if (!checkParam(user)) {
            return Result.error("-1", "缺少必要参数");
        }
        User dbUser = userMapper.selectByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (dbUser == null) {
            return Result.error("-1", "账号或密码错误");
        }
        return Result.success(dbUser);
    }

    private boolean checkParam(User user) {
        return user.getUsername() != null && user.getPassword() != null;
    }
}
