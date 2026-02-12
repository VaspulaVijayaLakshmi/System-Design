import models.Cart;
import models.Coupon;
import startegy.PercentageDiscountStrategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CouponService {

    Map<String, Coupon> coupons;
    CouponEngine couponEngine;

    public CouponService(){
        coupons = new ConcurrentHashMap<>();
        couponEngine = new CouponEngine(new PercentageDiscountStrategy(10,50));
    }

    public void addCoupon(Coupon coupon){
        coupons.put(coupon.getCouponCode(), coupon);
    }


    //we can have a cron job to remove expired coupons as well
    public void removeCoupon(String couponCode){
        coupons.remove(couponCode);
    }

    //apply coupon to cart
    //we can take user as well to check for user eligibility
    public double applyCoupon(Cart cart, String code){

        Coupon coupon = coupons.get(code);

        if (coupon == null) {
            throw new RuntimeException("Invalid coupon");
        }

        if (!coupon.isValid(cart)) {
            throw new RuntimeException("Coupon not applicable");
        }

        double discount = couponEngine.applyCoupon(cart);

        // update usage here
        return discount;


    }





}
