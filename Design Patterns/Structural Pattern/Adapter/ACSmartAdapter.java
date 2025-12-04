package Structural.Adapter;

public class ACSmartAdapter implements SmartAdapter {

    private AC ac;

    public ACSmartAdapter(AC ac) {
        this.ac = ac;
    }

   @Override
    public void turnOn() {
        ac.conectBluetooh();
        ac.turnOnAC();
    }

    @Override
    public void turnOff() {
        ac.turnOffAC();
        ac.offBluetooth();
    }
}
