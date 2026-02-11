package models;

import enums.DriverStatus;

import java.util.UUID;

public class Driver {

    String driverId;
    Location location;
    DriverStatus driverStatus;

    public Driver( Location location) {
        this.driverId = UUID.randomUUID().toString();
        this.location = location;
        this.driverStatus = DriverStatus.AVAILABLE;
    }

     public String getDriverId() {
        return driverId;
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void acceptRide(){
        this.driverStatus = DriverStatus.BUSY;
    }

    public void finishRide(){
        this.driverStatus = DriverStatus.AVAILABLE;
    }

    public void updateLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }



}
