package Creational.FactoryPattern;

public class VehicleFactory {

    public Vehicle vehicle(VehicleType vehicleType) {
        if (vehicleType == VehicleType.BIKE) {
            return new Bike();
        } else if (vehicleType == VehicleType.CAR) {
            return  new Car();
        } else {
            System.out.println("Vehicle Not Supported");
            return null;
        }

    }
}
