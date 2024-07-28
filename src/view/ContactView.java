package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class ContactView extends BorderPane {
    public ContactView() {
        setPadding(new Insets(10));

        Text contactsTitle = new Text("Contacts");
        contactsTitle.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        // Placeholder for contacts content
        Text contactsContent = new Text("This is where the contacts will be displayed.");

        setTop(contactsTitle);
        setCenter(contactsContent);
        BorderPane.setAlignment(contactsTitle, Pos.CENTER);
        BorderPane.setMargin(contactsTitle, new Insets(10, 0, 10, 0));
    }
}
