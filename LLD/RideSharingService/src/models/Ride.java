package models;

import enums.RideStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class Ride {

    String rideId;
    String driverId;
    String riderId;
//    String source;
//    String destination;
    Location source;
    Location destination;
    RideStatus status;
    LocalDateTime BookedAt;
    double price;


//    public  Ride(String riderId, String source, String destination){
//
//        rideId = UUID.randomUUID().toString();
//        this.riderId = riderId;
//        this.source = source;
//        this.destination = destination;
//        this.status = RideStatus.REQUESTED;
//        this.BookedAt = LocalDateTime.now();
//
//    }


    public  Ride(String riderId, Location source, Location destination){

        rideId = UUID.randomUUID().toString();
        this.riderId = riderId;
        this.source = source;
        this.destination = destination;
        this.status = RideStatus.REQUESTED;
        this.BookedAt = LocalDateTime.now();

    }

    public String getRideId() {
        return rideId;
    }

    public String getDriverId() {
        return driverId;
    }

    public String getRiderId() {
        return riderId;
    }

//    public String getSource() {
//        return source;
//    }
//
//    public String getDestination() {
//        return destination;
//    }

    public void setPrice(double price){
        this.price= price;
    }

    public Location getSource() {
        return source;
    }

    public Location getDestination() {
        return destination;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public void setRideStatus(RideStatus status) {
        this.status = status;
    }
}
