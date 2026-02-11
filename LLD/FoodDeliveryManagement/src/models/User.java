package models;

import java.util.UUID;

public class User {

    String userId;
    String name;


    public User(String name) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
    }

        //getters and setters for the user class

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }



}
