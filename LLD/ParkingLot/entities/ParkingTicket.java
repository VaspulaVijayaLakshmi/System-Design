package LLD_Interview_Problems.ParkingLot.entities;


import java.util.UUID;

public class ParkingTicket {

    private String ticketId;
    private long entryTime;
    Vehicle vehicle;
    Slot slot;

    public ParkingTicket(Vehicle vehicle,Slot slot) {
        this.ticketId = UUID.randomUUID().toString();;
        this.entryTime = System.currentTimeMillis();
        this.vehicle = vehicle;
        this.slot=slot;
    }

    public String getTicketId() {
        return ticketId;
    }


    public long getEntryTime() {
        return entryTime;
    }


    public Vehicle getVehicle() {
        return vehicle;
    }

    public Slot getSlot() {
        return slot;
    }



}
