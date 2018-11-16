package com.alphawang.spring.springboot.listener;

import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.Environment;

public class MyConfigFileApplicationListener implements SmartApplicationListener, Ordered {

    @Override
    public int getOrder() {
        return ConfigFileApplicationListener.DEFAULT_ORDER + 1;
    }
    
    @Override 
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
            || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override 
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent preparedEvent = (ApplicationEnvironmentPreparedEvent) event;
            Environment environment = preparedEvent.getEnvironment();
            /**
             * 如果Order在 {@link ConfigFileApplicationListener} 之前： 
             * environment.getProperty("name") : null
             * 
             * 如果Order在 {@link ConfigFileApplicationListener} 之后： 
             * environment.getProperty("name") : alphawang.com
             */
            System.out.println("environment.getProperty(\"name\") : " + environment.getProperty("name"));
        }
        if (event instanceof ApplicationPreparedEvent) {
        }
    }
}
