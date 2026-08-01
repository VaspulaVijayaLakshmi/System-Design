package models;

import java.util.Set;

public class User {

    String userId;
    String deviceToken;
    String email;
    String phoneNumber;

    NotificationPreference notificationPreference;


    public User(String userId, String deviceToken, String email, String phoneNumber) {
        this.userId = userId;
        this.deviceToken = deviceToken;
        this.email = email;
        this.phoneNumber = phoneNumber;

        this.notificationPreference = new NotificationPreference();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public void addChannel(NotificationChannel channel){
        notificationPreference.enableChannel(channel);
    }

    public void removeChannel(NotificationChannel channel){
        notificationPreference.disableChannel(channel);
    }

    public NotificationPreference getNotificationPreference() {
        return notificationPreference;
    }
}
