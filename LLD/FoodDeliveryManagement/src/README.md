
Food Delivery Management System


Design and implement a Food Delivery Service system that allows customers 
to place orders from restaurants, 
manages menu items, assigns delivery agents, and tracks order status from placement to delivery.

___________

FUnctional Requirements : 

Place order
Menu Items - Add/remove menu items
Assign Delivery Agent
Track OrderStatus - Placed, Preparing, OOD,  Delivered

Search - restaurants - ? 

_________

Non FR : 

Highly available
Concurrent orders
Reliable


Core Entities: 

Order
User
Restaurant
Delivery Agent
Order Staus - enum
Menu Item

________

APIS : 

POST 

/order { user : 
         items:
        restaurant:
}


GET
/order/{orderId}/status



GET
/order/{restaurantId}/menu


Agent assignment is usually async, not in request path

___________

DB schema:

User - userId - PK , username, email - unique

Restaurant - restaurant Id - PK , location, name

Order - orderId - PK ,  UserId - FK, Restaurant Id - FK, status, createdAt, updatedAt

MenuItem - menuItemId - PK, restaurantId - FK, name, price

DeliveryAgent - agentId - PK, name, available

OrderItem
---------
orderItemId  PK
orderId      FK
menuItemId   FK
quantity


____________


UML DIagram 


user -> api gateway -> order servce -> Order DB, REST  DB
                       user service -> User DB
                       Delivery Service 
                       Auth and Auth


Delivery Service :

Owns delivery agents
Assigns agents
Tracks delivery state

Kafka / Queue

Used for async communication
Order placed → event
Delivery service consumes and reacts









