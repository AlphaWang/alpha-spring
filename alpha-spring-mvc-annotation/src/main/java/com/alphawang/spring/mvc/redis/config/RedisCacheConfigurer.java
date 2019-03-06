package com.alphawang.spring.mvc.redis.config;

import com.alphawang.spring.mvc.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.lang.reflect.Method;

/**
 * without Spring-Boot
 */
@Configuration
@EnableCaching
public class RedisCacheConfigurer extends CachingConfigurerSupport {

    @Override 
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {

            @Override public Object generate(Object o, Method method, Object... objects) {
                return method.getName();
            }
        };
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return new MyCacheErrorHandler();
    }
    
    
    
    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();

        redisConnectionFactory.setHostName("127.0.0.1");
        redisConnectionFactory.setPort(6379);
        return redisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
        redisTemplate.setConnectionFactory(cf);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class)); //TODO not flexible
        return redisTemplate;
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);

        // Number of seconds before expiration. Defaults to unlimited (0)
        cacheManager.setDefaultExpiration(300);
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }
    
//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory cf) {
//        RedisCacheManager cacheManager = RedisCacheManager.builder(cf)
//            .cacheDefaults(defaultConfiguration())
//            .build();
//
//        return cacheManager;
//    }
//    
//    private RedisCacheConfiguration defaultConfiguration() {
//        return RedisCacheConfiguration.defaultCacheConfig()
//            .prefixKeysWith("redis-c-")
//            .entryTtl(Duration.ofMinutes(10));
//    }

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
