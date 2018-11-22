package com.alphawang.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * mvn clean package
 */
@Controller
public class HelloWorldController {
    
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
