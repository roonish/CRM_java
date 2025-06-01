package application;

import javafx.application.Application;
import javafx.stage.Stage;
import controller.LoginController;

public class Main extends Application {
	//Overriding the start method,
    @Override
    public void start(Stage primaryStage) {
        try {
            new LoginController(primaryStage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Main method to launch the JavaFX application
    public static void main(String[] args) {
        launch(args);
    }
}
