package application;

import java.util.Optional;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CRMController {
    private CRMView view;
    private CRMInteractor interactor;

    public CRMController() {
        view = new CRMView();
        interactor = new CRMInteractor(); // Instantiate the interactor
        initializeUI();
        initializeActions();
    }

    public CRMView getView() {
        return view;
    }

    private void initializeUI() {
        // Set up table and columns
        TableView<Member> table = view.getTable();
        table.setItems(interactor.getMembers());

        TableColumn<Member, String> nameColumn = view.getNameColumn();
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Member, String> mobileColumn = view.getMobileColumn();
        mobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));

        TableColumn<Member, String> emailColumn = view.getEmailColumn();
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Member, String> roleColumn = view.getRoleColumn();
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
    }

    private void initializeActions() {
        view.getAddMemberButton().setOnAction(event -> addNewMember());
        view.getUpdateMemberButton().setOnAction(event -> updateMember());
        view.getDeleteMemberButton().setOnAction(event -> deleteMember());
    }
    
    private void addNewMember() {
        Optional<Member> result = AddMemberView.showAndWait();
        result.ifPresent(member -> {
            interactor.addMember(member);
        });
    }


    private void updateMember() {
        // Get the selected member from the table
        Member selectedMember = view.getTable().getSelectionModel().getSelectedItem();
        if (selectedMember == null) {
            // If no member is selected, show an error message 
            return;
        }

        // Show dialog to edit member details
        Optional<Member> result = UpdateMemberDialog.showAndWait(selectedMember);
        result.ifPresent(updatedMember -> {
            // Update the member in the interactor
            interactor.updateMember(selectedMember, updatedMember);

            // Optionally, update the UI (not always necessary if bindings are used)
            view.getTable().refresh(); // Refresh the table to reflect changes
        });
    }

    private void deleteMember() {
        // Get the selected member from the table
        Member selectedMember = view.getTable().getSelectionModel().getSelectedItem();
        if (selectedMember == null) {
            // If no member is selected, show an error message 
            return;
        }

        // Confirm deletion with a dialog (optional)
        boolean confirmed = ConfirmationDialog.show("Delete Member", "Are you sure you want to delete this member?");
        if (!confirmed) {
            return; // User canceled deletion
        }

        // Remove the member from the interactor
        interactor.deleteMember(selectedMember);

        // Remove from the UI (the table will reflect changes due to being bound to the ObservableList)
    }

}
