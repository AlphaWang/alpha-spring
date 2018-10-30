package com.alphawang.spring.core.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@WebServlet(
    urlPatterns = "/hello/servlet/async",
    asyncSupported = true
)
public class AsyncServletDemo extends HttpServlet {

    /**
     * >>> Async Servlet doGet DONE !!!
     * >>> Async Servlet output: Hello Servlet ASYNC! 33
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AsyncContext asyncContext = req.startAsync();
        asyncContext.start(new Runnable() {
            @Override 
            public void run() {

                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                    
                    String message = getMessage(33);
                    System.out.println(">>> Async Servlet output: " + message);
                    
                    resp.getWriter().println(message);
                    asyncContext.complete();
                    
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        System.out.println(">>> Async Servlet doGet DONE !!!");

    }
    
    public String getMessage(int number) {
        return "Hello Servlet ASYNC! " + number;
    }
}
