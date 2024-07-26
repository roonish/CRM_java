//package view;
//
//import javafx.geometry.Insets;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.Priority;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Text;
//import model.Member;
//
//public class CRMView extends HBox {
//    private VBox contentPane;
//    private Button profileButton;
//    private Button recordsButton;
//    private Button logsButton;
//    private Button openButton;
//    private TableView<Member> table;
//    private Button addMemberButton;
//    private Button updateMemberButton;
//    private Button deleteMemberButton;
//
//    public CRMView() {
//        // Left side menu
//        VBox menu = new VBox();
//        menu.setStyle("-fx-background-color: blue;");
//        menu.setFillWidth(true);
//        menu.setSpacing(10);  // Add spacing between buttons
//        menu.setPadding(new Insets(10)); // Add padding around the menu
//
//        profileButton = new Button("Profile");
//        profileButton.setMaxWidth(Double.MAX_VALUE); // Ensure the button expands to fill the space
//        profileButton.getStyleClass().add("custom-menu-button");
//
//        recordsButton = new Button("Records");
//        recordsButton.setMaxWidth(Double.MAX_VALUE);
//        recordsButton.getStyleClass().add("custom-menu-button");
//
//        logsButton = new Button("Logs");
//        logsButton.setMaxWidth(Double.MAX_VALUE);
//        logsButton.getStyleClass().add("custom-menu-button");
//
//        openButton = new Button("Open");
//        openButton.setMaxWidth(Double.MAX_VALUE);
//        openButton.getStyleClass().add("custom-menu-button");
//
//        menu.getChildren().addAll(profileButton, recordsButton, logsButton, openButton);
//
//        // Ensure buttons are evenly spaced
//        VBox.setVgrow(profileButton, Priority.ALWAYS);
//        VBox.setVgrow(recordsButton, Priority.ALWAYS);
//        VBox.setVgrow(logsButton, Priority.ALWAYS);
//        VBox.setVgrow(openButton, Priority.ALWAYS);
//
//        this.getChildren().add(menu); // Add the menu to the left side
//
//        // Right side content
//        contentPane = new VBox();
//        contentPane.setSpacing(10);
//        contentPane.setPadding(new Insets(10));
//        contentPane.setStyle("-fx-background-color: lightgray;");
//
//        // Title
//        final Text titleText = new Text("Members");
//        titleText.setFill(Color.BLACK);
//        titleText.setStyle("-fx-font: 20 arial;");
//
//        // Create buttons
//        addMemberButton = new Button("Add Member");
//        updateMemberButton = new Button("Update members");
//        deleteMemberButton = new Button("Delete members");
//
//        // Create HBox to hold the buttons
//        HBox buttonBox = new HBox(10); // Spacing between buttons
//        buttonBox.getChildren().addAll(titleText, addMemberButton, updateMemberButton, deleteMemberButton);
//
//        contentPane.getChildren().add(buttonBox);
//
//        // Create and add the table
//        table = new TableView<>();
//
//        // Define columns (without logic)
//        TableColumn<Member, String> nameColumn = new TableColumn<>("Name");
//        TableColumn<Member, String> mobileColumn = new TableColumn<>("Mobile");
//        TableColumn<Member, String> emailColumn = new TableColumn<>("Email");
//        TableColumn<Member, String> roleColumn = new TableColumn<>("Role");
//
//        table.getColumns().addAll(nameColumn, mobileColumn, emailColumn, roleColumn);
//
//        contentPane.getChildren().add(table);
//
//        // Add right side content to the HBox
//        this.getChildren().add(contentPane);
//        HBox.setHgrow(contentPane, Priority.ALWAYS);
//    }
//
//    public VBox getContentPane() {
//        return contentPane;
//    }
//
//    public Button getProfileButton() {
//        return profileButton;
//    }
//
//    public Button getRecordsButton() {
//        return recordsButton;
//    }
//
//    public Button getLogsButton() {
//        return logsButton;
//    }
//
//    public Button getOpenButton() {
//        return openButton;
//    }
//
//    public TableView<Member> getTable() {
//        return table;
//    }
//
//    public Button getAddMemberButton() {
//        return addMemberButton;
//    }
//
//    public Button getUpdateMemberButton() {
//        return updateMemberButton;
//    }
//
//    public Button getDeleteMemberButton() {
//        return deleteMemberButton;
//    }
//
//    public TableColumn<Member, String> getNameColumn() {
//        return (TableColumn<Member, String>) table.getColumns().get(0);
//    }
//
//    public TableColumn<Member, String> getMobileColumn() {
//        return (TableColumn<Member, String>) table.getColumns().get(1);
//    }
//
//    public TableColumn<Member, String> getEmailColumn() {
//        return (TableColumn<Member, String>) table.getColumns().get(2);
//    }
//
//    public TableColumn<Member, String> getRoleColumn() {
//        return (TableColumn<Member, String>) table.getColumns().get(3);
//    }
//}

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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
        menuPane = new VBox(20);
        menuPane.setStyle("-fx-background-color: #6A1B9A;");
        menuPane.setSpacing(20);
        menuPane.setPadding(new Insets(20));

        profileButton = new Button("Profile");
        profileButton.setMaxWidth(Double.MAX_VALUE);
        profileButton.getStyleClass().add("custom-menu-button");

        recordsButton = new Button("Records");
        recordsButton.setMaxWidth(Double.MAX_VALUE);
        recordsButton.getStyleClass().add("custom-menu-button");

        logsButton = new Button("Logs");
        logsButton.setMaxWidth(Double.MAX_VALUE);
        logsButton.getStyleClass().add("custom-menu-button");

        openButton = new Button("Open");
        openButton.setMaxWidth(Double.MAX_VALUE);
        openButton.getStyleClass().add("custom-menu-button");

        menuPane.getChildren().addAll(profileButton, recordsButton, logsButton, openButton);

        // Content pane on the right
        contentPane = new VBox(20);
        contentPane.setSpacing(20);
        contentPane.setPadding(new Insets(20));
        contentPane.setStyle("-fx-background-color: white;");

        // Welcome label for the profile view
        welcomeLabel = new Label("Welcome, User!");
        welcomeLabel.setTextFill(Color.BLACK);
        welcomeLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        // Title for records view
        final Text titleText = new Text("Members");
        titleText.setFill(Color.BLACK);
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 20));

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
        table.getStyleClass().add("table-view");

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
