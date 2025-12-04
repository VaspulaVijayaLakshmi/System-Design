package LLD_Interview_Problems.InventoryManagement;

import LLD_Interview_Problems.InventoryManagement.enums.Category;
import LLD_Interview_Problems.InventoryManagement.factory.ProductFactory;
import LLD_Interview_Problems.InventoryManagement.models.Product;
import LLD_Interview_Problems.InventoryManagement.models.WareHouse;
import LLD_Interview_Problems.InventoryManagement.strategy.SearchInventoryByCategory;

import java.util.List;

import static LLD_Interview_Problems.InventoryManagement.enums.Category.*;

public class InventoryManagementDemo {

    public static void main(String[] args) {
        System.out.println("Inventory Management System");

        // Create and add warehouses
        List<WareHouse> warehouses = List.of(
                new WareHouse("WH1"),
                new WareHouse("WH2")
        );


        InventoryManager inventoryManager = InventoryManager.getInventoryManagerInstance(warehouses);


        inventoryManager.setSearchInventoryStrategy(new SearchInventoryByCategory("CLOTHING"));


        // Create products using ProductFactory
        ProductFactory productFactory = new ProductFactory();

        Product laptop = productFactory.createProduct(
                 "SKU123", "Laptop", 1000.0, 50, ELECTRONICS);
        Product tShirt = productFactory.createProduct(
                 "SKU456", "T-Shirt", 20.0, 200, CLOTHING);
        Product apple = productFactory.createProduct(
                 "SKU789", "Apple", 1.0, 100, GROCERY);


        // Add products to warehouses
//        warehouse1.addProduct(laptop);
//        warehouse1.addProduct(tShirt);
//        warehouse1.addProduct(apple);



    }
}
