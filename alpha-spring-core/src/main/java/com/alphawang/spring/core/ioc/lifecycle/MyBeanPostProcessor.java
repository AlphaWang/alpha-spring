package com.alphawang.spring.core.ioc.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

/**
 * TODO 为什么没有生效？
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    
    private static final String TARGET_BEAN = "lifecycleCar";
    
    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals(TARGET_BEAN)) {
            System.out.println("...BeanPostProcessor.postProcessBeforeInitialization");
            LifecycleCar car = (LifecycleCar) bean;
            car.setColor("postProcessBeforeInitializationBLUE");
        }
        
        return bean;
    }

    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals(TARGET_BEAN)) {
            System.out.println("...BeanPostProcessor.postProcessAfterInitialization");
            LifecycleCar car = (LifecycleCar) bean;
            car.setBrand("postProcessAfterInitialization-" + car.getBrand());
        }
        return bean;
    }
}
