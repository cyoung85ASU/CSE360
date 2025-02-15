package questionAndAnswerApplication;

import java.util.*;

public class Answers {
    private final Map<String, List<Answer>> answerMap = new HashMap<>();

    public List<Answer> getAnswersByQuestionId(String questionId) {
        return answerMap.getOrDefault(questionId, new ArrayList<>());
    }

    public void addAnswer(String questionId, String text, String author) {
        Answer newAnswer = new Answer(text, author);
        answerMap.computeIfAbsent(questionId, k -> new ArrayList<>()).add(newAnswer);
    }
}
