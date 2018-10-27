package com.alphawang.spring.core.ioc.bean.applicationcontext;

import com.alphawang.spring.core.ioc.bean.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfiguration {
    
    @Bean(name = "car")
    public Car buildCar() {
         Car car = new Car();
         car.setBrand("Audi");
         car.setColor("Black");
         car.setMaxSpeed(200);
         
         return car;
    }
}
