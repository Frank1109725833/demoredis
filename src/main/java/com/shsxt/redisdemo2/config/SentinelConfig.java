//package com.shsxt.redisdemo2.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisSentinelConfiguration;
//
//@Configuration
//public class SentinelConfig {
//    @Bean
//    public RedisSentinelConfiguration redisSentinelConfiguration(){
//        RedisSentinelConfiguration mymaster = new RedisSentinelConfiguration().
//                master("mymaster").
//                sentinel("192.168.10.100", 26379).
//                sentinel("192.168.10.101", 26379).
//                sentinel("192.168.10.102", 26379);
//        mymaster.setPassword("root");
//        return mymaster;
//    }
//}
