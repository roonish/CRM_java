

import controller.CRMController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        CRMController controller = new CRMController();
        Scene scene = new Scene(controller.getView(), 500, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CRM Application");
        primaryStage.show();
    }
}
