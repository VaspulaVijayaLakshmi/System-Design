package LLD_Interview_Problems.StackOverflow.models;

import java.util.UUID;

public class User {

    //Author
    String userId;
    String authorName;
    int reputationPoints=0;

    public User(String authorName) {
        this.userId = UUID.randomUUID().toString();
        this.authorName = authorName;
    }

    public String getUserId() {
        return userId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getReputationPoints() {
        return reputationPoints;
    }

    public int addReputationPoints(int reputationPoints) {
        return this.reputationPoints++;
    }

}
