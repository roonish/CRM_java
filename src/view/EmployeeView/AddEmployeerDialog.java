package view.EmployeeView;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class AddEmployeerDialog {

    public static Optional<Employees> showAndWait() {
        Dialog<Employees> dialog = new Dialog<>();
        dialog.setTitle("Add Member");

        ButtonType addButtonType = new ButtonType("Add", ButtonBar.ButtonData.OK_DONE);
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

        grid.add(new Label("Name:"), 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(new Label("Mobile:"), 0, 1);
        grid.add(mobileField, 1, 1);
        grid.add(new Label("Email:"), 0, 2);
        grid.add(emailField, 1, 2);
        grid.add(new Label("Role:"), 0, 3);
        grid.add(roleField, 1, 3);
        for (int i = 0; i < 5; i++) {
            grid.add(new Label("Available Time " + (i + 1) + ":"), 0, 4 + i);
            grid.add(timePickers.get(i), 1, 4 + i);
        }

        // Error label to display validation messages
        Label errorLabel = new Label();
        errorLabel.setStyle("-fx-text-fill: red;");

        VBox content = new VBox(grid, errorLabel);
        content.setSpacing(10);
        dialog.getDialogPane().setContent(content);

        dialog.getDialogPane().lookupButton(addButtonType).setStyle(
            "-fx-background-color: #4A148C; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
        );
        dialog.getDialogPane().lookupButton(ButtonType.CANCEL).setStyle(
            "-fx-background-color: #D32F2F; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
        );

        // Disable the Add button until all validations are passed
        final Button addButton = (Button) dialog.getDialogPane().lookupButton(addButtonType);
        addButton.setDisable(true);

        // Add listeners to validate fields on the fly
        nameField.textProperty().addListener((observable, oldValue, newValue) -> validateFields(addButton, errorLabel, nameField, mobileField, emailField, roleField, timePickers));
        mobileField.textProperty().addListener((observable, oldValue, newValue) -> validateFields(addButton, errorLabel, nameField, mobileField, emailField, roleField, timePickers));
        emailField.textProperty().addListener((observable, oldValue, newValue) -> validateFields(addButton, errorLabel, nameField, mobileField, emailField, roleField, timePickers));
        roleField.textProperty().addListener((observable, oldValue, newValue) -> validateFields(addButton, errorLabel, nameField, mobileField, emailField, roleField, timePickers));
        for (ComboBox<String> timePicker : timePickers) {
            timePicker.valueProperty().addListener((observable, oldValue, newValue) -> validateFields(addButton, errorLabel, nameField, mobileField, emailField, roleField, timePickers));
        }

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

    private static void validateFields(Button addButton, Label errorLabel, TextField nameField, TextField mobileField, TextField emailField, TextField roleField, List<ComboBox<String>> timePickers) {
        StringBuilder errorMessage = new StringBuilder();
        boolean isNameValid = !nameField.getText().trim().isEmpty();
        boolean isMobileValid = Pattern.matches("\\d{10}", mobileField.getText().trim());
        boolean isEmailValid = Pattern.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", emailField.getText().trim());
        boolean isRoleValid = !roleField.getText().trim().isEmpty();
        boolean areTimesValid = timePickers.stream().allMatch(tp -> tp.getValue() != null);

        if (!isNameValid) {
            errorMessage.append("Name cannot be empty.\n");
        }
        if (!isMobileValid) {
            errorMessage.append("Mobile number must be exactly 10 digits.\n");
        }
        if (!isEmailValid) {
            errorMessage.append("Invalid email format.\n");
        }
        if (!isRoleValid) {
            errorMessage.append("Role cannot be empty.\n");
        }
        if (!areTimesValid) {
            errorMessage.append("Please select all available times.\n");
        }

        errorLabel.setText(errorMessage.toString().trim());
        addButton.setDisable(!(isNameValid && isMobileValid && isEmailValid && isRoleValid && areTimesValid));
    }
}

