package models;

public class Item {

    int itemName;
    double price;

    public Item(int itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

        public double getPrice() {
            return price;
        }

}
