https://algomaster.io/learn/design-patterns/java/observer

# 📌 Observer Design Pattern

The **Observer Design Pattern** is a **behavioral pattern** that defines a **one-to-many dependency** between objects.  
When one object (**the Subject**) changes its state, all its dependents (**Observers**) are **automatically notified and updated**.

---

## 🔹 When to Use
The Observer Pattern is particularly useful when:
- You have **multiple parts of the system** that need to react to a change.  
- You want to **decouple the publisher** of data from the subscribers who react to it.  
- You need a **dynamic, event-driven communication model** without hardcoding who is listening to whom.  

---

## 🔹 Example Scenario
Imagine a **NewsPublisher** system:  
- Every t



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






![image](https://github.com/user-attachments/assets/47cbfb4e-37b1-4822-8517-5bebf6e16e89)
