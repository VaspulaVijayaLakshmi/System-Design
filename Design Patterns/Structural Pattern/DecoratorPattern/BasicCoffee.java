package Structural.Decorator;

public class BasicCoffee implements Coffee {

    @Override
    public void getDescription() {
        System.out.println("Basic Coffee");
    }

    public void cost() {
        System.out.println("Cost: $2.00");
    }
}
