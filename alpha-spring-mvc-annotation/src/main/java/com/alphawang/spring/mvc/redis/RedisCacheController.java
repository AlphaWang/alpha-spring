package com.alphawang.spring.mvc.redis;

import com.alphawang.spring.mvc.User;
import com.alphawang.spring.mvc.redis.service.RedisCacheService;
import com.google.common.base.Stopwatch;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.TimeUnit;

@Slf4j
@Controller
public class RedisCacheController {

    @Autowired
    private RedisCacheService redisCacheService;

    @ResponseBody
    @RequestMapping(value = "/redis-cache/{key:[0-9]+}", method = RequestMethod.GET)
    public User cache(@PathVariable(value = "key") Long id) throws InterruptedException {
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
