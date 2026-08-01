package strategy;

import models.Notification;
import models.User;

public class PushNotificationSender implements NotificationSender {


    @Override
    public  void sendNotification(Notification notification, User user){
        System.out.println("Sending Push Notification to " + user.getEmail());
    }
}
