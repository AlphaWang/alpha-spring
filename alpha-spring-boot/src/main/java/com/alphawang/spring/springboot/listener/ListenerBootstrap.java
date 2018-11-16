package com.alphawang.spring.springboot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class ListenerBootstrap {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        
        context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override 
            public void onApplicationEvent(ApplicationEvent applicationEvent) {
                log.error(">>>>>>>>>> Listener, event={}", applicationEvent);
            }
        });
        
        //ContextRefreshedEvent
        context.refresh();

        //PayloadApplicationEvent
        context.publishEvent("event-1");
        context.publishEvent("event-2");
        //ListenerBootstrap$2
        context.publishEvent(new ApplicationEvent("Source1"){});
        
        //ContextClosedEvent
        context.close();
    }
}
