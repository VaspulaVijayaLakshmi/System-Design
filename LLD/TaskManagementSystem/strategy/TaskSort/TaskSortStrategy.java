package LLD_Interview_Problems.TaskManagementSystem.strategy.TaskSort;

import LLD_Interview_Problems.TaskManagementSystem.models.Task;

import java.util.List;

public interface TaskSortStrategy {

    List<Task> sort(List<Task> tasks);
}

//Users should be able to view tasks in a list sorted by due date or priority.
