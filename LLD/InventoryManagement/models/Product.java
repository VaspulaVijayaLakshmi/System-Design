package LLD_Interview_Problems.InventoryManagement.models;

import LLD_Interview_Problems.InventoryManagement.enums.Category;

public class Product {

    private String sku;
    private String name;
    private double price;
    private int quantity;
    private Category category;

    public Product(String sku, String name, double price, int quantity, Category category) {
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }


    public Category getCategory() {
        return category;
    }


}


//Each product has attributes like SKU(Stock Keeping Unit - Unique Id of a Product), name, price, and quantity.