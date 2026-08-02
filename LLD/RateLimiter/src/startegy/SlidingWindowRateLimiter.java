import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SlidingWindowRateLimiter {


//window size in seconds
 private static final long WINDOWSIZE = 60000;
 //60,000 sec -> millsecs

  //user maps ->
  //UserId -> Sliding Window which holds timestamps

    Map<Integer, Queue<Long>> userRateLimits = new HashMap<>();

    public boolean acceptRequests(User user){

        int maxRequestsAllowed = RateLimitConfig.config.get(UserTier.FREE);

        Queue<Long> userTimestamps  = userRateLimits.get(user.userId);

        //if user is not present
         if(userTimestamps == null){

             userTimestamps = new LinkedList<>();

             //Add timestamp to user
             userTimestamps.add(System.currentTimeMillis());

             //put in map
             userRateLimits.put(user.userId, userTimestamps);

             return true;

         }

         //user is present
         else{

             while(!userTimestamps.isEmpty() && System.currentTimeMillis() - userTimestamps.peek() > WINDOWSIZE ){
                 userTimestamps.poll();
             }

             //if queue is correct size, but we cant any reqiest
             //we cant anymore.

             if(userTimestamps.size() >= maxRequestsAllowed ){
                 return false;
             }

             //else
             //  add requust and return true;

             userTimestamps.add(System.currentTimeMillis());
             return true;
         }
    }


}
