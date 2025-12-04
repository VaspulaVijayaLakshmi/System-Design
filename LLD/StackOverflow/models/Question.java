package LLD_Interview_Problems.StackOverflow.models;

import java.util.ArrayList;
import java.util.List;

public class Question extends Content{

    String title;
    List<Tag> tags;
    List<Answer> answers;
    Answer acceptedAnswer;
//    List<Comment> comments;

    public Question(String title, String description,User author){
        super(description,author);

        this.title=title;
        tags=new ArrayList<>();
        answers=new ArrayList<>();
//        comments=new ArrayList<>();
    }


    public String getTitle() {
        return title;
    }

    public Answer getAcceptedAnswer() {
        return acceptedAnswer;
    }

    public void setAcceptedAnswer(Answer acceptedAnswer) {
        this.acceptedAnswer = acceptedAnswer;
    }

    public void addAnswer(Answer answer){
        this.answers.add(answer);
    }


    public void addTag(Tag tag) {
        this.tags.add(tag);
    }

    public List<Tag> getTags() {
        return tags;
    }


}
