package LLD_Interview_Problems.ParkingLot.strategy.fare;

import LLD_Interview_Problems.ParkingLot.entities.ParkingTicket;

import java.util.Date;

public class FixedRateStrategy implements FareStrategy {

    private double fixedRate = 20.0;

    @Override
    public double calculateFare(ParkingTicket ticket) {

        long entryTime = ticket.getEntryTime();
        long exitTime = new Date().getTime();

        long duration = exitTime - entryTime;
        double hours = duration/(1000*60*60);

        double fare = fixedRate*hours;

        System.out.println("Total fare for ticket id "+ticket.getTicketId()+" is: "+fare);

        return fare;

    }
}
