package models;

import enums.OrderStatus;

import java.util.List;
import java.util.UUID;

public class Order {

    String OrderId;
    String userId;
    String restaurantId;
    String deliveryAgentId;
    double price;
    List<OrderItem> orderItems;
    OrderStatus orderStatus;

    //builder Pattern -> to the build the order class

    public Order( String userId, String restaurantId,
                 List<OrderItem> orderItems) {
        OrderId = UUID.randomUUID().toString();
        this.userId = userId;
        this.restaurantId = restaurantId;
        deliveryAgentId = null;
        this.orderItems = orderItems;
        this.orderStatus = OrderStatus.PENDING;
    }

    //getters and setters for the order class

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(String restaurantId) {
        this.restaurantId = restaurantId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void updateOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
       this.price = price;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addItem(MenuItem item,int quantity ) {


        orderItems.add(new OrderItem(item,quantity));
    }


    //this should just assign the delivery agent, this shuld not hold the logic to find the delivery agents and all
    public void assignDeliveryAgent(String agentId) {

        if (deliveryAgentId != null) {
            throw new IllegalStateException("Agent already assigned");
        }

        this.deliveryAgentId = agentId;
        orderStatus = OrderStatus.READY;
    }


}
