package view.AuthenticationView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class LoginView extends HBox {
    private TextField emailField;
    private PasswordField passwordField;
    private Button loginButton;
    private Label signUpLabel;
    private Label emailErrorLabel;
    private Label passwordErrorLabel;

    public LoginView() {
        // Left side with purple background, logo, and title
        VBox leftSide = new VBox(20);
        leftSide.setAlignment(Pos.CENTER);
        leftSide.setPrefWidth(300);
        leftSide.setStyle("-fx-background-color: #6A1B9A;");
        leftSide.setPadding(new Insets(20));

        Label logo = new Label("📝");
        logo.setStyle("-fx-font-size: 50px;");

        Text title = new Text("AceInvoice");
        title.setFill(Color.WHITE);
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        Text subtitle = new Text("Time Tracking and Invoicing");
        subtitle.setFill(Color.WHITE);
        subtitle.setFont(Font.font("Arial", 14));

        leftSide.getChildren().addAll(logo, title, subtitle);

        // Right side with form
        VBox rightSide = new VBox(20);
        rightSide.setAlignment(Pos.CENTER);
        rightSide.setPadding(new Insets(20));

        Text signInText = new Text("Sign In");
        signInText.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        // Form layout using GridPane
        GridPane form = new GridPane();
        form.setAlignment(Pos.CENTER);
        form.setHgap(10);
        form.setVgap(10);

        Label emailLabel = new Label("Email");
        emailField = new TextField();
        emailField.setPromptText("Enter your email");
        emailErrorLabel = new Label();
        emailErrorLabel.setTextFill(Color.RED);
        emailErrorLabel.setVisible(false);

        Label passwordLabel = new Label("Password");
        passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        passwordErrorLabel = new Label();
        passwordErrorLabel.setTextFill(Color.RED);
        passwordErrorLabel.setVisible(false);

        loginButton = new Button("Sign in");
        loginButton.setStyle("-fx-background-color: #6A1B9A; -fx-text-fill: white;");

        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.getChildren().add(loginButton);

        form.add(emailLabel, 0, 0);
        form.add(emailField, 1, 0);
        form.add(emailErrorLabel, 1, 1);
        form.add(passwordLabel, 0, 2);
        form.add(passwordField, 1, 2);
        form.add(passwordErrorLabel, 1, 3);
        form.add(buttonBox, 1, 4);

        signUpLabel = new Label("Don't have an account? Sign up");
        signUpLabel.setStyle("-fx-text-fill: #6A1B9A;");

        rightSide.getChildren().addAll(signInText, form, signUpLabel);

        this.getChildren().addAll(leftSide, rightSide);
        this.setStyle("-fx-background-color: white; -fx-border-color: #6A1B9A; -fx-border-width: 2px;");
        this.setPrefSize(600, 400);
    }

    public TextField getEmailField() {
        return emailField;
    }

    public PasswordField getPasswordField() {
        return passwordField;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public Label getSignUpLabel() {
        return signUpLabel;
    }

    public Label getEmailErrorLabel() {
        return emailErrorLabel;
    }

    public Label getPasswordErrorLabel() {
        return passwordErrorLabel;
    }
}
