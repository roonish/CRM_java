//package view.LogsView;
//
//import javafx.collections.ObservableList;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.Priority;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Text;
//import model.Member;
//import util.CRMInteractor;
//
//import java.util.Optional;
//
//public class LogsView extends BorderPane {
//    private TableView<Member> table;
//    private Button addMemberButton;
//    private Button updateMemberButton;
//    private Button deleteMemberButton;
//    private CRMInteractor interactor;
//
//    public LogsView(CRMInteractor interactor) {
//        this.interactor = interactor;
//
//        VBox content = new VBox(20);
//        content.setPadding(new Insets(20));
//        content.setStyle("-fx-background-color: #f5f5f5;"); // Matching the default theme
//
//        // Title
//        Text title = new Text("Members");
//        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-fill: black;");
//
//        // Initialize buttons
//        addMemberButton = new Button("Add Member");
//        updateMemberButton = new Button("Update Member");
//        deleteMemberButton = new Button("Delete Member");
//
//        // Style buttons
//        addMemberButton.setStyle(
//            "-fx-background-color: #6A1B9A; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
//        );
//        updateMemberButton.setStyle(
//            "-fx-background-color: #6A1B9A; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
//        );
//        deleteMemberButton.setStyle(
//            "-fx-background-color: #6A1B9A; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
//        );
//
//        // Button container with horizontal layout
//        HBox buttonContainer = new HBox(10, addMemberButton, updateMemberButton, deleteMemberButton);
//        buttonContainer.setPadding(new Insets(10));
//        buttonContainer.setAlignment(Pos.CENTER_LEFT);
//
//        // Set HBox to grow horizontally
//        HBox.setHgrow(buttonContainer, Priority.ALWAYS);
//        buttonContainer.setMaxWidth(Double.MAX_VALUE);
//
//        // Ensure buttons expand equally
//        HBox.setHgrow(addMemberButton, Priority.ALWAYS);
//        HBox.setHgrow(updateMemberButton, Priority.ALWAYS);
//        HBox.setHgrow(deleteMemberButton, Priority.ALWAYS);
//
//        // Initialize table
//        table = new TableView<>();
//        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
//
//        TableColumn<Member, String> nameColumn = new TableColumn<>("Name");
//        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//
//        TableColumn<Member, String> mobileColumn = new TableColumn<>("Mobile");
//        mobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));
//
//        TableColumn<Member, String> emailColumn = new TableColumn<>("Email");
//        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
//
//        TableColumn<Member, String> roleColumn = new TableColumn<>("Role");
//        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
//
//        table.getColumns().addAll(nameColumn, mobileColumn, emailColumn, roleColumn);
//
//        // Button actions
//        addMemberButton.setOnAction(e -> {
//            Optional<Member> result = AddMemberDialog.showAndWait();
//            result.ifPresent(member -> {
//                interactor.addMember(member);
//                refreshTable();
//            });
//        });
//
//        updateMemberButton.setOnAction(e -> {
//            Member selectedMember = table.getSelectionModel().getSelectedItem();
//            if (selectedMember != null) {
//                Optional<Member> result = UpdateMembersDialog.showAndWait(selectedMember);
//                result.ifPresent(updatedMember -> {
//                    interactor.updateMember(selectedMember, updatedMember);
//                    refreshTable();
//                });
//            }
//        });
//
//        deleteMemberButton.setOnAction(e -> {
//            Member selectedMember = table.getSelectionModel().getSelectedItem();
//            if (selectedMember != null && ConfirmDialog.show("Delete Member", "Are you sure you want to delete this member?")) {
//                interactor.deleteMember(selectedMember);
//                refreshTable();
//            }
//        });
//
//        content.getChildren().addAll(title, buttonContainer, table);
//        setCenter(content);
//
//        refreshTable();
//    }
//
//    private void refreshTable() {
//        ObservableList<Member> members = interactor.getMembers();
//        table.setItems(members);
//    }
//}

package view.LogsView;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Member;
import util.LogsInteractor;

import java.util.Optional;

public class LogsView extends BorderPane {
    private TableView<Member> table;
    private Button addMemberButton;
    private Button updateMemberButton;
    private Button deleteMemberButton;
    private LogsInteractor interactor;

    public LogsView(LogsInteractor interactor) {
        this.interactor = interactor;

        VBox content = new VBox(20);
        content.setPadding(new Insets(20));
        content.setStyle("-fx-background-color: #f5f5f5;"); // Matching the default theme

        // Title
        Text title = new Text("Members");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-fill: black;");

        // Initialize buttons
        addMemberButton = new Button("Add Member");
        updateMemberButton = new Button("Update Member");
        deleteMemberButton = new Button("Delete Member");

        // Style buttons
        addMemberButton.setStyle(
            "-fx-background-color: #6A1B9A; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
        );
        updateMemberButton.setStyle(
            "-fx-background-color: #6A1B9A; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
        );
        deleteMemberButton.setStyle(
            "-fx-background-color: #6A1B9A; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
        );

        // Button container with horizontal layout
        HBox buttonContainer = new HBox(10, addMemberButton, updateMemberButton, deleteMemberButton);
        buttonContainer.setPadding(new Insets(10));
        buttonContainer.setAlignment(Pos.CENTER_LEFT);

        // Set HBox to grow horizontally
        HBox.setHgrow(buttonContainer, Priority.ALWAYS);
        buttonContainer.setMaxWidth(Double.MAX_VALUE);

        // Ensure buttons expand equally
        HBox.setHgrow(addMemberButton, Priority.ALWAYS);
        HBox.setHgrow(updateMemberButton, Priority.ALWAYS);
        HBox.setHgrow(deleteMemberButton, Priority.ALWAYS);

        // Initialize table
        table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Member, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Member, String> mobileColumn = new TableColumn<>("Mobile");
        mobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));

        TableColumn<Member, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Member, String> roleColumn = new TableColumn<>("Role");
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));

        table.getColumns().addAll(nameColumn, mobileColumn, emailColumn, roleColumn);

        // Button actions
        addMemberButton.setOnAction(e -> {
            Optional<Member> result = AddMemberDialog.showAndWait();
            result.ifPresent(member -> {
                interactor.addMember(member);
                refreshTable();
            });
        });

        updateMemberButton.setOnAction(e -> {
            Member selectedMember = table.getSelectionModel().getSelectedItem();
            if (selectedMember != null) {
                Optional<Member> result = UpdateMembersDialog.showAndWait(selectedMember);
                result.ifPresent(updatedMember -> {
                    interactor.updateMember(selectedMember, updatedMember);
                    refreshTable();
                });
            }
        });

        deleteMemberButton.setOnAction(e -> {
            Member selectedMember = table.getSelectionModel().getSelectedItem();
            if (selectedMember != null && ConfirmDialog.show("Delete Member", "Are you sure you want to delete this member?")) {
                interactor.deleteMember(selectedMember);
                refreshTable();
            }
        });

        content.getChildren().addAll(title, buttonContainer, table);
        setCenter(content);

        refreshTable();
    }

    private void refreshTable() {
        ObservableList<Member> members = interactor.getMembers();
        table.setItems(members);
    }
}
