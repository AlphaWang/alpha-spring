package com.alphawang.spring.core.feature.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

public class ResourceLoaderDemo {

    public static void main(String[] args) {
        ResourcePatternResolver resourceLoader = new PathMatchingResourcePatternResolver();

        try {
            Resource[] resources = resourceLoader.getResources("classpath*:conf/*.txt");
            
            for (Resource resource : resources) {
                System.out.println(resource.getFilename());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
