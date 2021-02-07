package com.xqnode.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xqnode.mp.entity.User;
import com.xqnode.mp.mapper.UserMapper;
import com.xqnode.mp.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
