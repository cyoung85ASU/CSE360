package questionAndAnswerApplication;

import java.util.*;

/*******
 * <p> Title: Questions Class. </p>
 * 
 * <p> Description: Manages a collection of stored questions. </p>
 * 
 * <p> Copyright: Lynn Robert Carter © 2024 </p>
 * 
 * @author Lynn Robert Carter
 * 
 * @version 1.00    2024-02-14 Initial version
 * 
 */
public class Questions {
    private final Map<String, Question> questionMap = new HashMap<>();

    public String addQuestion(String text, String author) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("Question cannot be empty.");
        }
        Question newQuestion = new Question(text, author);
        questionMap.put(newQuestion.getId(), newQuestion);
        return newQuestion.getId();
    }

    public List<Question> getAllQuestions() {
        return new ArrayList<>(questionMap.values());
    }

    // ✅ New method to fetch a question by its ID
    public Question getQuestionById(String id) {
        return questionMap.getOrDefault(id, null);
    }
}
