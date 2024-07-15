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
       
    }

    private void deleteMember() {
      
    }
}
