package view;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ProfileView extends VBox {
    public ProfileView() {
        Text text = new Text("Profile View");
        this.getChildren().add(text);
    }
}
