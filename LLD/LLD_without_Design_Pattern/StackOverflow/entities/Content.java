package LLD_without_Design_Pattern.StackOverflow.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public abstract class Content {

    private String Id;
    private String text;
    //author
    Account account;
    List<Answer> answer;
    List<Comment> comment;
     int voteCount=0;     // upvotes - downvotes
     int upVotes=0;
     int downVotes=0;
     Date createdDate;


    public Content(String text, Account account) {
        this.Id= UUID.randomUUID().toString();
        this.text = text;
        this.account = account;
        this.createdDate = new Date();
        answer = new ArrayList<>();
        comment = new ArrayList<>();
    }


}
