import strategy.EmailNotificationSender;
import strategy.NotificationSender;
import strategy.PushNotificationSender;
import strategy.SMSNotificationSender;

public class NotificationFactory {

    public NotificationSender createNotification(String notificationType){

        return switch (notificationType) {
            case "EMAIL" -> new EmailNotificationSender();
            case "SMS" -> new SMSNotificationSender();
            case "PUSH" -> new PushNotificationSender();
            default -> null;
        };
    }

}


