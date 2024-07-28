package view.LogsView;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import model.Member;
import util.CRMInteractor;

public class LogsView extends VBox {
    private TableView<Member> table;
    private Button addMemberButton;
    private Button updateMemberButton;
    private Button deleteMemberButton;
    private CRMInteractor interactor;

    public LogsView(CRMInteractor interactor) {
        this.interactor = interactor;
        setSpacing(10);
        setPadding(new Insets(10));

        // Initialize buttons
        addMemberButton = new Button("Add Member");
        updateMemberButton = new Button("Update Member");
        deleteMemberButton = new Button("Delete Member");

        // Create and add the table
        table = new TableView<>();
        table.setItems(interactor.getMembers());

        // Define columns
        TableColumn<Member, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Member, String> mobileColumn = new TableColumn<>("Mobile");
        mobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));

        TableColumn<Member, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Member, String> roleColumn = new TableColumn<>("Role");
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));

        table.getColumns().addAll(nameColumn, mobileColumn, emailColumn, roleColumn);

        // Add buttons and table to layout
        getChildren().addAll(addMemberButton, updateMemberButton, deleteMemberButton, table);
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
}
