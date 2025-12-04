package LLD_Interview_Problems.TaskManagementSystem.observer;

import LLD_Interview_Problems.TaskManagementSystem.models.Task;

public class ActivityObserver implements TaskObserver {

    @Override
    public void update(Task task, String changeType) {
        System.out.println("Activity Log - Task " + changeType + ": " + task.getTitle());
    }
}
