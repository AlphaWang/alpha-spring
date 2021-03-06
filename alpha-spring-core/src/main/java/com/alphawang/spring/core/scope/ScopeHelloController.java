package com.alphawang.spring.core.scope;

import com.alphawang.spring.core.scope.bean.SessionHolderWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ScopeHelloController {
    
    @Autowired
    private SessionHolderWrapper sessionHolderWrapper;
    
    @GetMapping("/scope/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/scope/id")
    public String id() {
        return sessionHolderWrapper.getSid();
    }
}
