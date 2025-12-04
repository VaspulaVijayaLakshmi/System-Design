package Structural.Decorator;

public class CoffeShop {

    public static void main(String[] args){

        Coffee basicCoffee = new BasicCoffee();
        Coffee cappucinoCoffee = new Cappucino();
        Coffee espressoCoffee = new Espresso();

        CoffeDecorator coffeDecorator = new MilkDecorator(cappucinoCoffee);
        coffeDecorator.getDescription();
        coffeDecorator.cost();

    }
}
