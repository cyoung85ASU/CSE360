package questionAndAnswerApplication;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*******
 * <p> Title: ApplicationGUI Class. </p>
 * 
 * <p> Description: Handles the JavaFX-based graphical user interface. </p>
 * 
 * <p> Copyright: Lynn Robert Carter © 2024 </p>
 * 
 * @author Lynn Robert Carter
 * 
 * @version 1.00    2024-02-14 Initial version
 * 
 */
public class ApplicationGUI extends Application {
    public final static double WINDOW_WIDTH = 800;
    public final static double WINDOW_HEIGHT = 600;

    private UserInterface theGUI;

    @Override
    public void start(Stage theStage) {
        System.out.println("JavaFX Application Starting...");

        theStage.setTitle("Q & A Application");

        Pane root = new Pane();
        theGUI = new UserInterface(root); // ✅ Connect UserInterface to root

        Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
        theStage.setScene(scene);
        theStage.show();

        System.out.println("JavaFX Window Should Be Visible Now...");
    }

    public static void main(String[] args) {
        launch(args);
    }
}
