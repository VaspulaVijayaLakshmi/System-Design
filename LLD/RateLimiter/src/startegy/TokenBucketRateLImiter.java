public class TokenBucketRateLimiter {


    private final int capacity;
    private final int refillRate;

    //10 requests per min

    //capacity is 10 lets say
    //we refill rate each token every 5sec.

//    so in 1min -> 60/5 = 12 tokens ~-10 lets say

    private long lastRefillTime;
    private int currTokens;


    public TokenBucketRateLimiter(int maxTokens,int refillRate){
        this.capacity = maxTokens;
        this.refillRate = refillRate;
        this.lastRefillTime = (int)System.currentTimeMillis();
    }


       public synchronized boolean allowRequest(User user){

            //refill if the time reached.
            refill();

            //check if current tokens is
            if(currTokens >= 1){
                currTokens -= 1;
                return true;
            }

            return false;

        }


        private void refill(){

            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - lastRefillTime;

            //number of
            int tokenstoBeAdded =  ((int)refillRate *  (int)elapsedTime)/1000;

            if(tokenstoBeAdded >= 0){
                currTokens = Math.min(capacity, currTokens+tokenstoBeAdded);
                lastRefillTime = currentTime;
            }



        }

    }

