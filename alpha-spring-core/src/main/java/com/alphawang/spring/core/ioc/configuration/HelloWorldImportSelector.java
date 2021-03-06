package com.alphawang.spring.core.ioc.configuration;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class HelloWorldImportSelector implements ImportSelector {
    @Override 
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[] { HelloWorldConfiguration.class.getName() };
    }
}
