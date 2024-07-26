package application;

import controller.LoginController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        LoginController loginController = new LoginController(primaryStage);
        Scene scene = new Scene(loginController.getView(), 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CRM Application");
        primaryStage.show();
    }
}
