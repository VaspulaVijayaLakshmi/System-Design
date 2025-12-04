package LLD_Interview_Problems.ParkingLot.strategy.fare;

import LLD_Interview_Problems.ParkingLot.entities.ParkingTicket;
import LLD_Interview_Problems.ParkingLot.enums.VehicleType;

import java.util.Map;

public class HourlyFareStrategy implements FareStrategy {

    Map<VehicleType, Double> farePerHour =  Map.of(
        VehicleType.CAR, 10.0,
        VehicleType.BIKE, 5.0,
        VehicleType.TRUCK, 15.0
    );

    @Override
    public double calculateFare(ParkingTicket ticket) {

        long entryDuration = ticket.getEntryTime();
        long exitDuration = System.currentTimeMillis();

        long duration = exitDuration - entryDuration;
        double hours = duration/(1000*60*60);

        double doubleFare = farePerHour.get(ticket.getVehicle().getVehicleType())*hours;

        System.out.println("Fare for ticket id "+ticket.getTicketId()+" is: "+doubleFare);
        return doubleFare;

    }


}
