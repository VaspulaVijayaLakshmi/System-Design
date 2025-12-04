package LLD_without_Design_Pattern.ShoppingCart.entities;

import java.util.List;

public class ShoppingCartDemo {

    public static void main(String[] args) {
        System.out.println("Shopping Cart Demo");

        //create products
        Product p1 = new Product("P001", "Laptop", 800.0);
        Product p2 = new Product("P002", "Smartphone", 500.0);
        Product p3 = new Product("P003", "Headphones", 150.0);


        //create users
        Guest guest1 = new Guest("G001", "Alice", "alice@gmmail.com");
        Guest guest2 = new Guest("G002", "Bob","bob@gmail.com");


        //check orders
        ShoppingSystem shoppingSystem = new ShoppingSystem();

        //register users
        shoppingSystem.registerUser(guest1);
        shoppingSystem.registerUser(guest2);


        //add products to cart
        shoppingSystem.addToCart(guest1, p1);
        shoppingSystem.addToCart(guest1, p2);
        shoppingSystem.addToCart(guest1, p3);

        //remove from cart
        shoppingSystem.removeFromCart(guest1, p3);


        //get cart
        ShoppingCart shoppingCart = shoppingSystem.getCart(guest1);
        System.out.println("Items in shopping cart:");
        for(Product p : shoppingCart.getCartItems().keySet()){
            System.out.println("Product: " + p.productName + ", Quantity: " + shoppingCart.getCartItems().get(p) + ", Price per unit: " + p.price);
        }


       //order products
        Order order1 = shoppingSystem.order(guest1);

        List<Order> guestOrders = shoppingSystem.getOrders(guest1);
        for (Order order : guestOrders) {
            System.out.println("Order ID: " + order.getOrderId() + " Total Amount: " + order.getTotalAmount() + " Status: " + order.getOrderStatus());
        }

        System.out.println("Status before payment: " + order1.getOrderStatus());


        double totalAmount = order1.getTotalAmount();
        Payment payment = new Payment(totalAmount,  PaymentMethod.UPI);

        System.out.println("payment status before payment: " + payment.paymentStatus);

        shoppingSystem.payWithUPI(payment);

        order1.setPayment(payment);

        System.out.println("payment status after payment: " + payment.paymentStatus);




    }
}
