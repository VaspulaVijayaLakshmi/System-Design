package LLD_Interview_Problems.TaskManagementSystem.strategy.TaskSearch;

import LLD_Interview_Problems.TaskManagementSystem.enums.TaskStatus;
import LLD_Interview_Problems.TaskManagementSystem.models.Task;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByTaskStatus implements SearchStrategy {

    private TaskStatus taskStatus;

    public SearchByTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public List<Task> search(List<Task> tasks){

       return tasks.stream().
               filter(
               task-> task.getTaskStatus() == taskStatus)
               .collect(Collectors.toList());

    }
}
