package Behavioural.Mediator;

import java.util.List;

public class Bidding {

    private AuctionMediator mediator;

    public Bidding(AuctionMediator mediator){
        this.mediator = mediator;
    }

    public void registerBidder(String bidder) {
        mediator.registerBidder(bidder);
    }

    public void placeBid(String bidder, double amount) {
        mediator.placeBid(bidder, amount);
    }

    public List<String> getBidders(){
        return mediator.getBidders();
    }


}
