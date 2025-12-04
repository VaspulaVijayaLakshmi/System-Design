package LLD_Interview_Problems.ParkingLot;


import LLD_Interview_Problems.ParkingLot.entities.Floor;
import LLD_Interview_Problems.ParkingLot.entities.ParkingTicket;
import LLD_Interview_Problems.ParkingLot.entities.Slot;
import LLD_Interview_Problems.ParkingLot.entities.Vehicle;
import LLD_Interview_Problems.ParkingLot.enums.VehicleType;
import LLD_Interview_Problems.ParkingLot.strategy.fare.FareStrategy;
import LLD_Interview_Problems.ParkingLot.strategy.payment.PaymentStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {

    private ParkingLot parkingLotInstance;
    private List<Floor> floors = new ArrayList<>();
    private FareStrategy fareStrategy;
    private PaymentStrategy paymentStrategy;
    private Map<String, ParkingTicket> activeTickets;

    public ParkingLot(PaymentStrategy paymentStrategy, FareStrategy fareStrategy) {
        this.paymentStrategy = paymentStrategy;
        this.fareStrategy = fareStrategy;
        activeTickets = new ConcurrentHashMap<>();
    }

    public ParkingLot getParkingLotInstance(PaymentStrategy paymentStrategy, FareStrategy fareStrategy) {

        if (parkingLotInstance == null) {
            this.parkingLotInstance = new ParkingLot(paymentStrategy, fareStrategy);
        }

        return parkingLotInstance;

    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void addFloor(Floor floor) {
        floors.add(floor);
    }

    public void removeFloor(Floor floor) {
        floors.remove(floor);
    }

    public Map<String, ParkingTicket> getActiveTickets() {
        return activeTickets;
    }

    //get a spot empty spot of VehicleTYpe
    //on any floor
    public Slot getAvaiableSpot(VehicleType vehicleType) {

        for (Floor floor : floors) {
            for (Slot parkingSpot : floor.getSlots()) {
                if (!parkingSpot.isOccupied() && parkingSpot.getSlotType().equals(vehicleType)) {
                    return parkingSpot;
                }
            }
        }
        return null;
    }



    public void park(Vehicle vehicle) {

        Slot availableSpot = getAvaiableSpot(vehicle.getVehicleType());

        if (availableSpot == null) {
            System.out.println("Spot not available");
        } else {
            availableSpot.setOccupied(true);
            ParkingTicket parkingTicket = new ParkingTicket(vehicle, availableSpot);
            activeTickets.put(vehicle.getLicenseNumber(), parkingTicket);
        }
    }


    public void unpark(Vehicle vehicle) {

        //remove from active tickets
        //calculate fare
        //pay fare
        //make spot available

        ParkingTicket parkingTIcket = activeTickets.get(vehicle.getLicenseNumber());
        activeTickets.remove(vehicle.getLicenseNumber());

        double fare = fareStrategy.calculateFare(parkingTIcket);

        paymentStrategy.pay(fare);

        Slot slot = parkingTIcket.getSlot();
        slot.setOccupied(false);

    }
}

