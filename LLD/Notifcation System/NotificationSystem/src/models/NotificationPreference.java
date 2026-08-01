package models;

import java.util.HashSet;
import java.util.Set;

public class NotificationPreference {

    boolean isGlobalOptOut=false;
    Set<NotificationChannel> enabledChannels;

    public NotificationPreference(){
        enabledChannels=new HashSet<>();
    }

    public void OptOut(){
        isGlobalOptOut=true;
    }

    public void enableChannel(NotificationChannel channel){
        enabledChannels.add(channel);
    }

    public void disableChannel(NotificationChannel channel){
        enabledChannels.remove(channel);
    }

//    public boolean canSendNotification(NotificationChannel channel) {
//        return !isGlobalOptOut && enabledChannels.contains(channel);
//    }

    public Set<NotificationChannel> getEnabledChannels() {
        return enabledChannels;
    }

    public boolean isGlobalOptOut() {
        return isGlobalOptOut;
    }


}
