package models;

import java.util.UUID;

public class WareHouse {

    String wareHouseId;
    String location;

    public WareHouse(String location) {
        this.wareHouseId = UUID.randomUUID().toString();
        this.location = location;
    }

    public String getWareHouseId() {
        return wareHouseId;
    }
}
