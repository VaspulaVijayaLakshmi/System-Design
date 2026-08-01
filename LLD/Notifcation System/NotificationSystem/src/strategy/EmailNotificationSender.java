package strategy;

import models.Notification;
import models.User;

public class EmailNotificationSender  implements NotificationSender {

    @Override
    public void sendNotification(Notification notification, User user){
         System.out.println("Sending email to " + user.getEmail());
    }

}
