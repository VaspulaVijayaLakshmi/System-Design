package LLD_Interview_Problems.ParkingLot.entities;

import LLD_Interview_Problems.ParkingLot.enums.VehicleType;

public class Vehicle {

    String licenseNumber;
    VehicleType vehicleType;

    public Vehicle(String licenseNumber, VehicleType vehicleType){
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

}
