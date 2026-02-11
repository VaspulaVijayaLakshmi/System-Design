package models;

import models.enums.SeatStatus;
import models.enums.SeatType;

import java.util.UUID;

public class Seat {

     String seatId;
     SeatType seatType;
     SeatStatus seatStatus;
     double price;

    public Seat( SeatType seatType, double price) {
        this.seatId = UUID.randomUUID().toString();
        this.seatType=seatType;
        seatStatus=SeatStatus.AVAILABLE;
        this.price=price;

    }

    public String getSeatId() {
        return seatId;
    }

    public SeatType getSeatType() {
        return seatType;
    }


    public synchronized boolean isAvailable() {
        return seatStatus == SeatStatus.AVAILABLE;
    }

    public synchronized boolean occupy() {
        if(seatStatus == SeatStatus.AVAILABLE) {
           seatStatus=SeatStatus.RESERVED;
            return true;
        }
        return false;
    }

    public double getPrice() {
        return price;
    }



}
