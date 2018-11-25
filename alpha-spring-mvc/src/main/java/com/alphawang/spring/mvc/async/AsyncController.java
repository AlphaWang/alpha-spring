package com.alphawang.spring.mvc.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class AsyncController {
    
    @RequestMapping("/api/sync")
    public String api() {
        log.error(">>>>>> /api/sync");
        
        return "sync api result";
    } 
    
    @RequestMapping("/api/async")
    public Callable<String> asyncApi() {
        log.error(">>>>>> /api/async");
        
        return new Callable<String>() {
            @Override 
            public String call() throws Exception {
                log.error(" ----- Start Async...");
                TimeUnit.SECONDS.sleep(10);
                log.error(" ----- End Async...");
                
                return "async api result";
            }
        };
    }
}
