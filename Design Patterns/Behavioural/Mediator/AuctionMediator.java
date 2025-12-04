package Behavioural.Mediator;

import java.util.ArrayList;
import java.util.List;

public class AuctionMediator implements AuctionHouse {

    List<String> bidders = new ArrayList<>();

    @Override
    public void registerBidder(String bidder) {
        bidders.add(bidder);

    }

    @Override
    public void placeBid(String bidder, double amount) {
        System.out.println("Bidder: " + bidder + " placed a bid of amount: " + amount);
    }

    public List<String> getBidders(){
        return bidders;
    }
}
