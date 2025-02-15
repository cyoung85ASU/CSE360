package questionAndAnswerApplication;

import java.util.*;

/*******
 * <p> Title: Answers Class. </p>
 * 
 * <p> Description: Manages a collection of answers mapped to questions. </p>
 * 
 * <p> Copyright: Lynn Robert Carter © 2024 </p>
 * 
 * @author Lynn Robert Carter
 * 
 * @version 1.00    2024-02-14 Initial version
 * 
 */
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
