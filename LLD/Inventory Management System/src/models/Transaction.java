package models;

import java.time.LocalDate;

public class Transaction {

    String transactionId;
    LocalDate date;
    String productId;
    String wareHouseId;
    int quantity;


    public Transaction(String productId, String wareHouseId, int quantity) {
        this.transactionId = java.util.UUID.randomUUID().toString();
        this.date = LocalDate.now();
        this.productId = productId;
        this.wareHouseId = wareHouseId;
        this.quantity = quantity;
    }
}
