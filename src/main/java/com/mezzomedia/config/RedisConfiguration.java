//package com.mezzomedia.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
///**
// * <pre>
// * Description : 레디스 환경 설정 파일
// * @author skan
// * @since 2018.04.13
// * @version
// *
// * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
// */
//
//@Configuration
//@EnableAutoConfiguration
//@EnableTransactionManagement
//@EnableRedisRepositories(basePackageClasses = {com.mezzomedia.core.repository.redis.RedisRepository.class})
//public class RedisConfiguration {
//
//    @Value("${spring.redis.host:192.168.99.100}")
//    private String redisHost;
//    @Value("${spring.redis.port:32768}")
//    private int redisPort;
//
//    @Bean(name="redisConnectionFactory")
//    @Primary
//    public RedisConnectionFactory connectionFactory() {
//
//        JedisConnectionFactory  jedisConnectionFactory =  new JedisConnectionFactory();
//        jedisConnectionFactory.setHostName(redisHost);
//        jedisConnectionFactory.setPort(redisPort);
//        jedisConnectionFactory.setUsePool(true);
//        return jedisConnectionFactory;
//    }
//
//
//    @Bean(name="redisTemplate")
//    @Primary
//    public RedisTemplate<String,Object> redisTemplate () {
//        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
//        redisTemplate.setConnectionFactory(connectionFactory());
//        redisTemplate.setEnableTransactionSupport(true);
//
//        return redisTemplate;
//    }
//
//    @Bean
//    @Primary
//    public StringRedisTemplate stringRedisTemplate() {
//        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(connectionFactory());
//        stringRedisTemplate.setEnableTransactionSupport(true);
//        return stringRedisTemplate;
//    }
//}
