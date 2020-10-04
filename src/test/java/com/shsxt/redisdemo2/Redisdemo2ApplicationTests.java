package com.shsxt.redisdemo2;

import com.shsxt.redisdemo2.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void test2 (){
        ValueOperations<String, Object> value = redisTemplate.opsForValue();
        Map<String,String> map=new HashMap<>();
        map.put("1","大娃");
        map.put("2","二娃");
        map.put("3","三娃");
        map.put("4","四娃");
        value.multiSet(map);
        List<String> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        List<Object> objectList = value.multiGet(list);
        objectList.forEach(System.out::println);
    }
}
