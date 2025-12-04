Mediator design pattern

Aunctioner - who calls for bigs

Bidder - who bids to buy something.




AUntion  Bidder 



Bidders should register for the auction
and then start calling for bids....

The problem is if we have multiple bidders

all of them need to register, we need to add/remove bidders
and it will have tight coupling between Auctioneer and Bidders


but we may introduce an additional layer called LIke Aunction HOuse


Where we will have the auctioner bidders
add and remove uanctioners and bidders
And open / close auction
Assign an aunctioner to particular auction
...


All this...so that Bidder is not directly coupler to AUnction..


Mediator mediating all the aunction.


