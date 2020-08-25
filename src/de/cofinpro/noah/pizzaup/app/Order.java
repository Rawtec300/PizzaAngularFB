package de.cofinpro.noah.pizzaup.app;

public class Order {
    int id;
    String pizza;
    Customer customer;
    public Order(String pPizza, Customer pCustomer){
        pizza = pPizza;
        customer = pCustomer;
    }

    public String getPizza() {
        return pizza;
    }

    public Customer getCustomer() {
        return customer;
    }
}
