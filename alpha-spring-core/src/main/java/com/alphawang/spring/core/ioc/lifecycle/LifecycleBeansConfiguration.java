package com.alphawang.spring.core.ioc.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifecycleBeansConfiguration {
    
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public LifecycleCar lifecycleCar() {
         LifecycleCar car = new LifecycleCar();
         car.setBrand("Audi");
         car.setColor("Black");
         car.setMaxSpeed(200);
         
         return car;
    }
    
    @Bean
    public MyBeanFactoryPostProcessor myBeanFactoryPostProcessor() {
        return new MyBeanFactoryPostProcessor();
    }
    
    @Bean
    public MyBeanPostProcessor myBeanPostProcessor() {
        return new MyBeanPostProcessor();
    }
}
