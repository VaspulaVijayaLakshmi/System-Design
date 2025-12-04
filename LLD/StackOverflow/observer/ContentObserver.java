package LLD_Interview_Problems.StackOverflow.observer;

import LLD_Interview_Problems.StackOverflow.models.Content;

public class ContentObserver {

    public void update(Content content, String message){
        System.out.println("Notification for Content ID: " + content.getId() + " - " + message);
    }
}
