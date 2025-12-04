package Behavioural.Observer;

public class SMSSubscriber implements Subscriber {

    @Override
    public void update(String video){
        System.out.println("SMS Subscriber: New video uploaded: "+video);
    }
}
