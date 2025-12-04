package LLD_Interview_Problems.StackOverflow;

import LLD_Interview_Problems.StackOverflow.enums.VoteType;
import LLD_Interview_Problems.StackOverflow.models.Answer;
import LLD_Interview_Problems.StackOverflow.models.Question;
import LLD_Interview_Problems.StackOverflow.models.User;
import LLD_Interview_Problems.StackOverflow.strategy.KeyWordSearchStrategy;
import LLD_Interview_Problems.StackOverflow.strategy.SearchStrategy;
import LLD_Interview_Problems.StackOverflow.strategy.TagSearchStrategy;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StackOverFlow {

    private final Map<String, User> users = new ConcurrentHashMap<>();
    private final Map<String, Question> questions = new ConcurrentHashMap<>();
    private final Map<String, Answer> answers = new ConcurrentHashMap<>();
    SearchStrategy searchStrategy;


    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public User createUser(String authorName){
        User user=new User(authorName);
        users.put(user.getUserId(),user);
        return user;
    }

    public Question postQuestion(String userId, String title, String body){
        User author = users.get(userId);
        Question question = new Question(title, body, author);
//        question.addObserver();
        questions.put(question.getId(), question);
        return question;
    }

    public Answer postAnswer(String userId, String title, String body,String questionId){
        User author = users.get(userId);
        Question question = questions.get(questionId);
        Answer answer = new Answer(body, author);
        question.addAnswer(answer);
        answers.put(answer.getId(), answer);
        return answer;

    }

    public void acceptAnswer(String questionId, String answerId) {
        Question question = questions.get(questionId);
        Answer answer = answers.get(answerId);
        question.setAcceptedAnswer(answer);
    }


//    public void voteOnPost(String userId, String postId, VoteType voteType) {
//        User user = users.get(userId);
//        Post post = findPostById(postId);
//        post.vote(user, voteType);
//    }


    public List<Question> searchByKeyword(String keyword){
        return new KeyWordSearchStrategy(keyword)
                .search(new ArrayList<>(questions.values()));
    }

    public List<Question> searchByTag(String tag){
        return new TagSearchStrategy(tag)
                .search(new ArrayList<>(questions.values()));
    }


}
