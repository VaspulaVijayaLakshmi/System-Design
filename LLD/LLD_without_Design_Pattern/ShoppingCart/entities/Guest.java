package LLD_without_Design_Pattern.ShoppingCart.entities;

import java.util.ArrayList;
import java.util.List;

public class Guest {

    private  String guestId;
    private String name;
    private String email;
    private List<Order> orderHistory;

    public Guest(String guestId, String name, String email) {
        this.guestId = guestId;
        this.name = name;
        this.email = email;
        this.orderHistory = new ArrayList<>();
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void updateOrderHistory(Order order) {
      orderHistory.add(order);
    }


}
