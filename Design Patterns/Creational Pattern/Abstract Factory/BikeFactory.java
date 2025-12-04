package Creational.AbstractFactory;

import Creational.FactoryPattern.Bike;
import Creational.FactoryPattern.Vehicle;

public class BikeFactory implements VehicleAbstractFactory{

    @Override
    public Vehicle createVehicle(){
        return new Bike();
    }
}

