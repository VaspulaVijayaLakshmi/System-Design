package Structural.Adapter;

public class Main {

    public static void main(String[] args) {

        AC ac=new AC();
        CoffeMachine coffeMachine=new CoffeMachine();
        SmartLights smartLights=new SmartLights();

        SmartAdapter smartLightsAdapter= new SmartAdapterLights(smartLights);
        SmartAdapter CoffeAdapter= new CoffeSmartAdapter(coffeMachine);
        SmartAdapter acAdapter= new ACSmartAdapter(ac);

        smartLightsAdapter.turnOn();
        smartLightsAdapter.turnOff();

        CoffeAdapter.turnOn();
        CoffeAdapter.turnOff();

        acAdapter.turnOn();
        acAdapter.turnOff();

    }

}
