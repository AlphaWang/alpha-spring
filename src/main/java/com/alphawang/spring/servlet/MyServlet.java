package com.alphawang.spring.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1. 实现
 *      @WebServlet
 *      extends HttpServlet
 *      注册：@ServletComponentScan
 *      
 * 2. URL映射
 *      @WebServlet(urlPatterns = "")
 *      
 * 3. 注册
 *      @ServletComponentScan(basePackages="")
 *      
 */
@WebServlet(urlPatterns = "/hello/servlet")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        resp.getWriter().println("Hello Servlet!");

    }
}
