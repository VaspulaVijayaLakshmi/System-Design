package LLD_Interview_Problems.ParkingLot.entities;

import LLD_without_Design_Pattern.ParkingLot.Spot;

import java.util.List;

public class Floor {

    int floorNumber;
    List<Slot> slots;

    public Floor(int floorNumber, List<Slot> slots){
        this.floorNumber = floorNumber;
        this.slots = slots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSpots(List<Slot> slots) {
        this.slots = slots;
    }

}