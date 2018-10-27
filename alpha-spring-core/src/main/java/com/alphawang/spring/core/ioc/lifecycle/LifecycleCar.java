package com.alphawang.spring.core.ioc.lifecycle;

import lombok.Data;

@Data
public class LifecycleCar {
    private String brand;
    private String color;
    private int maxSpeed;
    
    public void init() {
        System.out.println("...LifecycleCar.init() " + this.color + " > BLUE");
        this.color = "BLUE";
    }
    
    public void destroy() {
        System.out.println("...LifecycleCar.destroy()");
        this.color = null;
    }
}
