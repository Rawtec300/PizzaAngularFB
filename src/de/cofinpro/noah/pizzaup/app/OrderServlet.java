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

@WebServlet(value = "/orders")
public class OrderServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setHeader("Access-Control-Allow-Origin", "*");

        Collection<Order> orders = DataStore.getInstance().getAllOrders();
        JsonArray orderArray = new JsonArray();
        for (Order orderObject : orders) {
            JsonObject jsonorder = new JsonObject();
            JsonObject customer = new JsonObject();
            jsonorder.addProperty("id", orderObject.id);
            jsonorder.addProperty("pizza", orderObject.pizza);
            customer.addProperty("name", orderObject.customer.name);
            customer.addProperty("address", orderObject.customer.address);
            customer.addProperty("phone", orderObject.customer.telephone);
            jsonorder.add("customer", customer);
            orderArray.add(jsonorder);
        }
        PrintWriter out = response.getWriter();
        out.println(orderArray.toString());
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");

        BufferedReader reader = request.getReader();
        String input = reader.lines().collect(Collectors.joining("\n"));

        JsonObject object = new JsonParser().parse(input).getAsJsonObject();
        JsonObject customerObject = object.get("customer").getAsJsonObject();

        String pizza = object.get("pizza").getAsString();
        String customerName = customerObject.get("name").getAsString();
        String customerAddress = customerObject.get("address").getAsString();
        String customerPhone = customerObject.get("phone").getAsString();
        Customer customer = new Customer(customerName, customerAddress, customerPhone);

        DataStore.getInstance().putOrder(new Order(pizza, customer));
    }
}
