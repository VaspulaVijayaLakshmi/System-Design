package models;

import java.util.List;
import java.util.UUID;

public class Restaurant {

    String restId;
    String name;
    String location;
    List<MenuItem> menuitems;
    public Restaurant(String name, String location, List<MenuItem> menuitems) {
        this.restId = UUID.randomUUID().toString();
        this.name = name;
        this.location = location;
        this.menuitems = menuitems;
    }

     //getters and setters for the restaurant class

     public String getRestId() {
         return restId;
     }

     public void setRestId(String restId) {
         this.restId = restId;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getLocation() {
         return location;
     }

}
