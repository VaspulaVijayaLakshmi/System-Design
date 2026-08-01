//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import models.Notification;
import models.NotificationChannel;
import models.NotificationPreference;
import models.User;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Create User
        User user = new User(
                "user-1",
                "user@gmail.com",
                "9876543210",
                "device-token-123"
        );

        // Configure User Preferences
        NotificationPreference preference =
                user.getNotificationPreference();

        preference.enableChannel(NotificationChannel.EMAIL);
        preference.enableChannel(NotificationChannel.SMS);
        preference.enableChannel(NotificationChannel.PUSH);

        // Create Notification
        Notification notification = new Notification(
                "notification-1",
                "Order Update",
                "Your order has been shipped!"
        );

        // Create Factory
        NotificationFactory factory =
                new NotificationFactory();

        // Create Notification Service
        NotificationService notificationService =
                new NotificationService(factory);

        // Send Notification
        notificationService.sendNotification(
                user,
                notification
        );
    }
}