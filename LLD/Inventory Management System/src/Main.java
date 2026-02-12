import models.Inventory;
import models.Product;
import models.WareHouse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        InventoryManagementSystem inventoryManagementSystem = new InventoryManagementSystem();

        WareHouse wareHouse = new WareHouse("New York");
        String wareHouseId = wareHouse.getWareHouseId();

        Product product = new Product("Laptop", 999.99);
        String productId = product.getProductId();

        Inventory inventory = new Inventory(productId, 10, wareHouseId, 0);

        inventoryManagementSystem.addWareHouse(wareHouse);
        inventoryManagementSystem.addProduct(product);
        inventoryManagementSystem.addInventory(inventory);


        System.out.println("Available Stock: " + inventoryManagementSystem.getAvailableStock(wareHouseId, productId));

        inventoryManagementSystem.addStock(wareHouseId, productId, 5);
        System.out.println("Available Stock after adding stock: " + inventoryManagementSystem.getAvailableStock(wareHouseId, productId));

        inventoryManagementSystem.reserveStock(wareHouseId, productId, 5);
        System.out.println("Available Stock after reserving stock: " + inventoryManagementSystem.getAvailableStock(wareHouseId, productId));

        inventoryManagementSystem.deductStock(wareHouseId, productId, 5);
        System.out.println("Available Stock after deducting stock: " + inventoryManagementSystem.getAvailableStock(wareHouseId, productId));


    }
}