package com.alphawang.spring.springboot.initializer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ApplicationContextInitializer1 implements ApplicationContextInitializer {

    /**
     * 可在这里对Context进行操作，例如  
     * 
     * SharedMetadataReaderFactoryContextInitializer.java
     * applicationContext.addBeanFactoryPostProcessor(new SharedMetadataReaderFactoryContextInitializer.CachingMetadataReaderFactoryPostProcessor());
     *
     */
    @Override 
    public void initialize(ConfigurableApplicationContext context) {
        log.error("---- ApplicationContextInitializer1  displayName={} ",
            context.getDisplayName());
    }
}
