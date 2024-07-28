package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class AppointmentView extends BorderPane {
    public AppointmentView() {
        setPadding(new Insets(10));

        Text appointmentsTitle = new Text("Appointments");
        appointmentsTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // Placeholder for appointments content
        Text appointmentsContent = new Text("This is where the appointments will be displayed.");

        setTop(appointmentsTitle);
        setCenter(appointmentsContent);
        BorderPane.setAlignment(appointmentsTitle, Pos.CENTER);
        BorderPane.setMargin(appointmentsTitle, new Insets(10, 0, 10, 0));
    }
}
