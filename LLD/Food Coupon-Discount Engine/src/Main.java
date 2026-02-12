import models.Cart;
import models.Coupon;

import java.time.LocalDate;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        CouponService couponService = new CouponService();
        Coupon coupon = new Coupon("12345", LocalDate.now().minusDays(2),
                LocalDate.now().plusDays(6), 100, true);

        couponService.addCoupon(coupon);

        Cart cart = new Cart(List.of("item1", "item2"), 200);

        couponService.applyCoupon(cart,coupon.getCouponCode());


    }
}