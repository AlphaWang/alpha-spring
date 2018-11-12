package com.alphawang.spring.core.ioc.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Profile("Java8")
@Service
public class Java8CalculateService implements CalculateService {
    
    @Override 
    public int sum(Integer... values) {
        System.out.println("Java 8 sum.");
        
        int sum = Stream.of(values).reduce(0, Integer::sum);
//        int sum = IntStream.of(values).sum();
        return sum;
    }
}
