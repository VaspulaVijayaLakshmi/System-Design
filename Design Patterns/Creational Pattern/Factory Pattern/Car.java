package Creational.FactoryPattern;

public class Car implements Vehicle{

    public Car(){
        System.out.println("Car object Created");
    }

    @Override
    public void start(){
        System.out.println("Car STarted");
    }
}
