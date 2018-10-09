package com.alphawang.spring.core.feature.property;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * https://docs.spring.io/spring/docs/5.1.1.BUILD-SNAPSHOT/spring-framework-reference/core.html#beans-using-propertysource
 */
@Slf4j
@RestController
@PropertySource("classpath:myProperties.properties")
public class PropertySourceDemo {
    @Autowired 
    private Environment env;
    
    @GetMapping("properties/{name}")
    public String getProperty(@PathVariable String name) {
        String v = env.getProperty(name);
        log.warn("get property: {} = {}", name, v);
        return v;
    }

}
