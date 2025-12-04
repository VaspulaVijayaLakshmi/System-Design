package LLD_Interview_Problems.ParkingLot;

import Creational.FactoryPattern.VehicleType;
import LLD_Interview_Problems.ParkingLot.entities.*;
import LLD_Interview_Problems.ParkingLot.strategy.fare.FareStrategy;
import LLD_Interview_Problems.ParkingLot.strategy.fare.HourlyFareStrategy;
import LLD_Interview_Problems.ParkingLot.strategy.payment.PaymentStrategy;
import LLD_Interview_Problems.ParkingLot.strategy.payment.UPIPaymentStrategy;
import java.util.List;
import java.util.Map;

public class ParkingLotDemo {

    public static void main(String[] args) {

        System.out.println("Parking Lot Demo");

        //create spots
        Slot spot1 = new Slot(1, VehicleType.CAR);
        Slot spot2 = new Slot(2, VehicleType.BIKE);
        Slot spot3 = new Slot(3, VehicleType.CAR);

        List<Slot> spots = List.of(spot1, spot2, spot3);

        //create a floor
        Floor floor1 = new Floor(1,spots);


        //create vehicle
        Car car1 = new Car("1234");

        PaymentStrategy paymentStrategy = new UPIPaymentStrategy();
        FareStrategy fareStrategy= new HourlyFareStrategy();

        //parking lot
       ParkingLot parkingLot = new ParkingLot(paymentStrategy,fareStrategy);

        parkingLot.addFloor(floor1);

        //park vehicle
        parkingLot.park(car1);

        //get all parking tickets
        Map<String, ParkingTicket> activeTickets = parkingLot.getActiveTickets();

        for (Map.Entry<String, ParkingTicket> entry : activeTickets.entrySet()) {
            System.out.println("Active Tickets: ");
            System.out.println(entry.getKey() + " -> " + entry.getValue().getSlot().getSlotId());
        }

        //unpark vehicle
        parkingLot.unpark(car1);

    }

}

