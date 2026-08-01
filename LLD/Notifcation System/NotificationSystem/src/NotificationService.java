import models.Notification;
import models.NotificationChannel;
import models.NotificationPreference;
import models.User;
import strategy.NotificationSender;

public class NotificationService {

    private NotificationFactory factory;

    public NotificationService(NotificationFactory factory) {
        this.factory = factory;
    }

    public void sendNotification(User user,
                                 Notification notification) {

        NotificationPreference preference =
                user.getNotificationPreference();

        // User opted out completely
        if (preference.isGlobalOptOut()) {
            return;
        }

        // Send through all enabled channels
        for (NotificationChannel channel :
                preference.getEnabledChannels()) {

            NotificationSender sender =
                    factory.createNotification(channel.toString());

            sender.sendNotification(notification,user);
        }
    }
}