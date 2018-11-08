package com.alphawang.spring.core.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("Java7")
@Service
public class Java7CalculateService implements CalculateService {
    
    @Override 
    public int sum(Integer... values) {
        System.out.println("Java 7 sum.");
        
        int sum = 0;
        for (int v : values) {
            sum += v;
        }
        return sum;
    }
}
