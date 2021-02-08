package com.xqnode.redis;


import com.xqnode.redis.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisService redisService;

    @Test
    public void testRedis() {
        redisService.delete("name:wx_public");
        redisService.set("name:wx_public", "Java学习指南", 10L, TimeUnit.SECONDS);
        String str = redisService.get("name:wx_public");
        System.out.println(str);

        boolean exists = redisService.exists("name:wx_public");
        System.out.println(exists);

        redisService.delete("list:wx");
        redisService.lLeftPush("list:wx", "Java学习指南");
        System.out.println(redisService.lRange("list:wx", 0 , -1));

        redisService.hPut("hash", "name:wx", "Java学习指南");
        System.out.println(redisService.hGet("hash", "name:wx"));

    }
}
