package de.cofinpro.noah.pizzaup.app;

public class Customer {
    String name;
    String address;
    String telephone;

    public Customer(String pName, String pAdress, String pTelephone){
        name = pName;
        address = pAdress;
        telephone = pTelephone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }


}
