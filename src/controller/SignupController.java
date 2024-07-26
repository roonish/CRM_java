package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import util.SignupInteractor;
import view.LoginView;
import view.SignupView;

public class SignupController {
    private SignupView view;
    private SignupInteractor interactor;
    private Stage stage;

    public SignupController(Stage stage) {
        this.stage = stage;
        view = new SignupView();
        interactor = new SignupInteractor();
        initializeActions();
    }

    public SignupView getView() {
        return view;
    }

    private void initializeActions() {
        view.getSignUpButton().setOnAction(event -> signUp());
    }

    private void signUp() {
        String username = view.getUsernameField().getText();
        String email = view.getEmailField().getText();
        String password = view.getPasswordField().getText();
        String confirmPassword = view.getConfirmPasswordField().getText();

        if (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match!");
            return;
        }

        interactor.signUp(username, email, password);
        goToLogin();
    }

    private void goToLogin() {
        LoginController loginController = new LoginController(stage);
        Scene scene = new Scene(loginController.getView(), 600, 400);
        stage.setScene(scene);
    }
}
