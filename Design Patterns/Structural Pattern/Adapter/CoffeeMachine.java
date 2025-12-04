package Structural.Adapter;


//CONECT VIA //soke ZIGBEE
public class CoffeMachine {

    public void connectZigbee() {
        System.out.println("Zigbee connected to Coffee Machine");
    }

    public void disconnectZigbee() {
        System.out.println("Zigbee disconnected from Coffee Machine");
    }


    public void turnOnCoffeeMachine() {
        System.out.println("Coffee Machine is turned ON");
    }

    public void turnOffCoffeeMachine() {
        System.out.println("Coffee Machine is turned OFF");
    }
}
