package com.alphawang.spring.mvc.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncRequestService {


    /**
     * 测试异步获取 Request Bean
     *
     * try to reproduce: 
     *
     * ERROR 2019-05-24 14:50:24 [pool-27-thread-11] HarnessTooling.serializeContext:83 
     * - Failed to serialize ClientContext AbTestContext@489c2128, error message: {}
     * com.fasterxml.jackson.databind.JsonMappingException: Error creating bean with name 'scopedTarget.metaDataContext': 
     * Scope 'request' is not active for the current thread; 
     *
     * consider defining a scoped proxy for this bean if you intend to refer to it from a singleton; 
     * nested exception is java.lang.IllegalStateException: No thread-bound request found: 
     * Are you referring to request attributes outside of an actual web request, or processing a request outside of the originally receiving thread? 
     * If you are actually operating within a web request and still receive this message, 
     * your code is probably running outside of DispatcherServlet/DispatcherPortlet: 
     * In this case, use RequestContextListener or RequestContextFilter to expose the current request. 
     */

    @Async("loggerExecutor")
    public void doService(ClientContext clientContext) {
        System.out.println(Thread.currentThread().getName() + " ASYNC THREAD");
        
        System.out.println(clientContext);
        System.out.println(clientContext.getRequestUrl());
        System.out.println(clientContext.getRequestContext());
        
        System.out.println(Thread.currentThread().getName() + " - DONE" );
    }
    


}
