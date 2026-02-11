package models;

import java.util.UUID;

public class Rider {

    String riderId;
    Location location;

    public Rider( Location location) {
        this.riderId = UUID.randomUUID().toString();
        this.location = location;
    }

     public String getRiderId() {
        return riderId;
    }



}
