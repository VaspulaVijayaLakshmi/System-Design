```java

import java.util.*;

// Observer (Subscriber)
interface Subscriber {
    void update(String message);
}

// Subject (Publisher)
class Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber s) {
        subscribers.add(s);
    }

    public void unsubscribe(Subscriber s) {
        subscribers.remove(s);
    }

    public void notifySubscribers(String message) {
        for (Subscriber s : subscribers) {
            s.update(message);
        }
    }
}

// Concrete Observer
class User implements Subscriber {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}

// Demo
public class ObserverDemo {
    public static void main(String[] args) {
        Publisher youtubeChannel = new Publisher();

        Subscriber alice = new User("Alice");
        Subscriber bob   = new User("Bob");

        youtubeChannel.subscribe(alice);
        youtubeChannel.subscribe(bob);

        youtubeChannel.notifySubscribers("🎬 New video uploaded!");

        youtubeChannel.unsubscribe(bob);

        youtubeChannel.notifySubscribers("📢 Live stream starting now!");
    }
}


```











<img width="890" height="1406" alt="image" src="https://github.com/user-attachments/assets/97595a51-4417-4649-b083-5c4903045459" />
