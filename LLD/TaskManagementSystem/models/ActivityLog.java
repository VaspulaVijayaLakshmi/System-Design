package LLD_Interview_Problems.TaskManagementSystem.models;

import java.time.LocalDateTime;

public class ActivityLog {

    String description;
    LocalDateTime timstamp;

    public ActivityLog(String description) {
        this.description = description;
        this.timstamp = LocalDateTime.now();
    }

}
