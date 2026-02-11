import enums.OrderStatus;
import models.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


//needs to have a single object.
//singleton

public class FoodDeliveryManagement {

     private Map<String, User> users;
     private Map<String, Order> orders;
     private Map<String, Restaurant> restaurants;
     private Map<String, DeliveryAgent> deliveryAgents;


     //static methods can access only static variables.
     private static FoodDeliveryManagement instance;


     private FoodDeliveryManagement() {

         users = new ConcurrentHashMap<>();
            orders = new ConcurrentHashMap<>();
            restaurants = new ConcurrentHashMap<>();
            deliveryAgents = new ConcurrentHashMap<>();
     }


     public static synchronized   FoodDeliveryManagement getInstance() {

         if(instance==null){
             instance=new FoodDeliveryManagement();
             return instance;
         }

         return instance;

     }


     //add users
     public void addUsers(User user){
         users.put(user.getUserId(), user);
     }


    //remove users
    public void removeUser(String userId){
        users.remove(userId);
    }


    //add restaurants
    public void addRestaurant(Restaurant restaurant){
        restaurants.put(restaurant.getRestId(), restaurant);
    }


    //remove restaurant
    public void removeRestaurant(Restaurant restaurant){
        restaurants.remove(restaurant.getRestId());
    }


    //add delivery agents
    public void addDeliveryAgent(DeliveryAgent deliveryAgent){
        deliveryAgents.put(deliveryAgent.getAgentId(), deliveryAgent);
    }

    //remove delivery agents
    public void removeDeliveryAgent(DeliveryAgent deliveryAgent){
        deliveryAgents.remove(deliveryAgent.getAgentId());
    }


    //place order
    public Order placeOrder(String UserId, String restaurantId, List<OrderItem> orderItems){

        //check if the user and restaurant exists
         User user=users.get(UserId);
        Restaurant restaurant=restaurants.get(restaurantId);

        if(user!=null && restaurant!=null){
            Order order=new Order(UserId, restaurantId, orderItems);
            orders.put(order.getOrderId(), order);
            return order;
        }

        throw new RuntimeException("Invalid User or Restaurant");
    }


    //caclulate order price
    public double calculateOrderPrice(String orderId){

         Order order = orders.get(orderId);

         if(order!=null){

                double totalPrice=0;

                for(OrderItem orderItem : order.getOrderItems()){
                    totalPrice+=orderItem.getMenuItem().getPrice()*orderItem.getQuantity();
                }

                order.setPrice(totalPrice);
                return totalPrice;

         }

         throw new RuntimeException("Invalid Order");
    }




    //assign delivery agents
    public void AssignDeliveryAgent(String orderId){
        Order order=orders.get(orderId);

        if(order!=null){

           //get avaibale delivery agent
            DeliveryAgent deliveryAgent=getAvailableDeliveryAgent();

            //assign the delievry agent to this order
            order.assignDeliveryAgent(deliveryAgent.getAgentId());

            //make the delivery agent unavailable
            deliveryAgent.assignOrder();

            //update order sttsuas to OOD
            order.updateOrderStatus(OrderStatus.READY);
        }
    }


    //getAvaiableDeliveryAgent
    public DeliveryAgent getAvailableDeliveryAgent(){

         for(DeliveryAgent deliveryAgent : deliveryAgents.values()){
                if(deliveryAgent.isAvailable()){
                    return deliveryAgent;
                }
         }

         throw new RuntimeException("No available Delivery Agent");
    }




    //update order sttaus


    //STATE PATTERN CAN BE USED FOR THE ORDER STATUS, BUT FOR SIMPLICITY WE CAN JUST USE ENUMS.
    //BECAUSE There IF ORDER IS READY, THEN ONLY IT CAN BE DELIVERYED

    //IF ORDER IS READY , THEN IT CANNOT BE CANCELLED

    public OrderStatus updateOrderStatus(String orderId, OrderStatus status){
        Order order=orders.get(orderId);

        if(order!=null){
            order.updateOrderStatus(status);
            return status;
        }
        return null;
    }





}
