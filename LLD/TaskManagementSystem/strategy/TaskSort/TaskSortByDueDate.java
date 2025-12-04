package LLD_Interview_Problems.TaskManagementSystem.strategy.TaskSort;

import LLD_Interview_Problems.TaskManagementSystem.models.Task;

import java.util.Comparator;
import java.util.List;

public class TaskSortByDueDate implements TaskSortStrategy {

    @Override
    public List<Task> sort(List<Task> tasks) {

        tasks.sort(Comparator.comparing(Task::getDueDate));
        return tasks;
    }

}
