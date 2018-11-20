package com.alphawang.spring.core.aop.aspectj;

import com.alphawang.spring.core.aop.Waiter;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Aspect
public class ArgsDemoAspect {
    
    @Before("target(com.alphawang.spring.core.aop.NaiveWaiter) && args(name)")
    public void args(String name) {
        System.out.println("=== @Before Start");
        System.out.println("=== name: " + name);
        System.out.println("=== @Before End");
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean/aop.xml");
        Waiter waiter = (Waiter) context.getBean("waiter");

        waiter.serveTo("Alpha");
        waiter.greetTo("AlphaWang");
    }
}
