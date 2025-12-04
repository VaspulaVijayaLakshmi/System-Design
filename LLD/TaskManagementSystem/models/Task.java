package LLD_Interview_Problems.TaskManagementSystem.models;

import LLD_Interview_Problems.TaskManagementSystem.enums.TaskPriority;
import LLD_Interview_Problems.TaskManagementSystem.enums.TaskStatus;
import LLD_Interview_Problems.TaskManagementSystem.observer.TaskObserver;
import LLD_Interview_Problems.TaskManagementSystem.state.TaskState;
import LLD_Interview_Problems.TaskManagementSystem.state.ToDoState;

import java.time.LocalDate;
import java.util.List;

public class Task {

    String title;
    String description;
    long createdOn;
    TaskPriority priority;
    TaskStatus taskStatus;
    List<Task> subtasks;
    List<String> tags;
    User assignedTo;
    TaskState taskState;
    private LocalDate dueDate;
    List<ActivityLog> activityLogs;
    private List<TaskObserver> observers;

    public Task(String title, String description, TaskPriority priority) {
        this.title = title;
        this.description = description;
        this.createdOn = System.currentTimeMillis();
        this.taskStatus = TaskStatus.TODO;
        this.priority = priority;
        this.taskState = new ToDoState();
    }


    //getters and setters
    public String getTitle() {return this.title;}

    public String getDescription() {return this.description;}

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void AssignedTaskTo(User assignedTo) {

        this.assignedTo = assignedTo;
        addLog("Task " + this.title + " assigned to " + assignedTo);
        notify(this, "Task Assigned");
    }

    public User getAssignedTo() {
        return this.assignedTo;
    }

    public TaskState getTaskState() {
        return this.taskState;
    }

    public TaskStatus getTaskStatus() {
        return this.taskStatus;
    }

    public void setState(TaskState taskState) {
        this.taskState = taskState;
    }

    public void UpdateTaskStatus(TaskStatus status) {

        this.taskStatus = status;
        addLog("Updated Task Status of Task " + this.title + " to " + status);
        notify(this, "Task Status Updated");

    }

    public LocalDate getDueDate() {return this.dueDate;}

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }


    public void addSubtask(Task subtask) {
        this.subtasks.add(subtask);
        //add LOgs and notify observers

        addLog("SubTask Added " + subtask.getTitle() +" to Main Task " + this.title);
        notify(this,"Subtask Added");
    }



    //observers
    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(TaskObserver observer) {
        observers.remove(observer);
    }

    public void notify(Task task, String changeType) {
        for (TaskObserver observer : observers) {
            observer.update(this, changeType);
        }
    }


    //ACTIVITY LOGS
    public void addActivityLog(ActivityLog activityLog) {
        this.activityLogs.add(activityLog);
    }

    public void addLog(String description) {
        addActivityLog(new ActivityLog(description));

    }


}
