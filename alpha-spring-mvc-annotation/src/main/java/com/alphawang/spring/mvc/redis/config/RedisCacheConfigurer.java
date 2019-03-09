package com.alphawang.spring.mvc.redis.config;

import com.google.common.base.Joiner;
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
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
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
        return new MethodKeyGenerator();
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

//    @Configuration
//    public class RedisConfig extends CachingConfigurerSupport {
//        @Autowired
//        private RedisConnectionFactory redisConnectionFactory;
//        @Bean
//        public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//            Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//            objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//            serializer.setObjectMapper(objectMapper);
//            RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//            redisTemplate.setConnectionFactory(redisConnectionFactory);
//            redisTemplate.setKeySerializer(new StringRedisSerializer());
//            redisTemplate.setValueSerializer(serializer);
//            redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//            redisTemplate.setHashValueSerializer(serializer);
//            redisTemplate.afterPropertiesSet();
//            return redisTemplate;
//        }
    
//        @Bean
//        public RedisCacheManager redisCacheManager(RedisTemplate redisTemplate) {
//            RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisTemplate.getConnectionFactory());
//            RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(redisTemplate.getValueSerializer()));
//            return new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
//        }
        /**
         * 二者选其一即可
         */

    //    @Bean
    //    public RedisCacheConfiguration redisCacheConfiguration() {
    //        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);
    //        ObjectMapper objectMapper = new ObjectMapper();
    //        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    //        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
    //        serializer.setObjectMapper(objectMapper);
    //        return RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(serializer));
    //    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory cf) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(cf);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        /**
         * Object.class:
         * java.util.LinkedHashMap cannot be cast to com.alphawang.spring.mvc.User
         * 
         * User.class:
         * no exception, but not flexible.
         */
//        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class)); 
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());    //need upgrade version
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

    /**
     * Generates cache key by className + methodName + params
     */
    static class MethodKeyGenerator implements KeyGenerator {

        private static final Joiner JOINER = Joiner.on(":").useForNull("null");
        private static final Joiner PARAM_JOINER = Joiner.on("-").useForNull("null");

        @Override
        public Object generate(Object target, Method method, Object... params) {
            String paramsString = "";
            if (params != null) {
                paramsString = PARAM_JOINER.join(params);
            }

            return JOINER.join(target.getClass().getSimpleName(), method.getName(), paramsString);
        }
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
