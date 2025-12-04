package LLD_Interview_Problems.InventoryManagement.strategy;

import LLD_Interview_Problems.InventoryManagement.models.Product;

import java.util.List;

public class FilterInventoryByPrice {

    double minPrice;
    double maxPrice;


    public FilterInventoryByPrice(double minPrice, double maxPrice) {
            this.minPrice = minPrice;
            this.maxPrice = maxPrice;
    }

    public List<Product> filter(List<Product> products) {
            return products.stream()
                    .filter(p -> p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
                    .toList();
        }
    }

