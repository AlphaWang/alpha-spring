package com.alphawang.spring.springboot.listener.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.context.event.EventPublishingRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 参考：{@link EventPublishingRunListener}
 */
public class MySpringApplicationRunListener implements SpringApplicationRunListener {
    
    public MySpringApplicationRunListener(SpringApplication application, String[] args) {
        
    }
    
    @Override public void starting() {
        System.out.println("======= SpringApplicationRunListener: starting...");
    }

    @Override public void environmentPrepared(ConfigurableEnvironment environment) {

    }

    @Override public void contextPrepared(ConfigurableApplicationContext context) {

    }

    @Override public void contextLoaded(ConfigurableApplicationContext context) {

    }

    @Override public void started(ConfigurableApplicationContext context) {

    }

    @Override public void running(ConfigurableApplicationContext context) {

    }

    @Override public void failed(ConfigurableApplicationContext context, Throwable exception) {

    }
}
