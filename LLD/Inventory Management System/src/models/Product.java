package models;

public class Product {

    String productId;
    String name;
    double price;

    public Product(String name, double price) {
        this.productId = java.util.UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
    }

     public String getProductId() {
            return productId;
        }

     public String getName() {
         return name;
     }

     public double getPrice() {
         return price;
     }
}
