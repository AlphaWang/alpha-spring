package com.alphawang.spring.core.ioc.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    /**
     * 该方法会在 装载配置文件之后、初始化Bean之前调用
     */
    @Override 
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) 
        throws BeansException {
        
        System.out.println("...postProcessBeanFactory()");
        BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition("lifecycleCar");

        /**
         * 若在addPropertyValue之前 先getBean，则brand不会被修改，why?
         */
//        LifecycleCar car = configurableListableBeanFactory.getBean("lifecycleCar", LifecycleCar.class);
//        System.out.println("...bean 1: " + car);
        
        System.out.println("...propertyValues 1: " + beanDefinition.getPropertyValues());
        beanDefinition.getPropertyValues().addPropertyValue("brand", "QQ");
        System.out.println("...propertyValues 2: " + beanDefinition.getPropertyValues());

        LifecycleCar  car = configurableListableBeanFactory.getBean("lifecycleCar", LifecycleCar.class);
        System.out.println("...bean 2: " + car);
    }
}
