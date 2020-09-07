package de.cofinpro.noah.pizzaup.app;

public class Pizza {
    int id;
    String name;
    double price;
    String imgsrc;
    String zutaten;

    public Pizza(int pId, String pName, double pPrice, String pimgsrc, String pZutaten) {
        id = pId;
        name = pName;
        price = pPrice;
        imgsrc = pimgsrc;
        zutaten = pZutaten;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public double getPrice() {
        return this.price;
    }

    public String getZutaten() {
        return this.zutaten;
    }
}
