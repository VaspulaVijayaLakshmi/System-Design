package LLD_without_Design_Pattern.ParkingLot;

import java.util.List;
import java.util.Map;

public class ParkingLotDemo {

    public static void main(String[] args){

        System.out.println("Parking Lot Demo");

        //create spots
        Spot spot1 = new Spot(1, SpotType.CAR);
        Spot spot2 = new Spot(2, SpotType.BIKE);
        Spot spot3 = new Spot(3, SpotType.CAR);

        List<Spot> spots = List.of(spot1, spot2, spot3);

        //create a floor
        Floor floor1 = new Floor(1,spots);


        //create vehicle
        Car car1 = new Car("1234");
        Bike bike1= new Bike("0000");

        //parking lot
        ParkingLot parkingLot = new ParkingLot(List.of(floor1));


        //park vehicle
        parkingLot.ParkVehicle(car1);

        //get all parking tickets
        Map<String,ParkingTicket> activeTickets = parkingLot.getAllTickets();

        for (Map.Entry<String, ParkingTicket> entry : activeTickets.entrySet()) {
            System.out.println("Active Tickets: ");
            System.out.println(entry.getKey() + " -> " + entry.getValue().getSpot().getSlotNumber());
        }


        //unpark vehicle
        double fee = parkingLot.unParkVehicle(car1);
        System.out.println("Parking fee for car1: "+ fee);


    }

}


//vehicle
//parking lot

//floor - slots

