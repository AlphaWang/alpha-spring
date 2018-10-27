package com.alphawang.spring.core.ioc.lifecycle;

import lombok.Data;

@Data
public class LifecycleCar {
    private String brand;
    private String color;
    private int maxSpeed;
    
    public void init() {
        this.color = "BLUE";
    }
    
    public void destroy() {
        this.color = null;
    }
}
