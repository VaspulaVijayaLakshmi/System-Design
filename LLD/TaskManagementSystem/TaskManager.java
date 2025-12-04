package LLD_Interview_Problems.TaskManagementSystem;

import LLD_Interview_Problems.TaskManagementSystem.enums.TaskPriority;
import LLD_Interview_Problems.TaskManagementSystem.enums.TaskStatus;
import LLD_Interview_Problems.TaskManagementSystem.models.Project;
import LLD_Interview_Problems.TaskManagementSystem.models.Task;
import LLD_Interview_Problems.TaskManagementSystem.models.User;
import LLD_Interview_Problems.TaskManagementSystem.strategy.TaskSearch.SearchByTaskStatus;
import LLD_Interview_Problems.TaskManagementSystem.strategy.TaskSearch.SearchStrategy;
import LLD_Interview_Problems.TaskManagementSystem.strategy.TaskSort.TaskSortByPriority;
import LLD_Interview_Problems.TaskManagementSystem.strategy.TaskSort.TaskSortStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class TaskManager {

    private static TaskManager TaskManagerInstance;
    SearchStrategy taskSearchStrategy;
    TaskSortStrategy taskSortStrategy;

    Map<String, User> users;
    Map<String , Project> projects;
    Map<String, Task> tasks;


    private  TaskManager(){
        users = new ConcurrentHashMap<>();
        projects = new ConcurrentHashMap<>();
    }

    public static synchronized TaskManager getTaskManagerInstance(){
        if(TaskManagerInstance == null){
            TaskManagerInstance = new TaskManager();
        }
        return TaskManagerInstance;
    }

    public void setTaskSearchStargey(SearchStrategy taskSearchStargey) {
        this.taskSearchStrategy = taskSearchStargey;
    }

    public void setTaskSortStrategy(TaskSortStrategy taskSortStrategy) {
        this.taskSortStrategy = taskSortStrategy;
    }


    public User createUser(String userId, String email) {
        User user = new User(userId, email);
        users.put(user.getUserId(), user);
        return user;
    }

    public Project createTaskList(String projectName) {
        Project project = new Project(projectName);
        projects.put(project.getName(), project);
        return project;
    }

    public Task createTask(){
        return  new Task("Gift Finder",
        "Target Gift Finder" ,
                TaskPriority.HIGH);
    }

    //moved this to Strategy Pattern

//    public List<Task> listTaskByTaskStatus(TaskStatus taskStatus){
//
//       return  tasks.values().stream()
//        .filter(task -> task.getTaskStatus() == taskStatus )
//        .collect(Collectors.toList());
//
//    }
//
//    public List<Task> searchTasksByUser(String userId){
//
//        return tasks.values().stream()
//                .filter(task -> task.getAssignedTo().getUserId() == userId)
//                .collect(Collectors.toList());
//
//    }


    //Search
    public List<Task> listTaskByTaskStatus(TaskStatus taskStatus){

        return new SearchByTaskStatus(taskStatus)
                .search(new ArrayList<>(tasks.values()));

    }

   //Sort
    public List<Task> getTasksByDueDate(){

        return new TaskSortByPriority()
                .sort(new ArrayList<>(tasks.values()));
    }


}
