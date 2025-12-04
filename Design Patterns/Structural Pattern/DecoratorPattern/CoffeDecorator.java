package Structural.Decorator;

public abstract class CoffeDecorator {

    private Coffee coffee;

    public CoffeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public void getDescription() {
        coffee.getDescription();
    }

    public void cost() {
         coffee.cost();
    }


}
