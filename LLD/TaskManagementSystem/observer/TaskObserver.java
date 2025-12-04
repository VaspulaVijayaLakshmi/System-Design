package LLD_Interview_Problems.TaskManagementSystem.observer;

import LLD_Interview_Problems.TaskManagementSystem.models.Task;

public interface TaskObserver {

    public void update(Task task,String changeType);
}
