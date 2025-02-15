package questionAndAnswerApplication;

import java.util.List;

/*******
 * <p> Title: TestQandA Class. </p>
 * 
 * <p> Description: Executes automated and manual tests for the Q&A application. </p>
 * 
 * <p> Copyright: Lynn Robert Carter © 2024 </p>
 * 
 * @author Lynn Robert Carter
 * 
 * @version 1.00    2024-02-14 Initial version
 * 
 */
public class TestQandA {
    public static void main(String[] args) {
        Questions questions = new Questions();
        Answers answers = new Answers();

        System.out.println("✅ Q&A Application - Auto-Loaded Test");

        // ✅ Preloading Valid Questions
        String q1 = questions.addQuestion("What is your favorite color?", "Alice");
        String q2 = questions.addQuestion("What is your favorite programming language?", "Bob");
        String q3 = questions.addQuestion("What is the best way to learn Java?", "Charlie");

        System.out.println("\n📌 Preloaded Questions:");
        for (Question q : questions.getAllQuestions()) {
            System.out.println("ID: " + q.getId() + " | Question: " + q.getQuestion() + " (Author: " + q.getAuthor() + ")");
        }

        // ✅ Preloading Valid Answers
        answers.addAnswer(q1, "I love the color blue!", "David");
        answers.addAnswer(q1, "Red is the best!", "Emma");

        answers.addAnswer(q2, "I prefer Java because it's versatile.", "Frank");
        answers.addAnswer(q2, "Python is easier to learn!", "Grace");

        answers.addAnswer(q3, "Practice coding every day!", "Henry");
        answers.addAnswer(q3, "Read official Java documentation.", "Isabel");

        // ✅ Display Questions & Corresponding Answers
        System.out.println("\n📌 Questions & Answers:");
        for (Question q : questions.getAllQuestions()) {
            System.out.println("\n🔹 " + q.getQuestion() + " (ID: " + q.getId() + ")");
            List<Answer> answerList = answers.getAnswersByQuestionId(q.getId());

            if (answerList.isEmpty()) {
                System.out.println("  ❌ No answers yet.");
            } else {
                for (Answer a : answerList) {
                    System.out.println("  ✅ " + a.getAuthor() + ": " + a.getAnswer());
                }
            }
        }

        // ✅ Test: Prevent Empty Questions
        System.out.println("\n🛠 TEST: Attempting to add an empty question...");
        try {
            questions.addQuestion("", "System");
        } catch (IllegalArgumentException e) {
            System.out.println("  ✅ Caught expected error: " + e.getMessage());
        }

        // ✅ Test: Prevent Empty Answers
        System.out.println("\n🛠 TEST: Attempting to add an empty answer...");
        try {
            answers.addAnswer(q1, "", "System");
        } catch (IllegalArgumentException e) {
            System.out.println("  ✅ Caught expected error: " + e.getMessage());
        }

        // ✅ Test: Search for a Non-Existent Question ID
        System.out.println("\n🛠 TEST: Searching for a question that does not exist...");
        String fakeID = "invalid123";
        Question missingQuestion = questions.getQuestionById(fakeID);
        if (missingQuestion == null) {
            System.out.println("  ✅ Correct: No question found for ID: " + fakeID);
        } else {
            System.out.println("  ❌ ERROR: Found unexpected question: " + missingQuestion.getQuestion());
        }

        // ✅ Test: Search for Answers of a Non-Existent Question
        System.out.println("\n🛠 TEST: Searching for answers of a non-existent question...");
        List<Answer> missingAnswers = answers.getAnswersByQuestionId(fakeID);
        if (missingAnswers.isEmpty()) {
            System.out.println("  ✅ Correct: No answers found for invalid question ID.");
        } else {
            System.out.println("  ❌ ERROR: Unexpected answers found.");
        }

        System.out.println("\n✅ All tests complete!");
    }
}
