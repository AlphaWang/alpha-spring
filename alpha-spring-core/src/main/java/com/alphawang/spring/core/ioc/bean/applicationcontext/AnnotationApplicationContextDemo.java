package com.alphawang.spring.core.ioc.bean.applicationcontext;

import com.alphawang.spring.core.ioc.bean.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApplicationContextDemo {

    public static void main(String[] args) {
        
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeansConfiguration.class);
        // getBean()是BeanFactory接口中的方法
        Car car = applicationContext.getBean("car", Car.class);
        
        System.out.println("getBean: " + car);
    }
}
