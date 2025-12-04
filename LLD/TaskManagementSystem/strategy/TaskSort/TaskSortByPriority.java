package LLD_Interview_Problems.TaskManagementSystem.strategy.TaskSort;

import LLD_Interview_Problems.TaskManagementSystem.models.Task;

import java.util.Comparator;
import java.util.List;

public class TaskSortByPriority implements TaskSortStrategy{

    @Override
    public List<Task> sort(List<Task> tasks) {


        //enum has ordinal ordering
        //order in which they are defined.

        //higher the ordinal, higher the priority
        //hence we reverse

        tasks.sort(Comparator.comparing(Task::getTaskStatus).reversed());
        return tasks;
    }
}
