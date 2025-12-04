package Behavioural.Strategy;

//public class PaymentProcessor {
//
//    public void payMethod(PaymentType paymentType){
//
//        if(paymentType == PaymentType.DEBIT_CARD){
//            System.out.println("Processing Debit Card Payment");
//        }
//        else if(paymentType == PaymentType.UPI){
//            System.out.println("Processing UPI Payment");
//        }
//        else if(paymentType == PaymentType.CREDIT_CARD){
//            System.out.println("Processing Credit Card Payment");
//        }
//        else{
//            System.out.println("Invalid Payment Type");
//        }
//
//
//        //if we add more payment types in future you will be required to modify this class
//    }
//
//}



public class PaymentProcessor {

    private PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    public void payMethod() {
        paymentStrategy.pay();
    }

    public void checkBalance() {
        paymentStrategy.checkBalance();
    }

}



