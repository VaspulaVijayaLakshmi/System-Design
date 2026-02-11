import models.Driver;
import models.Location;
import models.Ride;
import models.Rider;

public class RideSharingSystemDemo {

    public static void main(String[] args){

        RideSharingSystem rideSharingSystem = RideSharingSystem.getInstance();

         Rider rider = new Rider(new Location(12, 77));

         rideSharingSystem.addRider(rider);

         Driver driver = new Driver(new Location(15, 34));
            rideSharingSystem.addDriver(driver);

         Ride ride = rideSharingSystem.bookRide(rider.getRiderId(), new Location(12, 77), new Location(13, 45));


         //driver accepts the ride
            rideSharingSystem.acceptRide(driver.getDriverId(), ride.getRideId());

         //finish the drive
            rideSharingSystem.finishRide(ride.getRideId());

          //System.out.println("Ride completed successfully");



    }
}
