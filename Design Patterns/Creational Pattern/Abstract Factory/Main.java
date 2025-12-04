package Creational.AbstractFactory;

import Creational.FactoryPattern.Vehicle;

public class Main {
        public static void main(String[] args){

           VehicleAbstractFactory carFactory = new CarFactory();
           Vehicle vehicle = carFactory.createVehicle();
              vehicle.start();


        }

}
