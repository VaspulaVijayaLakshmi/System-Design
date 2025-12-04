package LLD_Interview_Problems.ParkingLot.strategy.fare;

import LLD_Interview_Problems.ParkingLot.entities.ParkingTicket;

public interface FareStrategy {

    public double calculateFare(ParkingTicket ticket);
}
