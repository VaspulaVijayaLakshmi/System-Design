https://algomaster.io/learn/design-patterns/java/template-method

```java
abstract class Game {
    // template method
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }

    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();
}

class Football extends Game {
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
    void endPlay() {
        System.out.println("Football Game Finished!");
    }
}

class Cricket extends Game {
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }
}

// Usage
public class Main {
    public static void main(String[] args) {
        Game game1 = new Football();
        game1.play();

        Game game2 = new Cricket();
        game2.play();
    }
}
```
