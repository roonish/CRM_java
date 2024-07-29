package view.LogsView;

import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Member;

import java.util.Optional;

public class AddMemberDialog {

    public static Optional<Member> showAndWait() {
        Dialog<Member> dialog = new Dialog<>();
        dialog.setTitle("Add New Member");

        ButtonType addButtonType = new ButtonType("Add", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButtonType, ButtonType.CANCEL);

        VBox content = new VBox(20);
        content.setPadding(new Insets(20));
        content.setStyle("-fx-background-color: #f5f5f5;"); // Matching the default theme

        Text title = new Text("Add New Member");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-fill: black;");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        grid.setStyle("-fx-background-color: white; -fx-border-color: #ddd; -fx-border-radius: 8px; -fx-background-radius: 8px;");

        TextField nameField = new TextField();
        nameField.setPromptText("Name");
        TextField mobileField = new TextField();
        mobileField.setPromptText("Mobile");
        TextField emailField = new TextField();
        emailField.setPromptText("Email");
        TextField roleField = new TextField();
        roleField.setPromptText("Role");

        grid.add(new javafx.scene.control.Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new javafx.scene.control.Label("Mobile:"), 0, 1);
        grid.add(mobileField, 1, 1);
        grid.add(new javafx.scene.control.Label("Email:"), 0, 2);
        grid.add(emailField, 1, 2);
        grid.add(new javafx.scene.control.Label("Role:"), 0, 3);
        grid.add(roleField, 1, 3);

        content.getChildren().addAll(title, grid);
        dialog.getDialogPane().setContent(content);

        dialog.getDialogPane().lookupButton(addButtonType).setStyle(
            "-fx-background-color: #4A148C; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
        );
        dialog.getDialogPane().lookupButton(ButtonType.CANCEL).setStyle(
            "-fx-background-color: #D32F2F; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
        );

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButtonType) {
                return new Member(nameField.getText(), mobileField.getText(), emailField.getText(), roleField.getText());
            }
            return null;
        });

        return dialog.showAndWait();
    }
}
