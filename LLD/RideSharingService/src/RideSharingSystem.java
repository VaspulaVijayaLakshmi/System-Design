import enums.DriverStatus;
import enums.RideStatus;
import models.Driver;
import models.Location;
import models.Ride;
import models.Rider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RideSharingSystem {

    private static RideSharingSystem instance;

    Map<String, Driver> drivers;
    Map<String, Rider> riders;
    Map<String, Ride> rides;

    private RideSharingSystem(){
        drivers = new ConcurrentHashMap<>();
        riders = new ConcurrentHashMap<>();
        rides = new ConcurrentHashMap<>();
    }

    public static synchronized RideSharingSystem getInstance(){

        if(instance==null){
            instance = new RideSharingSystem();
        }
        return instance;
    }


    //add drivers
    public void addDriver(Driver driver){
        drivers.put(driver.getDriverId(), driver);
    }

    //add users
    public void addRider(Rider rider){
        riders.put(rider.getRiderId(), rider);
    }

    //driver Location Update
    public void updateDriverLocation(String driverId, Location location){

        Driver driver = drivers.get(driverId);
        if(driver!=null){
            driver.updateLocation(location);
    }

    }


    //book rides
    public Ride bookRide(String riderId, Location from, Location to){

        Rider rider = riders.get(riderId);
        Ride ride = new Ride(riderId, from, to);

        //Request Ride to nearby drivers - should we do First avaibale driver or nearest driver or all nearby drivers

        notifyDrivers(ride);
        rides.put(ride.getRideId(), ride);
        return ride;

    }


    void acceptRide(String rideId, String driverId) {

        //update ride
        Ride ride = rides.get(rideId);
        Driver driver = drivers.get(driverId);

        if (driver != null && ride != null) {

            ride.setDriverId(driver.getDriverId());
            ride.setRideStatus(RideStatus.ACCEPTED);

            driver.acceptRide();

        }

    }

    public void startRide(String tripId) {
        Ride ride  = rides.get(tripId);
        if (ride.getStatus() == RideStatus.ACCEPTED) {
            ride.setRideStatus(RideStatus.IN_PROGRESS);

        }
    }



    public void finishRide(String rideId){

        Ride ride = rides.get(rideId);
        if(ride.getStatus() == RideStatus.IN_PROGRESS){
            ride.setRideStatus(RideStatus.COMPLETED);
            Driver driver = drivers.get(ride.getDriverId());
            driver.finishRide();
        }

        double fare = calculateFare(ride);
        ride.setPrice(fare);

        System.out.println("Ride completed with fare: "+fare);
    }



    //notify the drivers
    void notifyDrivers(Ride ride){

        boolean foundDriver=false;

        for(Driver driver: drivers.values()){

            if(driver.getDriverStatus() == DriverStatus.AVAILABLE){
                //if his distance is withhin 5km radius then notify

                Location riderlocation = ride.getSource();
                Location driverLocation = driver.getLocation();

                if(riderlocation.distanceTo(driverLocation) <= 10000.0){
                    //notify driver
                    foundDriver=true;
                    System.out.println("Notify Driver about this Ride");
                }
            }

        }

        if(!foundDriver) throw new RuntimeException("Driver Not Found");
    }



    //calculate fare
    public double calculateFare(Ride ride){

        double baseFare = 20.0;
        double perKmFare = 1.5;

        Location source = ride.getSource();
        Location destination = ride.getDestination();

        double distance = source.distanceTo(destination);

        double fare = baseFare+ (perKmFare*distance);

        return fare;

    }





}
