Swiggy wants to build a Coupon & Discount Engine that allows users to apply promotional offers to their food orders.

You are required to design a system that can:

Functional Requirements

Users should be able to apply a coupon code to their cart.

Validation: 

The system should validate the coupon based on:

Coupon validity period (start & end time)
Minimum order value
User eligibility
Maximum usage per user
Total usage limit



The system should support multiple types of coupons:

Percentage discount (with optional max cap)
Flat discount
Free delivery
Buy One Get One (BOGO)

Some coupons may be combinable, while others cannot be stacked.

The system should calculate the final payable amount after applying discounts.


Core entities:


Coupon
StartDate
EndDate
MinOrderVal
TotalUserUsage
UserEligible
Stacked - true or false -> if any one of them is not stacked then both of them cannot be applied together



Dicount - Strategy

FlatDsoiunt
PercentageDiscount
FreeDelivery



Cart

List<Items>
orderamount








