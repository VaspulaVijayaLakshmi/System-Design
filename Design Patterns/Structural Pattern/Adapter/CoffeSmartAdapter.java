package Structural.Adapter;

public class CoffeSmartAdapter implements SmartAdapter{

    private CoffeMachine coffeMachine;

    public CoffeSmartAdapter(CoffeMachine coffeMachine) {
        this.coffeMachine = coffeMachine;
    }

    @Override
    public void turnOn() {
        coffeMachine.connectZigbee();
        coffeMachine.turnOnCoffeeMachine();
    }

    @Override
    public void turnOff() {
        coffeMachine.turnOffCoffeeMachine();
        coffeMachine.disconnectZigbee();
    }



}
