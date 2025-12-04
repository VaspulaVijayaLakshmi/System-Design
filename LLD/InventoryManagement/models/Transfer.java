package LLD_Interview_Problems.InventoryManagement.models;

import java.util.List;
import java.util.Map;

public class Transfer {

    private String fromWarehouseId;
    private String toWarehouseId;
    private List<Product> products;

    public Transfer(List<Product> products, String fromWarehouseId, String toWarehouseId){
        this.products = products;
        this.fromWarehouseId = fromWarehouseId;
        this.toWarehouseId = toWarehouseId;
    }

    public String getFromWarehouseId() {
        return fromWarehouseId;
    }

    public String getToWarehouseId() {
        return toWarehouseId;
    }

    public List<Product> getProducts() {
        return products;
    }

}
