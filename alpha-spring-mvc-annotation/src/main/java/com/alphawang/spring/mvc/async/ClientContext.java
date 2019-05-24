package com.alphawang.spring.mvc.async;

import lombok.Data;

@Data
public class ClientContext {
    
    private RequestContext requestContext;
    
    public String getRequestUrl() {
        return requestContext.getRequestUrl();
    }
}
