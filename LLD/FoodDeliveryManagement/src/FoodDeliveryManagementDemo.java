import models.*;

import java.util.ArrayList;
import java.util.List;

public class FoodDeliveryManagementDemo {

    public static void main(String[] args) {
        // Create some customers

        User user1 = new User("Alice");

        MenuItem menuItem1 = new MenuItem("Pizza", 10.99);
        MenuItem menuItem2 = new MenuItem("Burger", 8.99);


        List<MenuItem> menuitems = List.of(
                 menuItem1,menuItem2
        );


        Restaurant rest1 = new Restaurant("Taj", "Delhi", menuitems);
        DeliveryAgent deliveryAgent1 = new DeliveryAgent("Bob");

        FoodDeliveryManagement management = FoodDeliveryManagement.getInstance();

        management.addUsers(user1);
        management.addRestaurant(rest1);
        management.addDeliveryAgent(deliveryAgent1);

        List<OrderItem> orderItems = List.of(
                new OrderItem(menuItem1,2),
                new OrderItem(menuItem2,1)
        );

        //place the order
        Order order1 = management.placeOrder(user1.getUserId(), rest1.getRestId(),orderItems) ;


        //assign the delivery agent
        DeliveryAgent deliveryAgent = management.getAvailableDeliveryAgent();
        if (deliveryAgent != null) {

            order1.assignDeliveryAgent(deliveryAgent.getAgentId());

        } else {
            System.out.println("No delivery agents available.");
        }


        double price = management.calculateOrderPrice(order1.getOrderId());
        System.out.println("Order price is " + price);
        System.out.println("Order status is " + order1.getOrderStatus());
//        System.out.println("Delivery agent assigned is " + order1.);


}}
