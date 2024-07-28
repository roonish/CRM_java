//package controller;
//
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import view.LoginView;
//
//public class LoginController {
//    private LoginView view;
//    private Stage stage;
//
//    public LoginController(Stage stage) {
//        this.stage = stage;
//        view = new LoginView();
//        initializeActions();
//    }
//
//    public LoginView getView() {
//        return view;
//    }
//
//    private void initializeActions() {
//        view.getLoginButton().setOnAction(event -> login());
//        view.getSignUpLabel().setOnMouseClicked(event -> goToSignUp());
//    }
//
//    private void login() {
//        String email = view.getEmailField().getText();
//        String password = view.getPasswordField().getText();
//
//        // Add login logic here
//        System.out.println("User logged in with email: " + email);
//
//        // For now, navigate to the CRMView
//        goToDashboard();
//    }
//
//    private void goToSignUp() {
//        SignupController signUpController = new SignupController(stage);
//        Scene scene = new Scene(signUpController.getView(), 600, 400);
//        stage.setScene(scene);
//    }
//
//    private void goToDashboard() {
//        CRMController crmController = new CRMController();
//        Scene scene = new Scene(crmController.getView(), 800, 600); // Adjust size as needed
//        stage.setScene(scene);
//        stage.setTitle("CRM Dashboard");
//    }
//}


package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
<<<<<<< Updated upstream
import view.LoginView;
=======
import view.AuthenticationView.LoginView;
import view.AuthenticationView.SignupView;
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes

public class LoginController {
    private Stage stage;

    public LoginController(Stage stage) {
        this.stage = stage;
<<<<<<< Updated upstream
        view = new LoginView();
        initializeActions();
    }

    public LoginView getView() {
        return view;
=======
        if (this.stage == null) {
            throw new NullPointerException("Stage is null");
        }
        System.out.println("Stage initialized");

        LoginView view = new LoginView(); // Create a new instance of LoginView
        if (view == null) {
            throw new NullPointerException("LoginView is null");
        }
        System.out.println("LoginView initialized");

        initializeActions(view);

        Scene scene = new Scene(view, 600, 400);
        if (scene == null) {
            throw new NullPointerException("Scene is null");
        }
        System.out.println("Scene created");

        stage.setScene(scene);
        stage.setTitle("Login");
        stage.show();
        System.out.println("Stage shown");
>>>>>>> Stashed changes
    }

    private void initializeActions(LoginView view) {
        view.getLoginButton().setOnAction(event -> login(view));
        view.getSignUpLabel().setOnMouseClicked(event -> goToSignUp());
    }

    private void login(LoginView view) {
        String email = view.getEmailField().getText();
        String password = view.getPasswordField().getText();

        // Add login logic here
        System.out.println("User logged in with email: " + email);
<<<<<<< Updated upstream
<<<<<<< Updated upstream

        // For now, navigate to the CRMView with a hardcoded user name
        goToDashboard("Logged In User");
    }

    private void goToSignUp() {
        SignupController signUpController = new SignupController(stage);
        Scene scene = new Scene(signUpController.getView(), 600, 400);
        stage.setScene(scene);
    }

    private void goToDashboard(String userName) {
        CRMController crmController = new CRMController(userName);
        Scene scene = new Scene(crmController.getView(), 800, 600); // Adjust size as needed
        stage.setScene(scene);
        stage.setTitle("CRM Dashboard");
    }
}

=======
        
        // If login is successful, navigate to the dashboard
        goToDashboard(email);
    }

    private void goToSignUp() {
        SignupController signupController = new SignupController(stage);
    }

    private void goToDashboard(String userName) {
=======
        
        // If login is successful, navigate to the dashboard
        goToDashboard(email);
    }

    private void goToSignUp() {
        SignupController signupController = new SignupController(stage);
    }

    private void goToDashboard(String userName) {
>>>>>>> Stashed changes
        CRMController crmController = new CRMController(stage, userName);
    }
}



<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
