package com.alphawang.spring.core.aop.aspectj;

import com.alphawang.spring.core.aop.Waiter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Aspect
public class AroundAspect {
    
    @Around("execution(* greetTo(..)) && target(com.alphawang.spring.core.aop.NaiveWaiter)")
    public void test(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("------ @Around Start");

        Object[] args = joinPoint.getArgs();
        Object target = joinPoint.getTarget();
        System.out.println("------ args[0]: " + args[0]);
        System.out.println("------ target: " + target);

        joinPoint.proceed();
         
        System.out.println("------ @Around End");
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean/aop.xml");
        Waiter waiter = (Waiter) context.getBean("waiter");
        
        waiter.serveTo("Alpha");
        waiter.greetTo("AlphaWang");
    }
}
