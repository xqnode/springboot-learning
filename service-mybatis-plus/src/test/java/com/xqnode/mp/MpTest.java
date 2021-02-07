package com.xqnode.mp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xqnode.mp.entity.User;
import com.xqnode.mp.mapper.UserMapper;
import com.xqnode.mp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Wrapper;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MpTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUserMapper() {

        List<User> list = userService.list();
        System.out.println("all===================================");
        System.out.println(list);

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", "zhangsan");
        List<User> list1 = userService.list(queryWrapper);
        System.out.println("eq===================================");
        System.out.println(list1);

        queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username", "56");
        List<User> list2 = userService.list(queryWrapper);
        System.out.println("like===================================");
        System.out.println(list2);
    }

}
