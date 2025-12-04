package Creational.FactoryPattern;

public class Bike implements Vehicle{

    public Bike(){
        System.out.println("Bike Object Created");
    }

    @Override
    public void start(){
        System.out.println("Bike Started");
    }
}
