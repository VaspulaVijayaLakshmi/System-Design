package Creational.AbstractFactory;


import Creational.FactoryPattern.Car;
import Creational.FactoryPattern.Vehicle;

public class CarFactory implements VehicleAbstractFactory{

    @Override
    public Vehicle createVehicle(){
        return new Car();
    }
}
