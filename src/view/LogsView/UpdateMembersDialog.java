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

public class UpdateMembersDialog {

    public static Optional<Member> showAndWait(Member member) {
        Dialog<Member> dialog = new Dialog<>();
        dialog.setTitle("Update Member");

        ButtonType updateButtonType = new ButtonType("Update", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(updateButtonType, ButtonType.CANCEL);

        VBox content = new VBox(20);
        content.setPadding(new Insets(20));
        content.setStyle("-fx-background-color: #f5f5f5;"); // Matching the default theme

        Text title = new Text("Update Member");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-fill: black;");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));
        grid.setStyle("-fx-background-color: white; -fx-border-color: #ddd; -fx-border-radius: 8px; -fx-background-radius: 8px;");

        TextField nameField = new TextField(member.getName());
        TextField mobileField = new TextField(member.getMobile());
        TextField emailField = new TextField(member.getEmail());
        TextField roleField = new TextField(member.getRole());

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

        dialog.getDialogPane().lookupButton(updateButtonType).setStyle(
            "-fx-background-color: #4A148C; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
        );
        dialog.getDialogPane().lookupButton(ButtonType.CANCEL).setStyle(
            "-fx-background-color: #D32F2F; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
        );

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == updateButtonType) {
                return new Member(nameField.getText(), mobileField.getText(), emailField.getText(), roleField.getText());
            }
            return null;
        });

        return dialog.showAndWait();
    }
}
