package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
<<<<<<< Updated upstream
import util.SignupInteractor;
import view.LoginView;
import view.SignupView;

public class SignupController {
    private SignupView view;
    private SignupInteractor interactor;
=======
import view.AuthenticationView.LoginView;
import view.AuthenticationView.SignupView;

public class SignupController {
>>>>>>> Stashed changes
    private Stage stage;

    public SignupController(Stage stage) {
        this.stage = stage;
<<<<<<< Updated upstream
        view = new SignupView();
        interactor = new SignupInteractor();
        initializeActions();
    }

    public SignupView getView() {
        return view;
=======
        if (this.stage == null) {
            throw new NullPointerException("Stage is null");
        }
        System.out.println("Stage initialized");

        SignupView view = new SignupView(); // Create a new instance of SignupView
        if (view == null) {
            throw new NullPointerException("SignUpView is null");
        }
        System.out.println("SignUpView initialized");

        initializeActions(view);

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

    private void initializeActions(SignupView view) {
        view.getSignUpButton().setOnAction(event -> signUp(view));
        view.getLoginLabel().setOnMouseClicked(event -> goToSignIn());
    }

    private void signUp(SignupView view) {
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
>>>>>>> Stashed changes
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



