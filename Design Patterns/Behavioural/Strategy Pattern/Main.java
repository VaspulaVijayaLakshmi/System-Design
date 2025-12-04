package Behavioural.Strategy;

public class Main {

    public static void main(String[] args){

//        Without Strategy Pattern
//        PaymentType paymentType = PaymentType.DEBIT_CARD;
//        PaymentProcessor paymentProcessor = new PaymentProcessor();
//        paymentProcessor.payMethod(paymentType);


        //Strategy Pattern


        PaymentStrategy debitPaymentStrategy = new DebitCard("12345","John", "hdfc",1000);
        PaymentProcessor paymentProcessor1 = new PaymentProcessor(debitPaymentStrategy);
        paymentProcessor1.payMethod();


        PaymentStrategy creditPaymentStrategy = new CreditCard("98765","John", "hdfc","123",1000);
        PaymentProcessor paymentProcessor2 = new PaymentProcessor(creditPaymentStrategy);
        paymentProcessor2.payMethod();

    }
}
