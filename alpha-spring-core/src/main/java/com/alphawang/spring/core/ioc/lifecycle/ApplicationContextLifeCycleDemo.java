package com.alphawang.spring.core.ioc.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextLifeCycleDemo {

    public static void main(String[] args) {
        
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(LifecycleBeansConfiguration.class);
        // getBean()是BeanFactory接口中的方法
        LifecycleCar car = applicationContext.getBean("lifecycleCar", LifecycleCar.class);
        
        System.out.println("getBean: " + car);
    }
}
