package com.alphawang.spring.feature;

import com.alphawang.spring.servlet.MyServlet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;

import java.lang.reflect.Method;
import java.util.Arrays;

@Slf4j
public class ParameterNameDiscovery {
    
    public static void main(String[] args) {
        ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();
        
//        Method[] methods = MyServlet.class.getMethods();
        Method[] methods = NoInterface.class.getMethods();
        
        for (Method method : methods) {
            String[] params = parameterNameDiscoverer.getParameterNames(method);
            log.info("Params for {} : {}", method.getName(), params == null ? "" : Arrays.asList(params)); 
        }
        
    }
}
