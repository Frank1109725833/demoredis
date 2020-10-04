package com.shsxt.redisdemo2;

import com.shsxt.redisdemo2.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
public class Redisdemo2ApplicationTests {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    void contextLoads() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
//        valueOperations.set("test","sad");
//        System.out.println(valueOperations.get("test"));
        User user=new User();
        user.setName("ymd");
        user.setAge(24);
        valueOperations.set("User",user);
        System.out.println(valueOperations.get("User"));

    }

}
