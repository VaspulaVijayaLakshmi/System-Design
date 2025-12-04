package LLD_Interview_Problems.InventoryManagement.models;

import LLD_Interview_Problems.InventoryManagement.enums.Category;

public class ClothingProduct extends Product{

    String size;
    String color;

    public ClothingProduct(String sku ,String name, double price, int quantity) {
        super(sku, name, price, quantity, Category.CLOTHING);
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
