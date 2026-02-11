package payment;

public class CreditCardPayment implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println("Credit Card Payment");
    }

}
