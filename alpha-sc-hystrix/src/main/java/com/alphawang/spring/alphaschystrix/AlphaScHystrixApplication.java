package com.alphawang.spring.alphaschystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableCircuitBreaker
//@SpringCloudApplication
public class AlphaScHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlphaScHystrixApplication.class, args);
    }
}
