package com.alphawang.spring.core.feature.parametername;

import com.alphawang.spring.core.servlet.MyServlet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;

import java.lang.reflect.Method;
import java.util.Arrays;

@Slf4j
public class ParameterNameDiscovery {
    
    public static void main(String[] args) {
        printMethods(NoInterface.class);
        printMethods(MyServlet.class);
        
    }
    
    private static void printMethods(Class clazz) {
        log.info("---- class: " + clazz.getSimpleName());
        Method[] methods = clazz.getMethods();
        ParameterNameDiscoverer parameterNameDiscoverer = new DefaultParameterNameDiscoverer();
        for (Method method : methods) {
            String[] params = parameterNameDiscoverer.getParameterNames(method);
            log.info("Params for {} : {}", method.getName(), params == null ? "" : Arrays.asList(params));
        }
    }
}
