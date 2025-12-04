package LLD_Interview_Problems.InventoryManagement.strategy;

import LLD_Interview_Problems.InventoryManagement.models.Product;
import java.util.List;

public interface SearchInventoryStrategy {

    public List<Product> filterProduct(List<Product> products);
}
