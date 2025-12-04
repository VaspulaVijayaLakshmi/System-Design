package LLD_Interview_Problems.StackOverflow.strategy;

import LLD_Interview_Problems.StackOverflow.models.Question;

import java.util.List;
import java.util.stream.Collectors;

public class KeyWordSearchStrategy implements SearchStrategy {

    private String keyword;

    public KeyWordSearchStrategy(String Keyword){
        this.keyword = Keyword;
    }

    @Override
    public List<Question> search(List<Question> questions) {

        return questions.stream()
                .filter(q -> q.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                        q.getDescription().toLowerCase().contains(keyword.toLowerCase())
                ).collect(Collectors.toList());
    }

}
