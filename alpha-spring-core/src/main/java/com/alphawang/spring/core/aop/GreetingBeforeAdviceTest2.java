package com.alphawang.spring.core.aop;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class GreetingBeforeAdviceTest2 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean/aop.xml");
        Waiter aopWaiter = (Waiter) context.getBean("aopWaiter");
        /**
         * p:optimize="false"
         *      com.sun.proxy.$Proxy4
         * 
         * p:optimize="true":
         *      com.alphawang.spring.core.aop.NaiveWaiter$$EnhancerBySpringCGLIB$$46109c5c
         */
        System.out.println("----> Waiter Class: " + aopWaiter.getClass().getName());
        aopWaiter.greetTo("Alpha");
        aopWaiter.serveTo("AlphaWang");
    }
}
