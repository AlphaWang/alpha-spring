package com.alphawang.spring.springboot.redis;

import com.alphawang.spring.springboot.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RedisCacheController {

    @RequestMapping(value = "/redis-cache/{key:[0-9]+}", method = RequestMethod.GET)
    @Cacheable(value = "post-single", key = "#key")
    public User cache(@PathVariable(value = "key") String key) {

        log.warn("-------------MOCK redis for {}", key);
        return User.builder()
            .id(Long.valueOf(key))
            .name("mock user.")
            .build();
    } 
}