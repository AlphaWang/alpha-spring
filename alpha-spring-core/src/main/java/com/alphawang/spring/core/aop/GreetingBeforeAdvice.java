package com.alphawang.spring.core.aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override 
    public void before(Method method, Object[] args, Object o) throws Throwable {
        String clientName = (String) args[0];
        System.out.println("--AOP MethodBeforeAdvice-- How are you ! Mr. " + clientName);
    }
}
