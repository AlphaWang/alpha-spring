package com.alphawang.spring.core.ioc.configuration;

import com.alphawang.spring.core.ioc.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnSystemProperty(name = "user.name", value="Alpha")
@EnableHelloWorld
public class HelloWorldAutoConfiguration {
}
