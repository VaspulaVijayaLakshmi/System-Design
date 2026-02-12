package startegy;

import config.RateLimitConfig;
import model.User;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class SlidingWindowRateLimiter implements RateLimiter {

    private static final long WINDOW_SIZE = 60_000;

    //store user Id -> his request TimeStamps
    Map<String, Queue<Long>> userRequestTimestamps = new HashMap<>();
    //1min

    RateLimitConfig rateLimiterConfig = new RateLimitConfig();


    @Override
    public boolean acceptRequest(User user) {

        String userId = user.getUserId();
        int maxRequestsAllowed = rateLimiterConfig.getRateLimit(user.getUserType());

        long now = System.currentTimeMillis();

        Queue<Long> userRequests = userRequestTimestamps.getOrDefault(userId,null);

        //new user
        if(userRequests == null){
            userRequests = new LinkedList<>();
            userRequests.add(System.currentTimeMillis());

            userRequestTimestamps.put(userId,userRequests);
            return true;
        }

        else{

            //while slide the window

            while(!userRequests.isEmpty() && now - userRequests.peek() > WINDOW_SIZE){
               //remove the request which are out of window
                userRequests.poll();
            }

            if(userRequests.size() >= maxRequestsAllowed){
                return false;
            }

             userRequests.add(System.currentTimeMillis());
            return true;

        }

    }
}
