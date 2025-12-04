package LLD_Interview_Problems.ParkingLot.strategy.payment;

public class CreditCardPayementStrategy implements PaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Paid "+amount+" using Credit Card");
    }
}
