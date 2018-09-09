package com.alphawang.spring.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Map;

@Slf4j
@SpringBootApplication 
@ServletComponentScan(basePackages = "com.alphawang.spring.core.servlet")
public class AlphaSpringCoreApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        log.warn("===> bean count: {}", context.getBeanDefinitionCount());
        for (String name : context.getBeanDefinitionNames()) {
            log.warn("===> bean names: {}", name);
        }

        String[] profiles = context.getEnvironment().getActiveProfiles();
        Map<String, Object> systemEnv = context.getEnvironment().getSystemEnvironment();
        Map<String, Object> systemProp = context.getEnvironment().getSystemProperties();

        log.warn("---- profiles : {}", Arrays.asList(profiles));
        log.warn("---- system env: {}", systemEnv);
        log.warn("---- system prop: {}", systemProp);

        SpringApplication.run(AlphaSpringCoreApplication.class, args);
    }
}
