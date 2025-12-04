package LLD_Interview_Problems.TaskManagementSystem.strategy.TaskSearch;

import LLD_Interview_Problems.TaskManagementSystem.models.Task;

import java.util.List;

public interface SearchStrategy {

    public List<Task> search(List<Task> tasks);
}

//filter tasks using keywords, status, user, etc.
