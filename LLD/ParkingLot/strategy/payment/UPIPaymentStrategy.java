package LLD_Interview_Problems.ParkingLot.strategy.payment;

public class UPIPaymentStrategy implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + "With UPI");
    }
}
