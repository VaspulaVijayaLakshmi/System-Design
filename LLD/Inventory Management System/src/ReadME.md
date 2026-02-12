Inventory Mnaagement SYstem

Problem Statement

Design and implement an Inventory Management System for an e-commerce platform.
The system should support multiple warehouses and manage stock for products across them.


wrehouses
Stock - 
Product


Add a new product.
Add stock for a product in a warehouse.
Remove/deduct stock (when an order is placed).
Reserve stock before payment confirmation.
Release reserved stock (if order is cancelled).

Get available stock for a product in a warehouse.
Support multiple warehouses.
Maintain inventory transaction history (audit log).



Good — now you're thinking like SDE-2.

If a user buys 3–4 different products in bulk, then:

We do NOT create one inventory transaction for the whole order.

We create:

One transaction per product per warehouse.

Because inventory is maintained at:

(productId + warehouseId) level

Example

User places Order O1:

P1 → 5 qty

P2 → 3 qty

P3 → 10 qty

Then we will create:

Transaction 1 → P1, W1, DEDUCT, 5
Transaction 2 → P2, W1, DEDUCT, 3
Transaction 3 → P3, W2, DEDUCT, 10


Even though it's one order,
inventory operations are separate.