```
Map<String, Task> tasks;


public List<Task> listTaskByTaskStatus(TaskStatus taskStatus){
    
   return  tasks.values().stream()
    .filter(task -> task.getTaskStatus() == taskStatus )
    .collect(Collectors.toList());
    
}

```


```

public class SortByDueDate implements TaskSortStrategy {
    @Override
    public void sort(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getDueDate));
    }
}

```


```
public class SortByPriority implements TaskSortStrategy {
    @Override
    public void sort(List<Task> tasks) {
        // Higher priority (lower enum ordinal) comes first
        tasks.sort(Comparator.comparing(Task::getPriority).reversed());
    }
}
```



```
public class KeywordSearchStrategy implements SearchStrategy {
    private final String keyword;

    public KeywordSearchStrategy(String keyword) {
        this.keyword = keyword.toLowerCase();
    }

    @Override
    public List<Question> filter(List<Question> questions) {
        return questions.stream()
                .filter(q -> q.getTitle().toLowerCase().contains(keyword) ||
                        q.getBody().toLowerCase().contains(keyword))
                .collect(Collectors.toList());
    }
}
```


```

In the initial design, I prioritize core functionality that delivers immediate value to users, while keeping the system simple and reliable.
I focus on correctness, performance, and security first, along with clear APIs and data models.
I also design with extensibility in mind so additional features can be added without major refactoring.


I prioritize the core use cases, data consistency, and performance in the initial design. I keep the architecture simple, avoid premature optimization,
and ensure good observability and error handling. This allows the system to scale and evolve safely as requirements grow.

```
