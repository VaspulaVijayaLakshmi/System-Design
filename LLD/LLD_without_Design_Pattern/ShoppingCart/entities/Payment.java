package LLD_without_Design_Pattern.ShoppingCart.entities;

public class Payment {

    double totalAmount;
    PaymentMethod PaymentMethod;
    PaymentStatus paymentStatus;

    public Payment(double totalAmount,PaymentMethod paymentMethod) {
        this.totalAmount = totalAmount;
        this.PaymentMethod = paymentMethod;
        this.paymentStatus = PaymentStatus.INITIATED;

        System.out.println("Payment of amount "+totalAmount+" is initiated using "+paymentMethod);
    }


}
