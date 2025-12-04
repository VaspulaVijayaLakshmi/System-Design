package LLD_Interview_Problems.InventoryManagement.models;

import java.util.List;

public class WareHouse {

    String warehouseId;
    List<Product> products;

    public WareHouse(String warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

}
