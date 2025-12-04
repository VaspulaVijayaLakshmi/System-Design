package Structural.Adapter;


//connect via WI_FI
public class SmartLights {

    public void connectWiFi() {
        System.out.println("WiFi connected to Smart Lights");
    }

    public void disconnectWiFi() {
        System.out.println("WiFi connected to Smart Lights");
    }


    public void turnOnLights() {
        System.out.println("Smart Lights are turned ON");
    }

    public void turnOffLights() {
        System.out.println("Smart Lights are turned OFF");
    }
}
