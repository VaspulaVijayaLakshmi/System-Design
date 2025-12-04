package Structural.Proxy;

public class VideoPlayer implements Player {

    @Override
    public void play() {
        System.out.println("Playing video...");
    }

    @Override
    public void shuffle() {
        System.out.println("Shuffling video playlist...");
    }

    @Override
    public void stop() {
        System.out.println("Stopping video...");
    }
}
