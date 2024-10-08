//
//package view.EmployeeView;
//
//import javafx.collections.FXCollections;
//import javafx.geometry.Insets;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.ComboBox;
//import javafx.scene.control.Dialog;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.GridPane;
//import model.Employees;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class UpdateEmployeeDialog {
//
//    public static Optional<Employees> showAndWait(Employees employee) {
//        Dialog<Employees> dialog = new Dialog<>();
//        dialog.setTitle("Update Employee");
//
//        ButtonType updateButtonType = new ButtonType("Update", ButtonType.OK.getButtonData());
//        dialog.getDialogPane().getButtonTypes().addAll(updateButtonType, ButtonType.CANCEL);
//
//        GridPane grid = new GridPane();
//        grid.setPadding(new Insets(10));
//        grid.setHgap(10);
//        grid.setVgap(10);
//
//        TextField nameField = new TextField(employee.getName());
//        TextField mobileField = new TextField(employee.getMobile());
//        TextField emailField = new TextField(employee.getEmail());
//        TextField roleField = new TextField(employee.getRole());
//        List<ComboBox<String>> timePickers = new ArrayList<>();
//        List<String> availableTimes = employee.getAvailableTimes();
//        for (int i = 0; i < 5; i++) {
//            ComboBox<String> timePicker = new ComboBox<>(FXCollections.observableArrayList(
//                    "08:00 AM", "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM",
//                    "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM"
//            ));
//            if (i < availableTimes.size()) {
//                timePicker.setValue(availableTimes.get(i));
//            }
//            timePicker.setPromptText("Select Time");
//            timePickers.add(timePicker);
//        }
//
//        grid.add(new javafx.scene.control.Label("Name:"), 0, 0);
//        grid.add(nameField, 1, 0);
//        grid.add(new javafx.scene.control.Label("Mobile:"), 0, 1);
//        grid.add(mobileField, 1, 1);
//        grid.add(new javafx.scene.control.Label("Email:"), 0, 2);
//        grid.add(emailField, 1, 2);
//        grid.add(new javafx.scene.control.Label("Role:"), 0, 3);
//        grid.add(roleField, 1, 3);
//        for (int i = 0; i < 5; i++) {
//            grid.add(new javafx.scene.control.Label("Available Time " + (i + 1) + ":"), 0, 4 + i);
//            grid.add(timePickers.get(i), 1, 4 + i);
//        }
//
//        dialog.getDialogPane().setContent(grid);
//
//        dialog.getDialogPane().lookupButton(updateButtonType).setStyle(
//            "-fx-background-color: #4A148C; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
//        );
//        dialog.getDialogPane().lookupButton(ButtonType.CANCEL).setStyle(
//            "-fx-background-color: #D32F2F; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
//        );
//
//        dialog.setResultConverter(dialogButton -> {
//            if (dialogButton == updateButtonType) {
//                List<String> newAvailableTimes = new ArrayList<>();
//                for (ComboBox<String> timePicker : timePickers) {
//                    newAvailableTimes.add(timePicker.getValue());
//                }
//                return new Employees(
//                        nameField.getText(),
//                        mobileField.getText(),
//                        emailField.getText(),
//                        roleField.getText(),
//                        newAvailableTimes
//                );
//            }
//            return null;
//        });
//
//        return dialog.showAndWait();
//    }
//}
//
//
//


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

public class UpdateEmployeeDialog {

    public static Optional<Employees> showAndWait(Employees employee) {
        Dialog<Employees> dialog = new Dialog<>();
        dialog.setTitle("Update Employee");

        ButtonType updateButtonType = new ButtonType("Update", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(updateButtonType, ButtonType.CANCEL);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        TextField nameField = new TextField(employee.getName());
        TextField mobileField = new TextField(employee.getMobile());
        TextField emailField = new TextField(employee.getEmail());
        TextField roleField = new TextField(employee.getRole());
        List<ComboBox<String>> timePickers = new ArrayList<>();
        List<String> availableTimes = employee.getAvailableTimes();
        for (int i = 0; i < 5; i++) {
            ComboBox<String> timePicker = new ComboBox<>(FXCollections.observableArrayList(
                    "08:00 AM", "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM",
                    "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM"
            ));
            if (i < availableTimes.size()) {
                timePicker.setValue(availableTimes.get(i));
            }
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

        dialog.getDialogPane().lookupButton(updateButtonType).setStyle(
            "-fx-background-color: #4A148C; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
        );
        dialog.getDialogPane().lookupButton(ButtonType.CANCEL).setStyle(
            "-fx-background-color: #D32F2F; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
        );

        // Disable the Update button until all validations are passed
        final Button updateButton = (Button) dialog.getDialogPane().lookupButton(updateButtonType);
        updateButton.setDisable(true);

        // Add listeners to validate fields on the fly
        nameField.textProperty().addListener((observable, oldValue, newValue) -> validateFields(updateButton, errorLabel, nameField, mobileField, emailField, roleField, timePickers));
        mobileField.textProperty().addListener((observable, oldValue, newValue) -> validateFields(updateButton, errorLabel, nameField, mobileField, emailField, roleField, timePickers));
        emailField.textProperty().addListener((observable, oldValue, newValue) -> validateFields(updateButton, errorLabel, nameField, mobileField, emailField, roleField, timePickers));
        roleField.textProperty().addListener((observable, oldValue, newValue) -> validateFields(updateButton, errorLabel, nameField, mobileField, emailField, roleField, timePickers));
        for (ComboBox<String> timePicker : timePickers) {
            timePicker.valueProperty().addListener((observable, oldValue, newValue) -> validateFields(updateButton, errorLabel, nameField, mobileField, emailField, roleField, timePickers));
        }

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == updateButtonType) {
                List<String> newAvailableTimes = new ArrayList<>();
                for (ComboBox<String> timePicker : timePickers) {
                    newAvailableTimes.add(timePicker.getValue());
                }
                return new Employees(
                        nameField.getText(),
                        mobileField.getText(),
                        emailField.getText(),
                        roleField.getText(),
                        newAvailableTimes
                );
            }
            return null;
        });

        return dialog.showAndWait();
    }

    private static void validateFields(Button updateButton, Label errorLabel, TextField nameField, TextField mobileField, TextField emailField, TextField roleField, List<ComboBox<String>> timePickers) {
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
        updateButton.setDisable(!(isNameValid && isMobileValid && isEmailValid && isRoleValid && areTimesValid));
    }
}

