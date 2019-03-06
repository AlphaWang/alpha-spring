package com.alphawang.spring.springboot.redis.service;

import com.alphawang.spring.springboot.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RedisCacheService {

//    @Cacheable(value = "cached-user", key = "#redisRequest.key", unless = "#result.testId > 10")
    @Cacheable(value = "cached-user", key = "#redisRequest.key", condition = "#redisRequest.testId != null && #redisRequest.testId < 10")
    public User getUserWithCache(RedisRequest redisRequest) {

        log.warn("------------- MOCK redis for {}", redisRequest);
        return User.builder()
            .id(Long.valueOf(redisRequest.id))
            .name("mock user." + redisRequest.getKey())
            .testId(redisRequest.getTestId())
            .build();
    }
    
    @Data
    public static class RedisRequest {
        private Long id;
        private String key;
        private Long testId;
    } 
    
}
