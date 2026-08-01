package models;

public class Notification {

    String notificationId;
    String title;
    String message;


    public Notification(String notificationId, String title, String message) {
        this.notificationId = notificationId;
        this.title = title;
        this.message = message;

    }

    public String getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(String notificationId) {
        this.notificationId = notificationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
