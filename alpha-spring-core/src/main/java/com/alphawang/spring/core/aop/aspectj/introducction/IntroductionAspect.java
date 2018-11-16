package com.alphawang.spring.core.aop.aspectj.introducction;

import com.alphawang.spring.core.aop.Waiter;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Aspect
public class IntroductionAspect {
    
    @DeclareParents(
        value = "com.alphawang.spring.core.aop.NaiveWaiter",
        defaultImpl = SmartSeller.class
    )
    public Seller seller;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean/aop.xml");
        Waiter waiter = (Waiter) context.getBean("waiter");
        
        System.out.println("getBean waiter: " + waiter);
        waiter.greetTo("Alpha");
        waiter.serveTo("AlphaWang");

        /**
         * XML配置：
         * <aop:aspectj-autoproxy/>
         * <bean class="com.alphawang.spring.core.aop.aspectj.introducction.IntroductionAspect"/>
         * 
         * 为NaiveWaiter新增Seller接口实现！！
         * Waiter 就可以强制转换为 Seller !!!
         */
        Seller seller = (Seller) waiter;
        seller.sell("iPhoneX");
    }
}
