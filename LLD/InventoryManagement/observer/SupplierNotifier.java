package LLD_Interview_Problems.InventoryManagement.observer;

import LLD_Interview_Problems.InventoryManagement.models.Product;

public class SupplierNotifier implements InventoryObserver{

    String supplierName;

    public SupplierNotifier(String supplierName){
        this.supplierName = supplierName;
    }

    @Override
    public void update(Product product) {
        System.out.println("Notifying supplier "+ supplierName+" about low stock of item: "+product.getName());
    }
}
