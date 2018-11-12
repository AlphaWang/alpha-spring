package com.alphawang.spring.core.ioc.condition;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 通过参数`-Duser.name=Beta`, 则得到不同的Bean
 */
public class ConditionalOnSystemPropertyBootstrap {
    
    @Bean(name = "helloWorld")
    @ConditionalOnSystemProperty(name = "user.name", value="Alpha")
    public String helloWorld1() {
        return "Hello Alpha!";
    }

    @Bean(name = "helloWorld")
    @ConditionalOnSystemProperty(name = "user.name", value="Beta")
    public String helloWorld2() {
        return "Hello Beta!";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class).web(
            WebApplicationType.NONE)
            .run(args);

        String bean = context.getBean("helloWorld", String.class);
        
        System.out.println(">>> getBean: " + bean);
        context.close();
    }
}
