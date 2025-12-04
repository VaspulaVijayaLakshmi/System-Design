package Structural.Adapter;

public class SmartAdapterLights implements SmartAdapter{

    private SmartLights smartLights;

    public SmartAdapterLights(SmartLights smartLights) {
        this.smartLights = new SmartLights();
    }

    @Override
    public void turnOn() {
        smartLights.connectWiFi();
        smartLights.turnOnLights();
    }

    @Override
    public void turnOff() {
        smartLights.turnOffLights();
        smartLights.disconnectWiFi();
    }
}
