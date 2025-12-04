package LLD_without_Design_Pattern.ShoppingCart.entities;

import LLD_without_Design_Pattern.ShoppingCart.models.OrderStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingSystem {

    Map<Guest, List<Order>> orders;
    Map<Guest,ShoppingCart> carts;

    //all the products in the system
    Map<Product, Integer> products;
    Payment payment;


    public  ShoppingSystem(){
        orders = new HashMap<>();
        carts = new HashMap<>();
        products = new HashMap<>();
    };


    public void addProduct(Product p, int quantity){
        products.put(p, products.getOrDefault(p,0)+quantity);
    }


    // register User
    public void registerUser(Guest guest){
        carts.put(guest,new ShoppingCart());
    }

    //Add Items to users shopping cart
    public void addToCart(Guest guest, Product p){
        try{

            ShoppingCart cart = getCart(guest);
            if(cart==null){
                System.out.println("Guest not registered.");
                return ;
            }

            //check if product is not out of stock
//            int inventoryCount = products.getOrDefault(products,0);
//            if(inventoryCount<=0){
//                System.out.println("Product is out of stock.");
//                return ;
//            }

            cart.addToCart(p);
            System.out.println("Item added to cart");
        }
        catch(Exception e){
            System.out.println("Error in adding to cart." + e.getMessage());
        }
    }

    public void removeFromCart(Guest guest, Product p){
        try{
            ShoppingCart cart = carts.getOrDefault(guest,null);
            if(cart==null){
                System.out.println("Guest not registered.");
                return ;
            }
            cart.removeFromCart(p);
            System.out.println("Item removed from cart.");
        }
        catch(Exception e){
            System.out.println("Error in adding to cart." + e.getMessage());
        }

    }

    ShoppingCart getCart(Guest guest){
            return carts.getOrDefault(guest,null);
    }

    //Add items to guest Orders
    public Order order(Guest guest){
        ShoppingCart cart = getCart(guest);
        if(cart==null){
            System.out.println("Please Register to make an order");
            return null;
        }

        double totalAmount = cart.calculateTotal();
        System.out.println("Total amount: " + totalAmount);

        Order newOrder = new Order(totalAmount);

        List<Order> guestOrders = orders.getOrDefault(guest, new ArrayList<>());
        guestOrders.add(newOrder);

        // put the updated list back
        orders.put(guest, guestOrders);

        // clear cart
        cart.clearCart();

        //need to add it to the guest order history as well
        guest.updateOrderHistory(newOrder);

        return newOrder;

    }

    public List<Order> getOrders(Guest guest){
        return orders.getOrDefault(guest, new ArrayList<>());
    }


    public List<Order> getOrderHistory(Guest guest){
        return guest.getOrderHistory();
    }


    public OrderStatus OrderStatus(Guest guest, Order order){

        List<Order> guestOrders = orders.getOrDefault(guest, new ArrayList<>());
        for(Order o: guestOrders){
            if(o.equals(order)){
                return o.getOrderStatus();
            }
        }
        return null;
    }

    //Once Item is shipped, update order status
    public void UpdateOrderStatus(Guest guest, Order order, OrderStatus orderStatus){

        //here we need state pattern to manage order status more effectively
        //or else we cannot change the item sttaus from ordered to delivered direclty,
        //we need to check current in which state it is.

        //but for now do it normally
        List<Order> guestOrders = orders.getOrDefault(guest, new ArrayList<>());
        for(Order o: guestOrders){
            if(o.equals(order)){
                o.updateOrderStatus(orderStatus);
            }
        }

    }

    //Make payment for order
    void payWithUPI(Payment payment){

        System.out.println("Payment done using UPI");
        payment.paymentStatus = PaymentStatus.COMPLETED;

    }

    //other methods......



}
