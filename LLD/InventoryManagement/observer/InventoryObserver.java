package LLD_Interview_Problems.InventoryManagement.observer;

import LLD_Interview_Problems.InventoryManagement.models.Product;

public interface InventoryObserver {

  public void update(Product product);

}
