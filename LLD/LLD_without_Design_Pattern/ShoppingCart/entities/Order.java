package LLD_without_Design_Pattern.ShoppingCart.entities;

import LLD_without_Design_Pattern.ShoppingCart.models.OrderStatus;

import java.util.Date;
import java.util.UUID;

public class Order {

    private String orderId;
    private OrderStatus orderStatus;
    private long orderDate;
    private double totalAmount;
    private Payment payment;
//    private String deliveryDate;
    //private Shipping shipping;


    public Order(double  totalAmount) {
        this.orderId = UUID.randomUUID().toString();
        orderStatus = OrderStatus.PENDING;
        this.orderDate = new Date().getDate();
        this.totalAmount = totalAmount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void updateOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

}
