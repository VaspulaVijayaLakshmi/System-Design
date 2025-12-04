package LLD_Interview_Problems.ParkingLot.entities;

import Creational.FactoryPattern.VehicleType;

public class Slot {

    int slotId;
    VehicleType slotType;
    boolean isOccupied;

    public Slot(int slotId, VehicleType slotType) {
        this.slotId = slotId;
        this.slotType = slotType;
        this.isOccupied = false;
    }

    public int getSlotId() {
        return slotId;
    }

    public VehicleType getSlotType() {
        return slotType;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public void setSlotType(VehicleType slotType) {
        this.slotType = slotType;
    }


    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean isOccupied) {
        this.isOccupied = isOccupied;
    }


}