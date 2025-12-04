package LLD_Interview_Problems.TaskManagementSystem.state;

import LLD_Interview_Problems.TaskManagementSystem.models.Task;

public interface TaskState {

    public void moveToTODO(Task task);
    public void moveToInProgress(Task task);
    public void moveToDone(Task task);

}
