package LLD_without_Design_Pattern.ShoppingCart.entities;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    Map<Product, Integer> cart;

    public ShoppingCart(){
        cart = new HashMap<>();
    }

    public void addToCart(Product p){

        if(p.outOfStock) {
            System.out.println("Product is out of stock, cannot add to cart");
            return;
        }

        //check if its already in cart, if yes increment count
        cart.put(p, cart.getOrDefault(p, 0) + 1);
    }


    public void removeFromCart(Product p){
        if(cart.containsKey(p)){
            int count = cart.get(p);
            if(count == 1){
                cart.remove(p);
            }else{
                cart.put(p, count - 1);
            }
        }

        else{
            System.out.println("Item doesnt exist in cart");
        }
    }

    public Map<Product, Integer> getCartItems(){
        return cart;
    }

    public void clearCart(){
        cart.clear();
    }


    public void displayCart(){
        for(Map.Entry<Product, Integer> entry : cart.entrySet()){
            Product p = entry.getKey();
            int quantity = entry.getValue();
            System.out.println("Product: " + p.productName + ", Quantity: " + quantity + ", Price per unit: " + p.price);
        }
    }

    public double calculateTotal(){
        double total = 0.0;
        for(Map.Entry<Product, Integer> entry : cart.entrySet()){
            Product p = entry.getKey();
            int quantity = entry.getValue();
            total += p.price * quantity;
        }
        return total;
    }
}
