package startegy;

import config.RateLimitConfig;
import model.User;


public class TokenBucketRateLImiter implements RateLimiter {


    int currTokens;
    int maxTokens;
    long lastFilledAt;

    private final int refillTokensPerSecond = 1;
        // Refill one token every second

    RateLimitConfig rateLimiterConfig;


    public TokenBucketRateLImiter(int maxTokens) {

this.maxTokens = maxTokens;
this.currTokens = maxTokens;
 this.lastFilledAt = System.currentTimeMillis();
    }



@Override
    public boolean acceptRequest(User user) {

        refill();

        if(currTokens >=1){
            currTokens -= 1;
            return true;
        }

        return false;

    }

    public void refill(){

        long now = System.currentTimeMillis();
        long elapsed = now - lastFilledAt;

        int tokenToAdd = (int)elapsed * refillTokensPerSecond/1000;
        currTokens = Math.min(currTokens + tokenToAdd, maxTokens);


    }

}
