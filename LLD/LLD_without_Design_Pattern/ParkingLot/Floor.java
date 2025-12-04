package LLD_without_Design_Pattern.ParkingLot;

import java.util.List;

public class Floor{

    int floorNumber;
    List<Spot> spots;

    public Floor(int floorNumber, List<Spot> slots){
        this.floorNumber = floorNumber;
        this.spots = slots;
    }


    int getFloorNumber(){
        return floorNumber;
    }

    public List<Spot> getSpots(){
        return spots;
    }

}