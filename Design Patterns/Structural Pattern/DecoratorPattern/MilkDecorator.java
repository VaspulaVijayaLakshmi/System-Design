package Structural.Decorator;

public class MilkDecorator extends CoffeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public void getDescription() {
        super.getDescription();
        System.out.println(" with Milk");
    }

    @Override
    public void cost(){
//        int cost = super.cost()+2.0;
         super.cost();
         System.out.println("with Milk : " + 2.0);
    }




}
