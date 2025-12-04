package Structural.Decorator;

public class Cappucino implements Coffee {


    @Override
    public void getDescription() {
        System.out.println("Cappucino Coffee");
    }

    public void cost() {
        System.out.println("Extra Cost: $3.50");
    }

}
