package de.cofinpro.noah.pizzaup.app;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DataStore{
    //Map of names to Pizza instances
    private Map<String, Pizza> pizzaMap = new HashMap<>();

    //this class is a singleton and should not be instantiated directly
    private static DataStore instance = new DataStore();
    public static DataStore getInstance(){
        return instance;
    }

    //private constructor so people know to use the getInstance() function instead
    private DataStore() {
        //dummy Data
        pizzaMap.put("Tonno", new Pizza(14, "Tonno", 6, "Tomatensauce, Paprika, Pilze, Salami, Mozzarella" ));
        pizzaMap.put("Pepperoni", new Pizza(12, "Pepperoni", 6, "Tomatensauce, Pepperonisalami, Mozzarella"));
        pizzaMap.put("Pulled Pork", new Pizza(18,"Pulled Pork", 7, "BBQ Sauce, Pulled Pork, Mozzarella"));
    }

    public Pizza getPizza(String pizza){
        return pizzaMap.get(pizza);
    }

    public Collection<Pizza> getAll(){
        Collection<Pizza> values = pizzaMap.values();
        return values;
    }

    public void putPizza(Pizza pizza){
        pizzaMap.put(pizza.getName(), pizza);
    }
}
