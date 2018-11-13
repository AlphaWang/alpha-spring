package com.alphawang.spring.core.ioc.configuration;

import org.springframework.context.annotation.Bean;

public class HelloWorldConfiguration {
    
    @Bean
    public String helloWorld() {
        return "Hello World Configuration!";
    }
    
}
