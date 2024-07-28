package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Member;

public class CRMView extends VBox {
    private VBox menuPane;
    private VBox contentPane;
    private Label welcomeLabel;
    private Button profileButton;
    private Button recordsButton;
    private Button logsButton;
    private Button openButton;
    private TableView<Member> table;
    private Button addMemberButton;
    private Button updateMemberButton;
    private Button deleteMemberButton;

    public CRMView() {
        // Main container
        this.setPadding(new Insets(10));
        this.setSpacing(10);

        // Menu pane on the left
        menuPane = new VBox();
        menuPane.setStyle("-fx-background-color: blue;");
        menuPane.setSpacing(20); // Increased spacing between buttons
        menuPane.setPadding(new Insets(20, 30, 20, 30)); // Added padding inside the VBox (top, right, bottom, left)
        menuPane.setPrefWidth(300); // Set preferred width for the sidebar

        profileButton = new Button("Profile");
        profileButton.setMaxWidth(Double.MAX_VALUE);
        profileButton.setStyle("-fx-background-color: #6A1B9A; -fx-text-fill: white;");
        profileButton.setPadding(new Insets(10, 20, 10, 20)); // Increased padding

        recordsButton = new Button("Records");
        recordsButton.setMaxWidth(Double.MAX_VALUE);
        recordsButton.setStyle("-fx-background-color: #6A1B9A; -fx-text-fill: white;");
        recordsButton.setPadding(new Insets(10, 20, 10, 20)); // Increased padding

        logsButton = new Button("Logs");
        logsButton.setMaxWidth(Double.MAX_VALUE);
        logsButton.setStyle("-fx-background-color: #6A1B9A; -fx-text-fill: white;");
        logsButton.setPadding(new Insets(10, 20, 10, 20)); // Increased padding

        openButton = new Button("Open");
        openButton.setMaxWidth(Double.MAX_VALUE);
        openButton.setStyle("-fx-background-color: #6A1B9A; -fx-text-fill: white;");
        openButton.setPadding(new Insets(10, 20, 10, 20)); // Increased padding

        menuPane.getChildren().addAll(profileButton, recordsButton, logsButton, openButton);

        // Content pane on the right
        contentPane = new VBox();
        contentPane.setSpacing(10);
        contentPane.setPadding(new Insets(10));
        contentPane.setStyle("-fx-background-color: lightgray;");

        // Welcome label for the profile view
        welcomeLabel = new Label("Welcome, User!");
        welcomeLabel.setTextFill(Color.BLACK);
        welcomeLabel.setStyle("-fx-font: 20 arial;");

        // Title for records view
        final Text titleText = new Text("Members");
        titleText.setFill(Color.BLACK);
        titleText.setStyle("-fx-font: 20 arial;");

        // Create buttons
        addMemberButton = new Button("Add Member");
        updateMemberButton = new Button("Update Member");
        deleteMemberButton = new Button("Delete Member");

        // Create HBox to hold the buttons
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(addMemberButton, updateMemberButton, deleteMemberButton);

        // Create and add the table
        table = new TableView<>();

        // Define columns
        TableColumn<Member, String> nameColumn = new TableColumn<>("Name");
        TableColumn<Member, String> mobileColumn = new TableColumn<>("Mobile");
        TableColumn<Member, String> emailColumn = new TableColumn<>("Email");
        TableColumn<Member, String> roleColumn = new TableColumn<>("Role");

        table.getColumns().addAll(nameColumn, mobileColumn, emailColumn, roleColumn);
        table.setStyle("-fx-background-color: #6A1B9A; -fx-text-fill: white;");

        // Add elements to content pane
        contentPane.getChildren().addAll(titleText, buttonBox, table);

        // Main layout
        HBox mainLayout = new HBox();
        mainLayout.getChildren().addAll(menuPane, contentPane);
        HBox.setHgrow(contentPane, Priority.ALWAYS);

        this.getChildren().add(mainLayout);
    }

    public void setWelcomeMessage(String message) {
        welcomeLabel.setText(message);
    }

    public VBox getContentPane() {
        return contentPane;
    }

    public Button getProfileButton() {
        return profileButton;
    }

    public Button getRecordsButton() {
        return recordsButton;
    }

    public Button getLogsButton() {
        return logsButton;
    }

    public Button getOpenButton() {
        return openButton;
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
