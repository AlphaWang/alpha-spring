package com.alphawang.spring.core.ioc.configuration;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@EnableAutoConfiguration
public class HelloWorldAutoConfigurationBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(HelloWorldAutoConfigurationBootstrap.class).web(
            WebApplicationType.NONE)
            .run(args);
        
        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println(">>>>>AutoConfiguration getBean : " + helloWorld);
        
        context.close();
    }
}
