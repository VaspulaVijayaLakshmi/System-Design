package LLD_Interview_Problems.TaskManagementSystem.models;

import java.util.ArrayList;
import java.util.List;

public class Project {

    String name;
    List<Task> tasks;

    public Project(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

}
