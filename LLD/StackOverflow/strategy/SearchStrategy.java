package LLD_Interview_Problems.StackOverflow.strategy;

import LLD_Interview_Problems.StackOverflow.models.Question;
import java.util.List;

public interface SearchStrategy {

    public List<Question> search(List<Question> questions);
}
