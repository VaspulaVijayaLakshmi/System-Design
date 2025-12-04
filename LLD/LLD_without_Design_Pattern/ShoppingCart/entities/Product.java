package LLD_without_Design_Pattern.ShoppingCart.entities;

public class Product {

    String productId;
    String productName;
    double price;
    boolean outOfStock;

    public Product(String productId, String productName, double price){
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        outOfStock = false;
    }

    public void setOutOfStock(boolean status){
        this.outOfStock = status;
    }

    public boolean getOutOfStock(){
        return this.outOfStock;
    }


}
