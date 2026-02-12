package startegy;

import model.User;

public interface RateLimiter {

     boolean acceptRequest(User user);
}
