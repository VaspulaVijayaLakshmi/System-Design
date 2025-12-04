package LLD_Interview_Problems.InventoryManagement.observer;

import LLD_Interview_Problems.InventoryManagement.models.Product;

import java.util.List;

public class DashboardAlertSystem implements InventoryObserver{

    private List<String> adminUsers;
    int productThreshold = 2;

    @Override
    public void update(Product product){

        double stockPercentage = (product.getQuantity()/productThreshold)*100;

        if(stockPercentage <= 25){
            notifyAdmins(product, "CRITICAL");
        }
        else if(stockPercentage <= 50){
            notifyAdmins(product, "WARNING");
        }



    }


    private void notifyAdmins(Product product, String level){

        for(String adminUser: adminUsers){
            System.out.println("Alert Notification : Low Stock of item: "+product.getName()+" to admin user: "+adminUser+" with level: "+level);
        }
    }
}
