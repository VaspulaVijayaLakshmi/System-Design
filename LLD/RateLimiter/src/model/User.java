package model;

import enums.UserType;

import java.util.UUID;

public class User {

   String userId;
   UserType userType;

   public User(UserType userType) {
       userId = UUID.randomUUID().toString();
       this.userType = userType;
   }

   public UserType getUserType(){
       return userType;
   }

   public String getUserId() {
return userId;
   }

}
