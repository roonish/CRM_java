package view;

import javafx.geometry.Insets;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class OpenView extends VBox {
    public OpenView() {
        this.setSpacing(10);
        this.setPadding(new Insets(10));
        this.setStyle("-fx-background-color: lightgray;");

        Text text = new Text("Open View with Calendar");
        DatePicker datePicker = new DatePicker();

        this.getChildren().addAll(text, datePicker);
    }
}
