package LLD_Interview_Problems.StackOverflow.strategy;

import LLD_Interview_Problems.StackOverflow.models.Question;

import java.util.List;

public class TagSearchStrategy implements SearchStrategy {

    String tag;

    public TagSearchStrategy(String tag){
        this.tag = tag;
    }

    @Override
    public List<Question> search(List<Question> questions) {

        return questions.stream().
                filter( q -> q.getTags().contains(tag) ).toList();
    }
}
