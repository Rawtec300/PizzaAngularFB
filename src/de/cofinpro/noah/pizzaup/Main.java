package de.cofinpro.noah.pizzaup;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/Main", initParams = {
        @WebInitParam(name = "name", value = "")
})
public class Main extends HttpServlet{

    private String msg;

    public void init(){
        msg = ", this is the laptop speaking!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");

        response.setHeader("name", "Roman");
        String username = response.getHeader("name");
        PrintWriter output = response.getWriter();

        output.println("<h1>" + "Hallo " + username + msg + "<h1>");

    }


    public void destroy(){
        //do nothing
    }
}
