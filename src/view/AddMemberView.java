package view;

import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.util.Pair;
import model.Member;

import java.util.Optional;

public class AddMemberView {

    public static Optional<Member> showAndWait() {
        Dialog<Member> dialog = new Dialog<>();
        dialog.setTitle("Add New Member");

        ButtonType addButtonType = new ButtonType("Add", ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(addButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

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

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButtonType) {
                return new Member(nameField.getText(), mobileField.getText(), emailField.getText(), roleField.getText());
            }
            return null;
        });

        return dialog.showAndWait();
    }
}
