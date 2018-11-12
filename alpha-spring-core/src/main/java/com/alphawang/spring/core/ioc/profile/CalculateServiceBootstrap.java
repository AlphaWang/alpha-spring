package com.alphawang.spring.core.ioc.profile;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.alphawang.spring.core.ioc.profile")
public class CalculateServiceBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateServiceBootstrap.class)
            .web(WebApplicationType.NONE)
            .profiles("Java8")
            .run(args);

        /**
         * NO Profile:
         *  No qualifying bean of type 'com.alphawang.spring.core.profile.CalculateService' available
         */
        CalculateService calculateService = context.getBean(CalculateService.class);
        int sum = calculateService.sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        System.out.println("SUM: " + sum);

    }
}
