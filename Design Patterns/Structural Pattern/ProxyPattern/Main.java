package Structural.Proxy;

public class Main {

    public static void main(String[] args) {

        Proxy proxy = new Proxy();
        proxy.play("Movie1");
        proxy.play("Movie2");

        proxy.play("Movie1");

        proxy.play("Movie1");

    }

}
