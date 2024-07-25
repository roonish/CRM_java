package view;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class LogsView extends VBox {
    public LogsView() {
        Text text = new Text("Logs View");
        this.getChildren().add(text);
    }
}
