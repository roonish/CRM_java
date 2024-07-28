package view.AuthenticationView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SignupView extends HBox {
    private TextField emailField;
    private PasswordField passwordField;
    private Button signUpButton;
    private Label loginLabel;

    public SignupView() {
        // Left side with purple background, logo, and title
        VBox leftSide = new VBox(20);
        leftSide.setAlignment(Pos.CENTER);
        leftSide.setPrefWidth(300);
        leftSide.setStyle("-fx-background-color: #6A1B9A;"); // Purple background
        leftSide.setPadding(new Insets(20));

        Label logo = new Label("📝"); // Placeholder for logo, you can replace it with an ImageView if you have a logo image
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

        Text signUpText = new Text("Sign Up");
        signUpText.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        // Form layout using GridPane
        GridPane form = new GridPane();
        form.setAlignment(Pos.CENTER);
        form.setHgap(10);
        form.setVgap(20);

        Label emailLabel = new Label("Email");
        emailField = new TextField();
        emailField.setPromptText("Enter your email");

        Label passwordLabel = new Label("Password");
        passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");

        signUpButton = new Button("Sign up");
        signUpButton.setStyle("-fx-background-color: #6A1B9A; -fx-text-fill: white;");

        // Align button to the right
        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.CENTER_RIGHT);
        buttonBox.getChildren().add(signUpButton);

        form.add(emailLabel, 0, 0);
        form.add(emailField, 1, 0);
        form.add(passwordLabel, 0, 1);
        form.add(passwordField, 1, 1);
        form.add(buttonBox, 1, 2);

        loginLabel = new Label("Already have an account? Sign in");
        loginLabel.setStyle("-fx-text-fill: #6A1B9A;");

        rightSide.getChildren().addAll(signUpText, form, loginLabel);

        // Combine left and right sides
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

    public Button getSignUpButton() {
        return signUpButton;
    }

    public Label getLoginLabel() {
        return loginLabel;
    }
}
