package LLD_without_Design_Pattern.ParkingLot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ParkingLot{

    List<Floor> floors;
    //map of license numbers - parking ticket
    Map<String, ParkingTicket> parkingTickets ;
    FeeStrategy feeStrategy;


    public ParkingLot(List<Floor> floors){
        this.floors = floors;
        this.parkingTickets = new HashMap<>();
        feeStrategy = new FeeStrategy();
    }

    public Map<String, ParkingTicket> getAllTickets(){
        return parkingTickets;
    }


    //find an open spot for vehicle
    public Spot findSpot(Vehicle vehicle){

        //for each floor
        //find spot

        for(Floor floor: floors){
            for(Spot spot: floor.getSpots()){
              if(spot.isAvailable() && spot.getSlotType() == vehicle.getVehicleType()) {
                  return spot;
              }
            }

        }

        return null;

    }

    public ParkingTicket generateTicket(Vehicle vehicle,Spot spot){
       return  new ParkingTicket(vehicle,spot);
    }

    public void ParkVehicle(Vehicle vehicle){

        Spot spot = findSpot(vehicle);
        if(spot==null){
            System.out.println("Spot not found");
            return ;
        }

        //found spot
        spot.setAvailable(false);

        //generate ticket
        ParkingTicket ticket = generateTicket(vehicle,spot);

        //update hashmap of parking tickets
        parkingTickets.put(vehicle.getLicensePlate(), ticket);

        System.out.println("Vehicle parked at spot: "+ spot.getSlotNumber());

    }

    public double unParkVehicle(Vehicle vehicle){

       ParkingTicket ticket = parkingTickets.get(vehicle.getLicensePlate());
       System.out.println("Unparking vehicle from spot: "+ ticket.getSpot().getSlotNumber());


       Spot spot = ticket.getSpot();

        //remove from active tickets
        parkingTickets.remove(vehicle.getLicensePlate());

        //make the spot availble
        spot.setAvailable(true);


        //charge based on timing
        return feeStrategy.calculateFee(vehicle.getVehicleType(),ticket.getEntryTime());

    }


}