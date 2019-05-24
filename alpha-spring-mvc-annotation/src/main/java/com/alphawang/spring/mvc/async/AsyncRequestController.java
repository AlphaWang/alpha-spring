package com.alphawang.spring.mvc.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AsyncRequestController {
    
    @Autowired
    private RequestContext requestContext;
    @Autowired
    private AsyncRequestService asyncRequestService;
    
    @GetMapping("/mvc/async")
    public String test(HttpServletRequest request) {
        requestContext.setRequestUrl(request.getRequestURI());
        
        ClientContext clientContext = new ClientContext();
        clientContext.setRequestContext(requestContext);

        System.out.println(Thread.currentThread().getName() + " - start async");
        asyncRequestService.doService(clientContext);
        
        return "DONE";
    }
}
