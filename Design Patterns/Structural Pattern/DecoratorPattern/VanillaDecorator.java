package Structural.Decorator;

public class VanillaDecorator extends CoffeDecorator {

    public VanillaDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println(" + Vanilla");
    }

    @Override
    public void cost() {
        super.cost();
        System.out.println("With Vannilla + 10");
    }
}
