package com.xqnode.elasticsearch;

import com.xqnode.elasticsearch.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MongodbTest {
    @Autowired
    private ElasticsearchRestTemplate template;


    @Test
    public void test() {
        User user = User.builder().id(1L).username("xqnode").build();
        template.save(user);
    }
}
