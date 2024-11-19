package com.devfromhills.controller;

import com.devfromhills.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisTestController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/getuser/{user}")
    public String getData(@PathVariable  String user){
        String name= redisService.get(user);
        if(name!=null)
            return name;
        else {
            redisService.set("name", "shivam");
        }
        return "unknown User";
    }
}
