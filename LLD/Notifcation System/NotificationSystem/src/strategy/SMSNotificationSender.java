package strategy;

import models.Notification;
import models.User;

public class SMSNotificationSender implements NotificationSender{

    @Override
    public void sendNotification(Notification notification, User user){
        System.out.println("Sending SMS to " + user.getEmail());
    }
}
