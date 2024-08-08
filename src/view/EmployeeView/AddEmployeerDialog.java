package view.EmployeeView;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddEmployeerDialog {

    public static Optional<Employees> showAndWait() {
        Dialog<Employees> dialog = new Dialog<>();
        dialog.setTitle("Add Member");

        ButtonType addButtonType = new ButtonType("Add", ButtonType.OK.getButtonData());
        dialog.getDialogPane().getButtonTypes().addAll(addButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        TextField nameField = new TextField();
        TextField mobileField = new TextField();
        TextField emailField = new TextField();
        TextField roleField = new TextField();
        List<ComboBox<String>> timePickers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ComboBox<String> timePicker = new ComboBox<>(FXCollections.observableArrayList(
                    "08:00 AM", "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM",
                    "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM"
            ));
            timePicker.setPromptText("Select Time");
            timePickers.add(timePicker);
        }

        grid.add(new javafx.scene.control.Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new javafx.scene.control.Label("Mobile:"), 0, 1);
        grid.add(mobileField, 1, 1);
        grid.add(new javafx.scene.control.Label("Email:"), 0, 2);
        grid.add(emailField, 1, 2);
        grid.add(new javafx.scene.control.Label("Role:"), 0, 3);
        grid.add(roleField, 1, 3);
        for (int i = 0; i < 5; i++) {
            grid.add(new javafx.scene.control.Label("Available Time " + (i + 1) + ":"), 0, 4 + i);
            grid.add(timePickers.get(i), 1, 4 + i);
        }

        dialog.getDialogPane().setContent(grid);

        dialog.getDialogPane().lookupButton(addButtonType).setStyle(
            "-fx-background-color: #4A148C; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
        );
        dialog.getDialogPane().lookupButton(ButtonType.CANCEL).setStyle(
            "-fx-background-color: #D32F2F; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
        );

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == addButtonType) {
                List<String> availableTimes = new ArrayList<>();
                for (ComboBox<String> timePicker : timePickers) {
                    availableTimes.add(timePicker.getValue());
                }
                return new Employees(
                        nameField.getText(),
                        mobileField.getText(),
                        emailField.getText(),
                        roleField.getText(),
                        availableTimes
                );
            }
            return null;
        });

        return dialog.showAndWait();
    }
}
