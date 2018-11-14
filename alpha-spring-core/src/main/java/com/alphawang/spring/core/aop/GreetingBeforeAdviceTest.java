package com.alphawang.spring.core.aop;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.testng.annotations.Test;

public class GreetingBeforeAdviceTest {
    
    @Test
    public void before() {
        Waiter waiter = new NaiveWaiter();

        BeforeAdvice advice = new GreetingBeforeAdvice();

        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(waiter);
        proxyFactory.addAdvice(advice);
        
        Waiter aopWaiter = (Waiter) proxyFactory.getProxy();
        System.out.println("----> Waiter Class: " + aopWaiter.getClass().getName());
        aopWaiter.greetTo("Alpha");
        aopWaiter.serveTo("AlphaWang");
    }
}
