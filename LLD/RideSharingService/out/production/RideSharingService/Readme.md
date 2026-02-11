Design and implement a Ride Sharing Service that allows riders to request rides,
drivers to accept trips, and the system to manage trip assignments, payments, and trip status.

Entities

Ride
payment
Rider
Driver
RideStatus (enum): REQUESTED, ONGOING, COMPLETED, CANCELLED.
Location

DriverStatus (enum): AVAILABLE, ON_TRIP, OFFLINE.



FR 

NR

No double booking - strojg consistency
Reliabiloty
Avabality



DB

Ride - ride Id, 

Driver - driver Id, name, locationId , status
Rider - riderId, phno, location

Payment - payment Id, rideId,  amount, sttaus

Location - location Id ,  lat, long

Ride - ride Id, riderId, driverId, amount, status, pickupLocationId, dropLocationId



PaymentId should not be part of Ride entity

Why (interview-safe)

Payment is a separate lifecycle
Ride can exist before payment
Payment may fail / retry / be partial

Keeps responsibilities clean

Correct relationship
Payment has rideId (FK)
Ride does not depend on payment existence