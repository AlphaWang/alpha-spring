package com.alphawang.spring.springboot.redis;

import com.alphawang.spring.springboot.User;
import com.alphawang.spring.springboot.redis.service.RedisCacheService;
import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Prerequisite
 * 1. run redis on localhost 6379
 */
@Slf4j
@RestController
public class RedisCacheController {
    
    @Autowired
    private RedisCacheService redisCacheService;

    @RequestMapping(value = "/redis-cache/{id:[0-9]+}", method = RequestMethod.GET)
    public User cache(@PathVariable(value = "id") Long id) throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        
        RedisCacheService.RedisRequest redisRequest = new RedisCacheService.RedisRequest();
        redisRequest.setId(id);
        redisRequest.setKey("user-" + id);
        
        // test key = null case : 0, 1, 2
        if (id > 2) {
           redisRequest.setTestId(id); 
        }

        User result =  redisCacheService.getUserWithCache(redisRequest);
        stopwatch.stop();
        log.warn("================ used {} ms. ", stopwatch.elapsed(TimeUnit.MILLISECONDS));
        
        return result;
        
    } 
}
