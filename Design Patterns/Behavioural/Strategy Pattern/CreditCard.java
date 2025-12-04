package Behavioural.Strategy;

public class CreditCard implements PaymentStrategy {

    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;
    private String cvv;
    private double balance;

    public CreditCard(String cardNumber, String cardHolderName, String expiryDate, String cvv, double balance) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
        this.balance = balance;
    }

    @Override
    public void pay() {
        System.out.println("Paying with Credit Card: " + cardNumber);
    }

    @Override
    public void checkBalance() {
        System.out.println("Credit Card Balance: " + balance);
    }


}
