package models;


import java.util.UUID;

//represent the stock of a prodict
public class Inventory {

     String productId;
    public  int totalQuantity;
    String wareHouseId;
    public int reservedQuantity;

    public Inventory( String productId, int totalQuantity, String wareHouseId, int reservedQuantity) {
        this.productId = productId;
        this.totalQuantity = totalQuantity;
        this.wareHouseId = wareHouseId;
        this.reservedQuantity = reservedQuantity;
    }

        public String getProductId() {
            return productId;
        }

        public int getAvailableQuantity() {
            return totalQuantity-reservedQuantity;
        }

        public String getWareHouseId() {
            return wareHouseId;
        }

        public int getReservedQuantity() {
            return reservedQuantity;
        }

        public void addStock(int quantity){
            this.totalQuantity+=quantity;
        }



}
