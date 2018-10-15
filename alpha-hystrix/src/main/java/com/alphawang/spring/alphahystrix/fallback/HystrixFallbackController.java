package com.alphawang.spring.alphahystrix.fallback;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixFallbackController {
    
    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("/hystrix/fallback")
    public String testFallback() {
        int i = 1 / 0;
        return "success";
    }
    
    private String fallback() {
        return "fall back: try later";
    }
}
