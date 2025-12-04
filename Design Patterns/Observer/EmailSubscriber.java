package Behavioural.Observer;


public class EmailSubscriber implements Subscriber {

    @Override
    public void update(String video){
        System.out.println("Email Subscriber: New video uploaded: "+video);
    }

}
