package strategy;

import models.Notification;
import models.User;

public interface NotificationSender{
    public void sendNotification(Notification notification, User user);
}
