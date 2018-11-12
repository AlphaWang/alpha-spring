package com.alphawang.spring.core.ioc.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class OnSystemPropertyCondition implements Condition {
    @Override 
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Map<String, Object> annotationAttributes = annotatedTypeMetadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        String propName = String.valueOf(annotationAttributes.get("name"));
        String propValue = String.valueOf(annotationAttributes.get("value"));
        
        String systemPropValue = System.getProperty(propName);
        return propValue.equals(systemPropValue);
    }
}
