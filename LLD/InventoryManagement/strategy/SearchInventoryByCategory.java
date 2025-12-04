package LLD_Interview_Problems.InventoryManagement.strategy;

import LLD_Interview_Problems.InventoryManagement.models.Product;
import LLD_Interview_Problems.InventoryManagement.models.WareHouse;

import java.util.List;

public class SearchInventoryByCategory implements SearchInventoryStrategy {

    private String category;

    public SearchInventoryByCategory(String category) {
        this.category = category;
    }

    @Override
    public List<Product> filterProduct(List<Product> products) {

        return products.stream().filter(
                item -> item.getCategory().equals(category)
        ).toList();

    }

}
