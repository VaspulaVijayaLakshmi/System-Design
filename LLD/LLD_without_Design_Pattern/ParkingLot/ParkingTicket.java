package LLD_without_Design_Pattern.ParkingLot;

import java.util.Date;
import java.util.UUID;

public class ParkingTicket{

    String ticketId;
    Vehicle vehicle;
    Spot spot;
    long entryTime;


    //so we generate per hour rate - prices
    public ParkingTicket(Vehicle vehicle,Spot spot){
        this.ticketId = UUID.randomUUID().toString();
        this.vehicle = vehicle;
        this.entryTime = new Date().getTime();
        this.spot= spot;
    }

    public String getTicketId(){
        return ticketId;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot=spot;
    }
}