package com.alphawang.spring.springboot.redis.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;

@Configuration
//@EnableCaching
public class RedisCacheConfigurer extends CachingConfigurerSupport {
    @Nullable
    public CacheErrorHandler errorHandler() {
        return new MyCacheErrorHandler();
    }
    
}
