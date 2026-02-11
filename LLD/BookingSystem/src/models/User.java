package models;

import java.util.UUID;

public class User {

    String userId;
    String name;

    public User(String name) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

}

