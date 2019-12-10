//package com.mezzomedia.core.service;
//
//import org.springframework.data.redis.core.ListOperations;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
///**
// * <pre>
// * Description :
// * @author mezzomedia
// * @since 2018.04.16
// * @version
// *
// * Copyright (C) 2018 by Mezzomedia.Inc. All right reserved.
// */
//@Component
//public class RedisService {
//
//    @Resource(name = "redisTemplate")
//    private ListOperations<String, String> listOperations;
//
//
//    /**
//     * Aerospike save Test
//     *
//     * @return
//     */
//    public void save(Object o) {
//        listOperations.rightPush("test:task", "자기소개");
//        listOperations.rightPush("test:task", "취미소개");
//        listOperations.rightPush("test:task", "소망소개");
//        listOperations.rightPush("test:task", "선임이직");
//
//        String task = listOperations.leftPop("test:task");
//
//        System.out.println("task" + task);
//
//    }
//}
