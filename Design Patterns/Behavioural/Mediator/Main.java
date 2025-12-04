package Behavioural.Mediator;

import java.util.List;

public class Main {

    public static void main(String[] args) {

     AuctionMediator auctionMediator = new AuctionMediator();
     Bidding bidding = new Bidding(auctionMediator);

     bidding.registerBidder("bidder1");
     bidding.registerBidder("bidder2");

     List<String> bidders = bidding.getBidders();


     for(String bidder : bidders){
            System.out.println("Registered Bidder: " + bidder);
     }


     bidding.placeBid("bidder1", 1000);

    }
}
