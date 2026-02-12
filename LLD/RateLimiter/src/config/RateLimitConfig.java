package config;

import enums.UserType;

import java.util.Map;

public class RateLimitConfig {

    private final Map<UserType, Integer> ratelimitConfig =
            Map.of(UserType.FREE, 10, UserType.PREMIUM, 20, UserType.ENTERPRISE, 30);

    public int getRateLimit(UserType userType) { return ratelimitConfig.getOrDefault(userType, 0); }

}
