package com.alphawang.spring.springboot.redis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class RedisCacheConfigurer extends CachingConfigurerSupport {
    
    @Override
    public CacheErrorHandler errorHandler() {
        return new MyCacheErrorHandler();
    }

    @Slf4j
    static class MyCacheErrorHandler implements CacheErrorHandler {
        @Override
        public void handleCacheGetError(RuntimeException e, Cache cache, Object o) {
            log.error("==== Failed to get cache {}, {}", cache.getName(), o, e);
        }

        @Override
        public void handleCachePutError(RuntimeException e, Cache cache, Object o, Object o1) {
            log.error("==== Failed to put cache {}, {}", cache.getName(), o, e);
        }

        @Override
        public void handleCacheEvictError(RuntimeException e, Cache cache, Object o) {
            log.error("==== Failed to evict cache {}, {}", cache, o, e);
        }

        @Override
        public void handleCacheClearError(RuntimeException e, Cache cache) {
            log.error("==== Failed to clear cache {}", cache, e);
        }
    }
}
