package LLD_Interview_Problems.TaskManagementSystem.strategy.TaskSearch;

import LLD_Interview_Problems.TaskManagementSystem.models.Task;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByKeywordStrategy implements SearchStrategy {

    private String keyword;

    public SearchByKeywordStrategy(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public List<Task> search(List<Task> tasks) {

        return tasks.stream().filter(
              task -> task.getTitle().contains(keyword)
                || task.getDescription().contains(keyword)
                )
                .collect(Collectors.toList());

    }
}
