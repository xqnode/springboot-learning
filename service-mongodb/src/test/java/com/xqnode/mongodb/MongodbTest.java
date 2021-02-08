package com.xqnode.mongodb;

import com.xqnode.mongodb.dao.UserRepository;
import com.xqnode.mongodb.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MongodbTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() {
        userRepository.deleteAll();
        User user = User.builder().id(1L).username("xqnode").nickname("Java学习指南").password("123456").build();
        userRepository.insert(user);
        List<User> all = userRepository.findAll();
        log.info("查询所有对象：{}", all);

        User user1 = userRepository.findByUsername("xqnode");
        log.info("根据username查询对象：{}", user1);

    }
}
