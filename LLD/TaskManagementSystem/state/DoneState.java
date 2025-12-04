package LLD_Interview_Problems.TaskManagementSystem.state;

import LLD_Interview_Problems.TaskManagementSystem.enums.TaskStatus;
import LLD_Interview_Problems.TaskManagementSystem.models.Task;

public class DoneState implements TaskState {

    @Override
    public void moveToTODO(Task task){
        task.setStatus(TaskStatus.TODO);
        task.setState(new ToDoState());
    }

    @Override
    public void moveToInProgress(Task task){
        task.setState(new InProgressState());
        task.setStatus(TaskStatus.IN_PROGRESS);
    }

    @Override
    public void moveToDone(Task task){
        System.out.println("Task is already in DONE state");
    }
}
