package com.alphawang.spring.core.ioc.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApplicationContextDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeansConfiguration.class);
        // getBean()是BeanFactory接口中的方法
        Car car = applicationContext.getBean("car", Car.class);

        /**
         * 当有多个 @Configuration时：
         */
        // 1. 用register注册多个配置类
        applicationContext.register(BeansConfiguration.class);
        applicationContext.register(BeansConfiguration.class);
        applicationContext.refresh(); //刷新容器 以应用注册的配置类
        
        // 2. 在配置类上通过 @Import 导入其他配置类
        
        // 3. 在配置类上通过 @ImportResource 导入XML配置信息
        
        // 4. 在XML中通过 `resource-pattern` 引用配置类
        

        System.out.println("getBean: " + car);
    }
}
