package Structural.Proxy;

public class AudioPlayer implements Player {

    @Override
    public void play() {
        System.out.println("Playing Audio...");
    }

    @Override
    public void shuffle() {
        System.out.println("Shuffling Audio...");
    }

    @Override
    public void stop() {
        System.out.println("Stopping Audio...");
    }

}
