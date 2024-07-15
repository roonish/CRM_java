package application;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class CRMView extends HBox {
    private TableView<Member> table;
    private Button addMemberButton;
    private Button updateMemberButton;
    private Button deleteMemberButton;

    public CRMView() {
        // Left side menu
        VBox menu = new VBox();
        menu.setStyle("-fx-background-color: blue;");
        menu.setFillWidth(true);
        menu.setSpacing(10);  // Add spacing between buttons
        menu.setPadding(new Insets(10)); // Add padding around the menu

        Button profileBtn = new Button("Profile");
        profileBtn.setMaxWidth(Double.MAX_VALUE); // Ensure the button expands to fill the space
        profileBtn.getStyleClass().add("custom-menu-button");

        Button recordsBtn = new Button("Records");
        recordsBtn.setMaxWidth(Double.MAX_VALUE);
        recordsBtn.getStyleClass().add("custom-menu-button");

        Button logsBtn = new Button("Logs");
        logsBtn.setMaxWidth(Double.MAX_VALUE);
        logsBtn.getStyleClass().add("custom-menu-button");

        Button openBtn = new Button("Open");
        openBtn.setMaxWidth(Double.MAX_VALUE);
        openBtn.getStyleClass().add("custom-menu-button");

        menu.getChildren().addAll(profileBtn, recordsBtn, logsBtn, openBtn);

        // Ensure buttons are evenly spaced
        VBox.setVgrow(profileBtn, Priority.ALWAYS);
        VBox.setVgrow(recordsBtn, Priority.ALWAYS);
        VBox.setVgrow(logsBtn, Priority.ALWAYS);
        VBox.setVgrow(openBtn, Priority.ALWAYS);

        this.getChildren().add(menu); // Add the menu to the left side

        // Right side content
        VBox rightSide = new VBox();
        rightSide.setSpacing(10);
        rightSide.setPadding(new Insets(10));
        rightSide.setStyle("-fx-background-color: lightgray;");

        // Title
        final Text titleText = new Text("Members");
        titleText.setFill(Color.BLACK);
        titleText.setStyle("-fx-font: 20 arial;");

        // Create buttons
        addMemberButton = new Button("Add Member");
        updateMemberButton = new Button("Update members");
        deleteMemberButton = new Button("Delete members");

        // Create HBox to hold the buttons
        HBox buttonBox = new HBox(10); // Spacing between buttons
        buttonBox.getChildren().addAll(titleText, addMemberButton, updateMemberButton, deleteMemberButton);

        rightSide.getChildren().add(buttonBox);

        // Create and add the table
        table = new TableView<>();

        // Define columns (without logic)
        TableColumn<Member, String> nameColumn = new TableColumn<>("Name");
        TableColumn<Member, String> mobileColumn = new TableColumn<>("Mobile");
        TableColumn<Member, String> emailColumn = new TableColumn<>("Email");
        TableColumn<Member, String> roleColumn = new TableColumn<>("Role");

        table.getColumns().addAll(nameColumn, mobileColumn, emailColumn, roleColumn);

        rightSide.getChildren().add(table);

        // Add right side content to the HBox
        this.getChildren().add(rightSide);
        HBox.setHgrow(rightSide, Priority.ALWAYS);
    }

    public TableView<Member> getTable() {
        return table;
    }

    public Button getAddMemberButton() {
        return addMemberButton;
    }

    public Button getUpdateMemberButton() {
        return updateMemberButton;
    }

    public Button getDeleteMemberButton() {
        return deleteMemberButton;
    }

    public TableColumn<Member, String> getNameColumn() {
        return (TableColumn<Member, String>) table.getColumns().get(0);
    }

    public TableColumn<Member, String> getMobileColumn() {
        return (TableColumn<Member, String>) table.getColumns().get(1);
    }

    public TableColumn<Member, String> getEmailColumn() {
        return (TableColumn<Member, String>) table.getColumns().get(2);
    }

    public TableColumn<Member, String> getRoleColumn() {
        return (TableColumn<Member, String>) table.getColumns().get(3);
    }
}
