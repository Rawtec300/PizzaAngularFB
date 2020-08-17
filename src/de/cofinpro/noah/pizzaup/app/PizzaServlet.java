package de.cofinpro.noah.pizzaup.app;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.stream.Collectors;


@WebServlet(value = "/pizza")
public class PizzaServlet extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");

        Collection<Pizza> pizzen = DataStore.getInstance().getAll();
        JsonArray pizzaArray = new JsonArray();
        for (Pizza pizzaObject: pizzen){
            pizzaArray.add(pizzaObject.id);
            pizzaArray.add(pizzaObject.name);
            pizzaArray.add(pizzaObject.price);
            pizzaArray.add(pizzaObject.zutaten);

        }
        PrintWriter out = response.getWriter();
/*

        String pizzastring = "[";
        for(Pizza pizza: pizzen){
            pizzastring += "{\n";
            pizzastring += "\"id\": " + pizza.id + ",\n";
            pizzastring += "\"name\": \"" + pizza.name + "\",\n";
            pizzastring += "\"price\": " + pizza.price + ",\n";
            pizzastring += "\"zutaten\": \"" + pizza.zutaten + "\"\n";
            pizzastring += "},";
        }
        pizzastring = pizzastring.substring(0, pizzastring.length()-1);
        pizzastring += "]";
        out.println(pizzastring);
        out.println("neues Jsonobjekt");
*/


        //mit den korrekten JSon Format muss noch rumgespielt werden.
        for(int i = 0; i <= pizzaArray.size(); i++){
            out.println(pizzaArray.get(i).toString() + ",");
            
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setHeader("Access-Control-Allow-Origin", "*");

        BufferedReader reader = request.getReader();

        String input = reader.lines().collect(Collectors.joining("\n"));

        JsonObject obj = new JsonParser().parse(input).getAsJsonObject();

        int id = Integer.parseInt(obj.get("id").getAsString());
        String name = obj.get("name").getAsString();
        double price = Double.parseDouble(obj.get("price").getAsString());
        String zutaten = obj.get("zutaten").getAsString();

        DataStore.getInstance().putPizza(new Pizza(id, name, price, zutaten));
    }
}

