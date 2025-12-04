package LLD_Interview_Problems.ParkingLot.entities;

import LLD_Interview_Problems.ParkingLot.enums.VehicleType;

public class Car extends Vehicle{

    public Car(String licenseNumber) {
        super(licenseNumber, VehicleType.CAR);
    }
}
