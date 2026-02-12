package startegy;

public class PercentageDiscountStrategy implements DisCount {

    private double percentage;
    private double maxCap;

    public PercentageDiscountStrategy(double percentage, double maxCap) {
        this.percentage = percentage;
        this.maxCap = maxCap;
    }

    @Override
    public double applyDiscount(double totalAmount) {

        double discount = totalAmount * (percentage / 100);
        return Math.min(discount, maxCap);
    }


}
