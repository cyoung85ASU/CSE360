package questionAndAnswerApplication;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.util.HashMap;
import java.util.Map;

public class UserInterface {

    private Questions questionService;
    private Answers answerService;

    private Label applicationTitle = new Label("Q & A Application");
    private TextField userQuestionField = new TextField();
    private Button addQuestionButton = new Button("Submit Question");

    private VBox mainLayout = new VBox(15);
    private Map<String, VBox> questionSections = new HashMap<>(); // Stores UI for each question

    public UserInterface(Pane root) {
        this.questionService = new Questions();
        this.answerService = new Answers();

        applicationTitle.setFont(new Font(20));

        // Layout for entering a question
        HBox questionInputLayout = new HBox(10, userQuestionField, addQuestionButton);
        VBox questionArea = new VBox(20, applicationTitle, questionInputLayout, mainLayout);
        questionArea.setPadding(new Insets(20));

        root.getChildren().add(questionArea);

        addQuestionButton.setOnAction(e -> addQuestion());
    }

    private void addQuestion() {
        String questionText = userQuestionField.getText().trim();
        if (questionText.isEmpty()) {
            showAlert("Error", "Question cannot be empty.");
            return;
        }

        // Add question to the service
        String questionId = questionService.addQuestion(questionText, "User");

        //  Create UI for this question
        VBox questionBox = createQuestionSection(questionId, questionText);
        questionSections.put(questionId, questionBox); //  Store the section in the map
        mainLayout.getChildren().add(questionBox); //  Add to the main UI

        userQuestionField.clear();
    }

    private VBox createQuestionSection(String questionId, String questionText) {
        Label questionLabel = new Label(questionText);
        questionLabel.setStyle("-fx-font-weight: bold;");

        TextField answerField = new TextField();
        Button submitAnswerButton = new Button("Submit Answer");
        ListView<String> answerListView = new ListView<>();

        // Submit answer action
        submitAnswerButton.setOnAction(e -> {
            String answerText = answerField.getText().trim();
            if (!answerText.isEmpty()) {
                answerService.addAnswer(questionId, answerText, "User");
                refreshAnswerList(questionId, answerListView);
                answerField.clear();
            } else {
                showAlert("Error", "Answer cannot be empty.");
            }
        });

        VBox questionSection = new VBox(10, questionLabel, answerField, submitAnswerButton, answerListView);
        questionSection.setPadding(new Insets(10));
        questionSection.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px; -fx-padding: 10px;");

        return questionSection;
    }

    private void refreshAnswerList(String questionId, ListView<String> answerListView) {
        answerListView.getItems().clear();
        for (Answer a : answerService.getAnswersByQuestionId(questionId)) {
            answerListView.getItems().add(a.getAnswer());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
