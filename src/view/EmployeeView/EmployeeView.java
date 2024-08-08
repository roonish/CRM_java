package view.EmployeeView;

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
import model.Employees;
import util.EmployeeLogsInteractor;

import java.util.Optional;

public class EmployeeView extends BorderPane {
    private TableView<Employees> table;
    private Button addEmployeeButton;
    private Button updateEmployeeButton;
    private Button deleteEmployeeButton;
    private EmployeeLogsInteractor interactor;

    public EmployeeView(EmployeeLogsInteractor interactor) {
        this.interactor = interactor;

        VBox content = new VBox(20);
        content.setPadding(new Insets(20));
        content.setStyle("-fx-background-color: #f5f5f5;");

        Text title = new Text("Employees");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-fill: black;");

        addEmployeeButton = new Button("Add Employee");
        updateEmployeeButton = new Button("Update Employee");
        deleteEmployeeButton = new Button("Delete Employee");

        addEmployeeButton.setStyle(
            "-fx-background-color: #6A1B9A; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
        );
        updateEmployeeButton.setStyle(
            "-fx-background-color: #6A1B9A; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
        );
        deleteEmployeeButton.setStyle(
            "-fx-background-color: #6A1B9A; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8px;"
        );

        HBox buttonContainer = new HBox(10, addEmployeeButton, updateEmployeeButton, deleteEmployeeButton);
        buttonContainer.setPadding(new Insets(10));
        buttonContainer.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(buttonContainer, Priority.ALWAYS);
        buttonContainer.setMaxWidth(Double.MAX_VALUE);
        HBox.setHgrow(addEmployeeButton, Priority.ALWAYS);
        HBox.setHgrow(updateEmployeeButton, Priority.ALWAYS);
        HBox.setHgrow(deleteEmployeeButton, Priority.ALWAYS);

        table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Employees, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Employees, String> mobileColumn = new TableColumn<>("Mobile");
        mobileColumn.setCellValueFactory(new PropertyValueFactory<>("mobile"));

        TableColumn<Employees, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));

        TableColumn<Employees, String> roleColumn = new TableColumn<>("Role");
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));

        TableColumn<Employees, String> availableTimeColumn = new TableColumn<>("Available Times");
        availableTimeColumn.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(
            cellData.getValue().getAvailableTimesString()));

        table.getColumns().addAll(nameColumn, mobileColumn, emailColumn, roleColumn, availableTimeColumn);

        addEmployeeButton.setOnAction(e -> {
            Optional<Employees> result = AddEmployeerDialog.showAndWait();
            result.ifPresent(member -> {
                interactor.addMember(member);
                refreshTable();
            });
        });

        updateEmployeeButton.setOnAction(e -> {
            Employees selectedMember = table.getSelectionModel().getSelectedItem();
            if (selectedMember != null) {
                Optional<Employees> result = UpdateEmployeeDialog.showAndWait(selectedMember);
                result.ifPresent(updatedMember -> {
                    interactor.updateMember(selectedMember, updatedMember);
                    refreshTable();
                });
            }
        });

        deleteEmployeeButton.setOnAction(e -> {
            Employees selectedMember = table.getSelectionModel().getSelectedItem();
            if (selectedMember != null && ConfirmDialog.show("Delete Employee", "Are you sure you want to delete this employee?")) {
                interactor.deleteMember(selectedMember);
                refreshTable();
            }
        });

        content.getChildren().addAll(title, buttonContainer, table);
        setCenter(content);

        refreshTable();
    }

    private void refreshTable() {
        ObservableList<Employees> members = interactor.getMembers();
        table.setItems(members);
    }
}

