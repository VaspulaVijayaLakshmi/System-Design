package LLD_without_Design_Pattern.ParkingLot;

public class Spot {

    private int spotNumber;
    private SpotType spotType;
    private boolean isAvailable;


    public Spot(int slotNumber, SpotType slotType) {
        this.spotNumber = slotNumber;
        this.spotType = slotType;
        this.isAvailable = true;
    }

    public int getSlotNumber() {
        return spotNumber;
    }

    public SpotType getSlotType() {
        return spotType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

}


//Slot type
//slot number

