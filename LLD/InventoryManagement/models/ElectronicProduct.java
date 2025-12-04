package LLD_Interview_Problems.InventoryManagement.models;

import LLD_Interview_Problems.InventoryManagement.enums.Category;

public class ElectronicProduct extends Product{

    private String brand;
    private int warrantyPeriod; // in months

    public ElectronicProduct(String sku ,String name, double price, int quantity) {
        super(sku, name, price, quantity, Category.ELECTRONICS);
    }

    public String getBrand() {
        return brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }
}
