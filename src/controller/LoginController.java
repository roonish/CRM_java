package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Appointments;
import util.Connectivity;
import util.LoginInteractor;
import view.AuthenticationView.LoginView;

public class LoginController {
    private LoginView view;
    private Stage stage;
    private LoginInteractor loginInteractor;

    public LoginController(Stage stage) {
        this.stage = stage;
        this.view = new LoginView();
        this.loginInteractor = new LoginInteractor();

        initializeActions();

        Scene scene = new Scene(view, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
    }

    private void initializeActions() {
        view.getLoginButton().setOnAction(e -> handleLogin());
        view.getSignUpLabel().setOnMouseClicked(e -> showSignupView());
    }

    private void handleLogin() {
        String email = view.getEmailField().getText();
        String password = view.getPasswordField().getText();

        boolean isValid = true;

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
            boolean success = loginInteractor.authenticate(email, password);

            if (success) {
            	String fullName = loginInteractor.loadUserNameFromDatabase(email);
                showHomeView(fullName);
            } else {
                // Handle login failure (e.g., show a dialog or a message)
            }
        }
    }

    private boolean isValidEmail(String email) {
        // Basic email format validation
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    private void showSignupView() {
        new SignupController(stage);
    }

    private void showHomeView(String userName) {
    	new CRMController(stage, userName);
    }
}
