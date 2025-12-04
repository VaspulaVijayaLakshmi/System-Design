package LLD_Interview_Problems.InventoryManagement.factory;

import LLD_Interview_Problems.InventoryManagement.enums.Category;
import LLD_Interview_Problems.InventoryManagement.exceptions.IllegalCategoryDefinition;
import LLD_Interview_Problems.InventoryManagement.models.ClothingProduct;
import LLD_Interview_Problems.InventoryManagement.models.ElectronicProduct;
import LLD_Interview_Problems.InventoryManagement.models.GroceryProduct;
import LLD_Interview_Problems.InventoryManagement.models.Product;

public class ProductFactory {

    public Product createProduct(String sku, String name, double price, int quantity, Category category) {

        try {
            switch (category) {

                case ELECTRONICS:
                    return new ElectronicProduct(sku, name,price,quantity);

                case CLOTHING:
                    return new ClothingProduct(sku, name,price,quantity);

                case GROCERY:
                    return new GroceryProduct(sku, name,price,quantity);

                default:
                    throw new IllegalCategoryDefinition("Invalid category");
            }
        }
        catch(Exception e) {
            throw new IllegalCategoryDefinition("Category Doesn't exist in our inventory");
        }

    }
}