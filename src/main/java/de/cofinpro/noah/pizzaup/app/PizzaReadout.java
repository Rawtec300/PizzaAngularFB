package de.cofinpro.noah.pizzaup.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/pizza-readout")
public class PizzaReadout extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("application/json");

        PrintWriter out = response.getWriter();
        String title = "Pizzaliste";

        response.setHeader("Access-Control-Allow-Origin", "*");

        out.println("[\"Calzone\", \"Salami\", \"Quattro-Fromaggi\", \"Fungi\"]");


    }


    }
