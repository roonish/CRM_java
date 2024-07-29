package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import view.AuthenticationView.LoginView;
import view.AuthenticationView.SignupView;

public class LoginController {
    private LoginView view;
    private Stage stage;

    public LoginController(Stage stage) {
        System.out.println("Initializing LoginController");

        this.stage = stage;
        if (this.stage == null) {
            throw new NullPointerException("Stage is null");
        }
        System.out.println("Stage initialized");

        this.view = new LoginView(); // Ensure view is properly initialized
        if (this.view == null) {
            throw new NullPointerException("LoginView is null");
        }
        System.out.println("LoginView initialized");

        initializeActions();

        Scene scene = new Scene(view, 600, 400);
        if (scene == null) {
            throw new NullPointerException("Scene is null");
        }
        System.out.println("Scene created");

        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
        System.out.println("Stage shown");
    }

    private void initializeActions() {
        view.getLoginButton().setOnAction(event -> login());
        view.getSignUpLabel().setOnMouseClicked(event -> goToSignUp());
    }

    private void login() {
        String email = view.getEmailField().getText();
        String password = view.getPasswordField().getText();

        // Add login logic here
        System.out.println("User logged in with email: " + email);

        // Navigate to the CRMView with a hardcoded user name for now
        goToDashboard("Logged In User");
    }

    private void goToSignUp() {
        SignupController signupController = new SignupController(stage);
    }

    private void goToDashboard(String userName) {
        // Initialize the CRMController with a new instance of BorderPane
        CRMController crmController = new CRMController(stage, userName);
    }

    public LoginView getView() {
        return view;
    }
}
