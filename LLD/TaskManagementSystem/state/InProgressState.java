package LLD_Interview_Problems.TaskManagementSystem.state;


import LLD_Interview_Problems.TaskManagementSystem.enums.TaskStatus;
import LLD_Interview_Problems.TaskManagementSystem.models.Task;

public class InProgressState implements TaskState {

    @Override
    public void moveToTODO(Task task){
        task.setState(new ToDoState());
        task.setStatus(TaskStatus.TODO);
    }

    @Override
    public void moveToInProgress(Task task){
        System.out.println("Task already in In Progress");
    }

    @Override
    public void moveToDone(Task task){
        task.setState(new DoneState());
        task.setStatus(TaskStatus.DONE);
    }

}
