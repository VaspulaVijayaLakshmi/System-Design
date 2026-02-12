package models;

import java.util.List;

public class Cart {

    List<String> items;
    double amount;

        public Cart(List<String> items, double amount) {
            this.items = items;
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }

}
