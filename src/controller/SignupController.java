package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import util.SignupInteractor;
import view.AuthenticationView.SignupView;

public class SignupController {
    private SignupView view;
    private Stage stage;
    private SignupInteractor signupInteractor;

    public SignupController(Stage stage) {
        this.stage = stage;
        this.view = new SignupView();
        this.signupInteractor = new SignupInteractor();

        initializeActions();

        Scene scene = new Scene(view, 600, 400);
        stage.setScene(scene);
    }

    private void initializeActions() {
        view.getSignUpButton().setOnAction(e -> handleSignUp());
        view.getLoginLabel().setOnMouseClicked(e -> showLoginView());
    }

    private void handleSignUp() {
        String fullName = view.getFullNameField().getText();
        String email = view.getEmailField().getText();
        String password = view.getPasswordField().getText();

        boolean isValid = true;

        // Validate full name
        if (fullName.isEmpty()) {
            view.getFullNameErrorLabel().setText("Full Name is required.");
            view.getFullNameErrorLabel().setVisible(true);
            isValid = false;
        } else {
            view.getFullNameErrorLabel().setVisible(false);
        }

        // Validate email
        if (email.isEmpty() || !isValidEmail(email)) {
            view.getEmailErrorLabel().setText(email.isEmpty() ? "Email is required." : "Invalid email format.");
            view.getEmailErrorLabel().setVisible(true);
            isValid = false;
        } else {
            view.getEmailErrorLabel().setVisible(false);
        }

        // Validate password
        if (password.isEmpty() || password.length() < 6) {
            view.getPasswordErrorLabel().setText(password.isEmpty() ? "Password is required." : "Password must be at least 6 characters.");
            view.getPasswordErrorLabel().setVisible(true);
            isValid = false;
        } else {
            view.getPasswordErrorLabel().setVisible(false);
        }

        if (isValid) {
            boolean success = signupInteractor.signUp(fullName, email, password);

            if (success) {
                showLoginView();
            } else {
                // Handle sign-up failure (e.g., show a dialog or a message)
                System.out.println("Sign up failed.");
            }
        }
    }

    private boolean isValidEmail(String email) {
        // Basic email format validation
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    private void showLoginView() {
        new LoginController(stage);
    }
}
