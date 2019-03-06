package com.alphawang.spring.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * mvn clean package
 */
@Controller
@Slf4j
public class HelloWorldController {
    
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello mvc (annotation)!";
    }
    
}
