package view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import model.Member;

public class RecordsView extends VBox {
    private TableView<Member> table;
    private Button addMemberButton;
    private Button updateMemberButton;
    private Button deleteMemberButton;

    public RecordsView() {
        this.setSpacing(10);
        this.setPadding(new Insets(10));
        this.setStyle("-fx-background-color: lightgray;");

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

        this.getChildren().add(buttonBox);

        // Create and add the table
        table = new TableView<>();

        // Define columns (without logic)
        TableColumn<Member, String> nameColumn = new TableColumn<>("Name");
        TableColumn<Member, String> mobileColumn = new TableColumn<>("Mobile");
        TableColumn<Member, String> emailColumn = new TableColumn<>("Email");
        TableColumn<Member, String> roleColumn = new TableColumn<>("Role");

        table.getColumns().addAll(nameColumn, mobileColumn, emailColumn, roleColumn);

        this.getChildren().add(table);
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
