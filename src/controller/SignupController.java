package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import view.AuthenticationView.LoginView;
import view.AuthenticationView.SignupView;

public class SignupController {
    private SignupView view;
    private Stage stage;

    public SignupController(Stage stage) {
        System.out.println("Initializing SignupController");

        this.stage = stage;
        if (this.stage == null) {
            throw new NullPointerException("Stage is null");
        }
        System.out.println("Stage initialized");

        this.view = new SignupView(); // Ensure view is properly initialized
        if (this.view == null) {
            throw new NullPointerException("SignUpView is null");
        }
        System.out.println("SignUpView initialized");

        initializeActions();

        Scene scene = new Scene(view, 600, 400);
        if (scene == null) {
            throw new NullPointerException("Scene is null");
        }
        System.out.println("Scene created");

        stage.setScene(scene);
        stage.setTitle("Sign Up");
        stage.show();
        System.out.println("Stage shown");
    }

    private void initializeActions() {
        view.getSignUpButton().setOnAction(event -> signUp());
        view.getLoginLabel().setOnMouseClicked(event -> goToSignIn());
    }

    private void signUp() {
        String fullName = view.getFullNameField().getText();
        String email = view.getEmailField().getText();
        String password = view.getPasswordField().getText();

        // Add sign-up logic here
        System.out.println("User signed up with full name: " + fullName + ", email: " + email);

        // Navigate to the login view after successful sign-up
        goToSignIn();
    }

    private void goToSignIn() {
        LoginController loginController = new LoginController(stage);
    }

    public SignupView getView() {
        return view;
    }
}
