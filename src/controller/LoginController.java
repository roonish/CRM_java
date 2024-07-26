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
import view.LoginView;

public class LoginController {
    private LoginView view;
    private Stage stage;

    public LoginController(Stage stage) {
        this.stage = stage;
        view = new LoginView();
        initializeActions();
    }

    public LoginView getView() {
        return view;
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

