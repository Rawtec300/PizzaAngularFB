package de.cofinpro.noah.pizzaup;

import java.io.IOException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.*;
import java.util.*;

// Implements Filter class

/*@WebFilter(urlPatterns = {"/*"}, initParams = {
        @WebInitParam(name = "test-param", value = "Initialization Paramter")})*/
public class LogFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        // Get init parameter
        String testParam = config.getInitParameter("test-param");

        //Print the init parameter
        System.out.println("Test Param: " + testParam);
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        // Log the current timestamp.
        System.out.println("Time " + new Date().toString());

        // Pass request back down the filter chain
        chain.doFilter(request,response);
    }

    public void destroy( ) {
      /* Called before the Filter instance is removed
      from service by the web container*/
    }
}
