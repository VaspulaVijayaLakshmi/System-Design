package Structural.Decorator;

public class Espresso implements Coffee {

    @Override
    public void getDescription() {
        System.out.println("Espresso Coffee");
    }

    @Override
    public void cost() {
        System.out.println("Cost: $2.50");
    }
}
