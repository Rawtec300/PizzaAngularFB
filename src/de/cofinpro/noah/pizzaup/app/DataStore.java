package de.cofinpro.noah.pizzaup.app;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DataStore {
    //Map of names to Pizza instances
    private Map<String, Pizza> pizzaMap = new HashMap<>();
    private Map<String, Order> orders = new HashMap<>();

    //this class is a singleton and should not be instantiated directly
    private static DataStore instance = new DataStore();

    public static DataStore getInstance() {
        return instance;
    }

    //private constructor so people know to use the getInstance() function instead
    private DataStore() {
        pizzaMap.put("Tonno", new Pizza(14, "Tonno", 6, "Tonno1.png", "Tomatensauce, Paprika, Pilze, Salami, Mozzarella"));
        pizzaMap.put("Pepperoni", new Pizza(12, "Pepperoni", 6, "Pepperoni1.jpg", "Tomatensauce, Pepperonisalami, Mozzarella"));
        pizzaMap.put("Pulled Pork", new Pizza(18, "Pulled Pork", 7, "PulledPork1.jpg", "BBQ Sauce, Pulled Pork, Mozzarella"));
        pizzaMap.put("White", new Pizza(20, "White", 6, "White1.jpg", "Schinken, Mozzarella, Pfeffer, Olivenöl"));
        orders.put("Max", new Order("Salami", new Customer("Max Musterman", "Bergstraße 1", "01511234567")));
    }

    public Pizza getPizza(String pizza) {
        return pizzaMap.get(pizza);
    }

    public Collection<Pizza> getAllPizzas() {
        return pizzaMap.values();
    }

    public Collection<Order> getAllOrders() {
        return orders.values();
    }

    public void putOrder (Order order) {
        orders.put(order.getCustomer().getName(), order);
    }

    public void putPizza(Pizza pizza) {
        pizzaMap.put(pizza.getName(), pizza);
    }
}
