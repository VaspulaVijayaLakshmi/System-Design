package startegy;

public class FreeDelivery implements DisCount{

    int minimumAmountForFreeDelivery;

    public FreeDelivery(int minimumAmountForFreeDelivery) {
        this.minimumAmountForFreeDelivery = minimumAmountForFreeDelivery;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        if (totalAmount >= minimumAmountForFreeDelivery) {
            return 0; // Free delivery
        }
        return totalAmount; // Assuming a flat delivery fee of 50 if the total amount is less than the minimum
    }
}
