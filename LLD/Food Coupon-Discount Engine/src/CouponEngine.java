import models.Cart;
import startegy.DisCount;

public class CouponEngine {

    DisCount discountStrategy;

    public CouponEngine(DisCount discountStrategy){
        this.discountStrategy = discountStrategy;
    }


    public double applyCoupon(Cart cart){
        return discountStrategy.applyDiscount(cart.getAmount());
    }
}
