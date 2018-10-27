package com.alphawang.spring.core.ioc.lifecycle;

import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@Data
public class LifecycleCar implements ApplicationContextAware {
    private String brand;
    private String color;
    private int maxSpeed;
    
    public void init() {
        System.out.println("...LifecycleCar.init() " + this.color + " > initBLUE");
        this.color = "initBLUE";
    }
    
    public void destroy() {
        System.out.println("...LifecycleCar.destroy()");
        this.color = null;
    }

    /**
     * 在init之前调用
     */
    @Override 
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("...setApplicationContext: " + applicationContext);
        
    }
}
