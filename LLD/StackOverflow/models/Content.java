package LLD_Interview_Problems.StackOverflow.models;

import LLD_Interview_Problems.StackOverflow.observer.ContentObserver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Content {

    String id;
    String description;
    private final  LocalDateTime postedOn;
    User author;
    int upvotes=0;
    int downvotes=0;
    List<ContentObserver> observers = new ArrayList<>();


    public Content(String description,User author){
        this.id = UUID.randomUUID().toString();
        this.postedOn = LocalDateTime.now();;
        this.description = description;
        this.author = author;
    }


    //getters and setters
    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }


    public User getAuthor() {
        return author;
    }

    public int upVote(){
        return this.upvotes++;
    }

    public int downVote(){
        return this.downvotes++;
    }



    //observer
    public void addObserver(ContentObserver observer){
        observers.add(observer);
    }

    public void removeObserver(ContentObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers(String message){
        for(ContentObserver observer : observers){
            observer.update(this, message);

        }
    }


}
