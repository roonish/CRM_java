package view.LogsView;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Region;
import javafx.util.Callback;
import java.util.Optional;

public class ConfirmDialog {

    public static boolean show(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        // Style the alert dialog
        alert.getDialogPane().setStyle("-fx-background-color: #f5f5f5; -fx-border-color: #d1c4e9; -fx-border-radius: 8px;");
        alert.getDialogPane().getScene().getWindow().getScene().getRoot().setStyle("-fx-background-color: #f5f5f5;");
        
        // Style the buttons
        alert.getDialogPane().lookupButton(ButtonType.OK).setStyle(
            "-fx-background-color: #4A148C; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
        );
        alert.getDialogPane().lookupButton(ButtonType.CANCEL).setStyle(
            "-fx-background-color: #D32F2F; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
        );

        // Center the buttons horizontally
        ButtonBar buttonBar = (ButtonBar) alert.getDialogPane().lookup(".button-bar");
        buttonBar.setStyle("-fx-alignment: center;");
        
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }
}
