package com.alphawang.spring.springboot.initializer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

@Slf4j
public class ApplicationContextInitializer2 implements ApplicationContextInitializer, Ordered {
    @Override 
    public void initialize(ConfigurableApplicationContext context) {
        log.error("==== ApplicationContextInitializer2 displayName={} ",
            context.getDisplayName());
    }

    @Override 
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
