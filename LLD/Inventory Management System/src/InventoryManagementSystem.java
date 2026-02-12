import models.Inventory;
import models.Product;
import models.WareHouse;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class InventoryManagementSystem {

    Map<String, WareHouse> wareHouses;
    Map<String, Product> products;

    //warehouse ID -> inventory
    Map<String, Inventory> inventories;

    public InventoryManagementSystem() {
        // Initialize the maps
        wareHouses = new ConcurrentHashMap<>();
        products = new ConcurrentHashMap<>();
        inventories = new ConcurrentHashMap<>();
    }

    public void addWareHouse(WareHouse wareHouse) {
        wareHouses.put(wareHouse.getWareHouseId(), wareHouse);
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void addInventory(Inventory inventory) {
        this.inventories.put(inventory.getWareHouseId(), inventory);
    }

    public int getAvailableStock(String wareHOuseId, String productId) {
        return inventories.get(wareHOuseId).getAvailableQuantity();
    }

    public void releaseStock(String wareHouseId, String productId, int quantity){

          Inventory inventory = inventories.get(wareHouseId);
           inventory.reservedQuantity =- quantity;
    }


    public void addStock(String wareHouseId, String productId, int quantity){

        WareHouse wareHouse = wareHouses.get(wareHouseId);
        Product product = products.get(productId);

        Inventory inventory = inventories.get(wareHouseId);
        inventory.totalQuantity += quantity;

    }

    public void deductStock(String wareHouseId, String productId, int quantity){

        Inventory inventory = inventories.get(wareHouseId);

        inventory.totalQuantity -= quantity;
        inventory.reservedQuantity =- quantity;

    }

    public void reserveStock(String wareHouseId, String productId, int quantity){

        Inventory inventory = inventories.get(wareHouseId);

        if(quantity <= inventory.getAvailableQuantity())
            inventory.reservedQuantity += quantity;


    }

}
