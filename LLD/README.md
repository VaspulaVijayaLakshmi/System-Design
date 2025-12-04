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
