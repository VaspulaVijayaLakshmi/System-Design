package LLD_without_Design_Pattern.ParkingLot;

public class Car extends Vehicle{

    public Car(String licensePlate) {
        super(licensePlate, SpotType.CAR);
    }
}