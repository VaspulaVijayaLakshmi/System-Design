import enums.UserType;
import model.User;
import startegy.RateLimiter;
import startegy.SlidingWindowRateLimiter;
import startegy.TokenBucketRateLImiter;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {



                RateLimiter rateLimiter1 = new SlidingWindowRateLimiter();

                User user1 = new User( UserType.FREE);

                for (int i = 1; i <= 15; i++) {
                    boolean allowed = rateLimiter1.acceptRequest(user1);
                    System.out.println("Request " + i + " : " + allowed);
                }



        RateLimiter rateLimiter2 = new TokenBucketRateLImiter(10);

        User user2 = new User( UserType.PREMIUM );

        for (int i = 1; i <= 15; i++) {
            boolean allowed = rateLimiter2.acceptRequest(user2);
            System.out.println("Request " + i + " : " + allowed);
        }

    }
}