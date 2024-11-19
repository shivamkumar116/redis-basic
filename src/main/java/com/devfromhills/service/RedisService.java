package com.devfromhills.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {


    @Autowired
    private RedisTemplate redisTemplate;


    public String get(String key) {

        Object o = redisTemplate.opsForValue().get(key);
        if (o!=null) return o.toString();
        else return null;



    }

    public void set(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
