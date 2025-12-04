package Behavioural.Strategy;

public class DebitCard implements PaymentStrategy {

    private String cardNumber;
    private String cardHolderName;
    private String bankName;
    private double balance;

    public DebitCard(String cardNumber, String cardHolderName, String bankName, double balance) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.bankName = bankName;
        this.balance = balance;
    }

    @Override
    public void pay() {
        System.out.println("Paying with Debit Card: " + cardNumber);
    }

    @Override
    public void checkBalance() {
        System.out.println("Checking balance for Debit Card: " + cardNumber);
        System.out.println("Available balance: " + balance);
    }

}
