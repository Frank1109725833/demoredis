package com.shsxt.redisdemo2;

import com.shsxt.redisdemo2.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

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
        value.set("class1:bgb:person1:01","ymd");
        redisTemplate.delete("3");
    }
    @Test
    public void test3 (){
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put("user1","name","laowang");
        System.out.println(hash.get("user1", "name"));
        Map<String,String> map=new HashMap<>();
        map.put("1","大娃");
        map.put("2","二娃");
        map.put("3","三娃");
        map.put("4","四娃");
        hash.putAll("葫芦娃",map);
        List<Object> list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        List<Object> objects = hash.multiGet("葫芦娃",list);
        objects.forEach(System.out::println);
        Map<Object, Object> entries = hash.entries("葫芦娃");
        entries.forEach((k,v)->System.out.println(k+"-----"+v));
        hash.delete("葫芦娃","3");
    }

    @Test
    public void test4 (){
        ListOperations<String, Object> opsForList = redisTemplate.opsForList();
        opsForList.leftPushAll("user2","1","2","3");
        opsForList.rightPushAll("user2","4","5","6");
        System.out.println(opsForList.size("user2"));
        List<Object> user2 = opsForList.range("user2", 0, 10);
        user2.forEach(System.out::println);
        opsForList.remove("user2",10,"5");
        System.out.println(opsForList.index("user", 3));
    }
    @Test
    public void test5 (){
        SetOperations<String, Object> opsForSet = redisTemplate.opsForSet();
        opsForSet.add("user3","1","2","3","4");
        System.out.println(opsForSet.size("user3"));
        Set<Object> user2 = opsForSet.members("user2");
        user2.forEach(System.out::println);
        opsForSet.remove("user3","3");
    }
    @Test
    public void test6 (){
        ZSetOperations<String, Object> forZSet = redisTemplate.opsForZSet();
        forZSet.add("test","sad",10);
        forZSet.add("test","sad2",1);
        forZSet.add("test","sad6",5);
        System.out.println(forZSet.zCard("test"));
        Set<Object> test = forZSet.range("test", 0, 10);
        test.forEach(System.out::println);
        forZSet.remove("test","sad");
    }
    @Test
    public void test7 (){
        Set<String> keys = redisTemplate.keys("*");
        keys.forEach(System.out::println);
    }

    @Test
    public void test8 (){
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
//        opsForValue.set("test3","ymd",20, TimeUnit.SECONDS);
//        System.out.println(redisTemplate.getExpire("test3"));
        redisTemplate.expire("1",25,TimeUnit.SECONDS);
    }
}
