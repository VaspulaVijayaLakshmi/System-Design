package Behavioural.Observer;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel {

    private String video;
    private List<Subscriber> subscribers = new ArrayList<>();


    public void uploadVideo(String video){
        this.video=video;
        notifySubscribers();
    }


    public void addSubscriber(Subscriber subscriber){
        this.subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber){
        this.subscribers.remove(subscriber);
    }

    public void notifySubscribers(){

        for(Subscriber subscriber : subscribers){
            subscriber.update(video);
        }
    }


}
