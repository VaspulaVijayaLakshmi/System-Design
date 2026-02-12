package startegy;

public class FixedDiscountStrategy implements  DisCount{

    public static int FIXED_DISCOUNT = 100;

    @Override
    public double applyDiscount(double amount) {
        return amount-FIXED_DISCOUNT;
    }


}
