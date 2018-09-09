package com.alphawang.spring.core.scope.interceptor;

import com.alphawang.spring.core.jar.SessionInterceptor;
import com.alphawang.spring.core.scope.bean.SessionHolderWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class ExtendedSessionInterceptor extends SessionInterceptor {

    /**
     * sessionHolderWrapper.SessionHolder == SubSessionHolder
     */
    @Autowired
    private SessionHolderWrapper sessionHolderWrapper;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean result = super.preHandle(request, response, handler);
        log.info("from sub interceptor: {}", sessionHolderWrapper.getSid());
        
        return result;
    }
}
