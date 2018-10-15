package com.alphawang.spring.alphahystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
public class AlphaHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlphaHystrixApplication.class, args);
    }
}
