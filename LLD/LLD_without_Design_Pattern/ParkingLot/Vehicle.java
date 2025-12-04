package LLD_without_Design_Pattern.ParkingLot;

public class Vehicle{

    private String licensePlate;
    private SpotType vehicleType;
    private ParkingTicket parkingTicket;

    public Vehicle(String licensePlate, SpotType vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public SpotType getVehicleType() {
        return vehicleType;
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }


}