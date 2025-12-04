package LLD_Interview_Problems.TaskManagementSystem.models;

public class User {

    String userId;
    String email;

    public User(String UserId, String email) {
        this.userId = UserId;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }
}


