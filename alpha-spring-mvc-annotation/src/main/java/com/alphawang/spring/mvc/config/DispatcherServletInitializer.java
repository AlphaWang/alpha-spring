package com.alphawang.spring.mvc.config;

import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);

//        ServletRegistration.Dynamic registration = servletContext.addServlet(
//            "dispatcher", new DispatcherServlet());
//
//        registration.setLoadOnStartup(1);
//        registration.addMapping("/");
    }
        
    @Override 
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override 
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { DispatcherServletConfiguration.class };
    }

    @Override 
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
