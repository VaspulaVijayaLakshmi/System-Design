package LLD_without_Design_Pattern.ParkingLot;

public class Bike extends Vehicle{

    public Bike(String licensePlate) {
        super(licensePlate, SpotType.BIKE);
    }
}