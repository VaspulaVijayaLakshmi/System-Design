package models;

public class OrderItem {

    MenuItem menuItem;
    int quantity;

    public OrderItem(MenuItem menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    //getters and setters for the order item class

     public MenuItem getMenuItem() {
         return menuItem;
     }

     public void setMenuItem(MenuItem menuItem) {
         this.menuItem = menuItem;
     }

     public int getQuantity() {
         return quantity;
     }

     public void setQuantity(int quantity) {
         this.quantity = quantity;
     }
}
