package com.alphawang.spring.springboot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApplicationRefreshListener1 implements ApplicationListener<ContextRefreshedEvent> {
    
    @Override 
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.error(">>>>>>>>>> ApplicationListener1: get event contextId={}, time={}, source={}",
            contextRefreshedEvent.getApplicationContext().getId(),
            contextRefreshedEvent.getTimestamp(),
            contextRefreshedEvent.getSource());
    }
}
