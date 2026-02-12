package models;

import java.time.LocalDate;

public class Coupon {

    String couponCode;
    LocalDate startDate;
    LocalDate endDate;
    int minimumAmount;
    boolean userEligible;

    public Coupon(String couponCode, LocalDate startDate, LocalDate endDate, int minimumAmount, boolean userEligible) {
        this.couponCode = couponCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.minimumAmount = minimumAmount;
        this.userEligible = userEligible;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getMinimumAmount() {
        return minimumAmount;
    }

    public boolean isUserEligible() {
        return userEligible;
    }

    public boolean isValid(Cart cart){

        //check for user ELigiblity as well
        return cart.amount >= minimumAmount && userEligible() && isActive();

    }

    public boolean isActive(){

        return LocalDate.now().isAfter(startDate) &&
                LocalDate.now().isBefore(endDate);

    }

//    //user class should have a method to check if user is eligible for the coupon or not
    public boolean userEligible(){
        return true;
    }


}
