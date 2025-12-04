package Structural.Adapter;


//connects via bluetooh
public class AC {

public void conectBluetooh() {
    System.out.println("Bluetooth connected to AC");
}


public void turnOnAC() {
    System.out.println("AC is turned ON");
}

    public void turnOffAC() {
        System.out.println("AC is turned OFF");
    }


    public void offBluetooth() {
        System.out.println("Bluetooth disconnected from AC");
    }


}
