package LLD_Interview_Problems.InventoryManagement.models;

import LLD_Interview_Problems.InventoryManagement.enums.Category;

public class GroceryProduct extends Product{

    private String expirationDate; // in format YYYY-MM-DD

    public GroceryProduct(String sku ,String name, double price, int quantity) {
        super(sku, name, price, quantity, Category.GROCERY);
    }

    public String getExpirationDate() {
        return expirationDate;
    }
}
