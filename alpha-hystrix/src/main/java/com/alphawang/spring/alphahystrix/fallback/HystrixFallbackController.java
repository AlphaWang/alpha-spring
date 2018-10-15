package com.alphawang.spring.alphahystrix.fallback;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HystrixFallbackController {
    
//    @HystrixCommand(commandProperties = {
//        // see HystrixCommandProperties
//        @HystrixProperty()
//    })
    @GetMapping("/hystrix/fallback")
    public String testFallback() {
        return "success";
    }
    
    private String fallback() {
        return "fall back: try later";
    }
}
