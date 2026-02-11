package models;

import java.util.UUID;

public class MenuItem {

    String itemId;
    String name;
    double price;
    boolean available;

    public MenuItem( String name, double price) {
        this.itemId = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
    }

    //getters and setters for the menu item class

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }


}
