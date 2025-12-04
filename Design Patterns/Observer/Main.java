package Behavioural.Observer;

public class Main {

    public static void main(String[] args) {

        YoutubeChannel channel1 = new YoutubeChannel();

        Subscriber subscriber1 = new SMSSubscriber();
        Subscriber subscriber2 = new EmailSubscriber();

        channel1.addSubscriber(subscriber1);
        channel1.addSubscriber(subscriber2);

        channel1.uploadVideo("Design Patterns in Java");
        
    }
}
