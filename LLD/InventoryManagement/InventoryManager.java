package LLD_Interview_Problems.InventoryManagement;

import LLD_Interview_Problems.InventoryManagement.models.Product;
import LLD_Interview_Problems.InventoryManagement.models.Transfer;
import LLD_Interview_Problems.InventoryManagement.models.WareHouse;
import LLD_Interview_Problems.InventoryManagement.observer.InventoryObserver;
import LLD_Interview_Problems.InventoryManagement.strategy.SearchInventoryStrategy;

import java.util.List;

public class InventoryManager {

    private static  InventoryManager inventoryManagerInstance=null;
    List<WareHouse> wareHouses;
    SearchInventoryStrategy searchInventoryStrategy;
    private final int productLevelThreshold=2;
    List<InventoryObserver> observers;

    private  InventoryManager( List<WareHouse> wareHouses) {
        this.wareHouses = wareHouses;
    }

    public static InventoryManager getInventoryManagerInstance( List<WareHouse> wareHouses) {
        if(inventoryManagerInstance == null){
            inventoryManagerInstance = new InventoryManager( wareHouses);
        }
        return inventoryManagerInstance;
    }

    public void addWarehouse(WareHouse wareHouse){
        wareHouses.add(wareHouse);
    }

    public void setSearchInventoryStrategy(SearchInventoryStrategy searchInventoryStrategy) {
        this.searchInventoryStrategy = searchInventoryStrategy;
    }

    //add product to a ware house
    public void addProduct(String wareHouseId, Product product){
        for(WareHouse warehouse: wareHouses){
            if(warehouse.getWarehouseId().equals(wareHouseId)){
                warehouse.addProduct(product);
            }
        }
    }

    //remove products to a warehouse
    public void removeProduct(String wareHouseId, Product productId){
        for(WareHouse warehouse: wareHouses){
            if(warehouse.getWarehouseId().equals(wareHouseId)){
                warehouse.removeProduct(productId);
            }
        }
    }

    //transfer products between warehouses
    public void transferProduct(Transfer transfer){

       String fromWareHouseId = transfer.getFromWarehouseId();
       String toWareHouseId = transfer.getToWarehouseId();

       List<Product> productsToTransfer = transfer.getProducts();

       for(WareHouse wareHouse: wareHouses){

           //from this warehuse, pick items
           if(wareHouse.getWarehouseId().equals(fromWareHouseId)){

                for(Product product: productsToTransfer){
                     wareHouse.removeProduct(product);
                }
           }

           else if(wareHouse.getWarehouseId().equals(toWareHouseId)){

                for(Product product: productsToTransfer){
                      wareHouse.addProduct(product);
                }
           }
       }

    }


    //SearchProducts in inventory
    public List<Product> getProducts(WareHouse wareHouse){
        return wareHouse.getProducts();
    }


    //check stock Levels of an inventory
    //check overall invetory
    public void checkStockLevelOfProduct(Product product){
        int quantity = product.getQuantity();

        if(quantity < productLevelThreshold){
            notifyObservers(product);
        }

    }


    void addObserver(InventoryObserver observer){
        observers.add(observer);
    }

    void removeObserver(InventoryObserver observer){
        observers.remove(observer);
    }

    void notifyObservers(Product product){
        for(InventoryObserver observer: observers){

        }
    }



}
