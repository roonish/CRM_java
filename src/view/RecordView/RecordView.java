package view.RecordView;

import java.time.LocalDate;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import model.Record;
import util.RecordInteractor;
import view.EmployeeView.ConfirmDialog;

public class RecordView extends VBox {
    // UI components
    private DatePicker datePicker;
    private TextField customerNameField;
    private TextField productNameField;
    private TextField amountField;
    private TextArea notesField;
    private ComboBox<String> planComboBox;
    private Button addRecordButton;
    private Button editRecordButton;
    private Button deleteRecordButton;
    private TableView<Record> recordTable;
    private ObservableList<Record> records;
    private RecordInteractor interactor;
    
    // Constructor
    public RecordView(RecordInteractor interactor) {
        this.interactor = interactor;

        this.setPadding(new Insets(20));
        this.setSpacing(20);
        this.setStyle("-fx-background-color: #f0f0f0;");

        records = FXCollections.observableArrayList();
        
        // Create and style the title
        Text title = new Text("Record Sales Data");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-fill: black;");

        // Create and configure the form pane (grid layout)
        GridPane formPane = new GridPane();
        formPane.setHgap(10);
        formPane.setVgap(15);
        formPane.setPadding(new Insets(20));
        formPane.setStyle("-fx-background-color: white; -fx-border-radius: 8; -fx-background-radius: 8; -fx-border-color: lightgray;");
        
        // Initialize UI components for the form
        datePicker = new DatePicker();
        customerNameField = new TextField();
        productNameField = new TextField();
        amountField = new TextField();
        notesField = new TextArea();
        notesField.setPrefHeight(60);

        // Initialize and configure the plan combo box
        planComboBox = new ComboBox<>();
        planComboBox.setItems(FXCollections.observableArrayList("community", "basic", "standard", "enterprise"));
        planComboBox.setPromptText("Select Plan");

        // Set prompt texts for the form fields
        datePicker.setPromptText("Select Date");
        customerNameField.setPromptText("Enter Customer Name");
        productNameField.setPromptText("Enter Product Name");
        amountField.setPromptText("Enter Amount");
        notesField.setPromptText("Enter Notes");

        // Add form fields and labels to the grid pane
        formPane.add(new Label("Date:"), 0, 0);
        formPane.add(datePicker, 1, 0);
        formPane.add(new Label("Customer Name:"), 0, 1);
        formPane.add(customerNameField, 1, 1);
        formPane.add(new Label("Product Name:"), 0, 2);
        formPane.add(productNameField, 1, 2);
        formPane.add(new Label("Plan:"), 0, 3);
        formPane.add(planComboBox, 1, 3);
        formPane.add(new Label("Amount:"), 0, 4);
        formPane.add(amountField, 1, 4);
        amountField.setEditable(false);
        formPane.add(new Label("Notes:"), 0, 5);
        formPane.add(notesField, 1, 5);

        // Create and configure the button box for action buttons
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20, 0, 0, 0));

        // Initialize action buttons with styles
        addRecordButton = new Button("Add Record");
        editRecordButton = new Button("Edit Record");
        deleteRecordButton = new Button("Delete Record");

        addRecordButton.setStyle("-fx-background-color: #6A1B9A; -fx-text-fill: white;");
        editRecordButton.setStyle("-fx-background-color: #6A1B9A; -fx-text-fill: white;");
        deleteRecordButton.setStyle("-fx-background-color: #6A1B9A; -fx-text-fill: white;");

        buttonBox.getChildren().addAll(addRecordButton, editRecordButton, deleteRecordButton);

        formPane.add(buttonBox, 0, 6, 2, 1);

        recordTable = new TableView<>();
        recordTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Define table columns and map them to Record fields
        TableColumn<Record, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Record, String> customerNameColumn = new TableColumn<>("Customer Name");
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));

        TableColumn<Record, String> productNameColumn = new TableColumn<>("Product Name");
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));

        TableColumn<Record, String> planColumn = new TableColumn<>("Plan");
        planColumn.setCellValueFactory(new PropertyValueFactory<>("plan"));

        TableColumn<Record, String> amountColumn = new TableColumn<>("Amount");
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        TableColumn<Record, String> notesColumn = new TableColumn<>("Notes");
        notesColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));

        // Add columns to the record table
        recordTable.getColumns().addAll(dateColumn, customerNameColumn, productNameColumn, planColumn, amountColumn, notesColumn);
        recordTable.setItems(records);
        recordTable.setStyle("-fx-background-color: white;");

        VBox.setVgrow(recordTable, Priority.ALWAYS);
        recordTable.setMaxWidth(Double.MAX_VALUE);

        this.getChildren().addAll(title, formPane, recordTable);

        // Event handler for plan selection to update the amount field based on the selected plan
        planComboBox.setOnAction(e -> {
            String selectedPlan = planComboBox.getValue();
            if (selectedPlan != null) {
                switch (selectedPlan) {
                    case "community":
                        amountField.setText("100");
                        break;
                    case "basic":
                        amountField.setText("200");
                        break;
                    case "standard":
                        amountField.setText("300");
                        break;
                    case "enterprise":
                        amountField.setText("500");
                        break;
                }
            }
        });

        addRecordButton.setOnAction(e -> {
            String date = datePicker.getValue() != null ? datePicker.getValue().toString() : "";
            String customerName = customerNameField.getText();
            String productName = productNameField.getText();
            String plan = planComboBox.getValue();
            String amount = amountField.getText();
            String notes = notesField.getText();

            Record record = new Record(0, date, customerName, productName, plan, amount, notes);
            interactor.addRecord(record);
            records.add(record);
            clearForm();
        });

        editRecordButton.setOnAction(e -> {
            Record selectedRecord = recordTable.getSelectionModel().getSelectedItem();
            if (selectedRecord != null) {
                Record newRecord = new Record(
                    selectedRecord.getId(),
                    datePicker.getValue() != null ? datePicker.getValue().toString() : "",
                    customerNameField.getText(),
                    productNameField.getText(),
                    planComboBox.getValue(),
                    amountField.getText(),
                    notesField.getText()
                );
                interactor.updateRecord(selectedRecord, newRecord); // Updates the record in the database
                updateRecordInTable(selectedRecord, newRecord); // Refreshes the table view
                clearForm();
            }
        });


        deleteRecordButton.setOnAction(e -> {
            Record selectedRecord = recordTable.getSelectionModel().getSelectedItem();
            if (selectedRecord != null && ConfirmDialog.show("Delete Record", "Are you sure you want to delete this record?")) {
                interactor.deleteRecord(selectedRecord);
                records.remove(selectedRecord);
                clearForm();
            }
        });

        recordTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                populateFormWithSelectedRecord(newSelection);
            }
        });

        // Load records from the database when initializing the view
        loadRecordsFromDatabase();
    }

    private void clearForm() {
        datePicker.setValue(null);
        customerNameField.clear();
        productNameField.clear();
        planComboBox.getSelectionModel().clearSelection();
        amountField.clear();
        notesField.clear();
        recordTable.getSelectionModel().clearSelection();
    }

    private void loadRecordsFromDatabase() {
        // Load existing records from the `records` table
        List<Record> existingRecords = interactor.getAllRecords();
        records.setAll(existingRecords);

        // Fetch new records from `appointments` that are not in `records`
        List<Record> newRecordsFromAppointments = interactor.getAppointmentsNotInRecords();
        for (Record record : newRecordsFromAppointments) {
            // Optionally, you may need to set the plan and amount here based on your business logic.
            // For simplicity, we're adding these records directly.
            records.add(record);
            interactor.addRecord(record);
        }

    }


    private void updateRecordInTable(Record oldRecord, Record newRecord) {
        oldRecord.setDate(newRecord.getDate());
        oldRecord.setCustomerName(newRecord.getCustomerName());
        oldRecord.setProductName(newRecord.getProductName());
        oldRecord.setPlan(newRecord.getPlan());
        oldRecord.setAmount(newRecord.getAmount());
        oldRecord.setNotes(newRecord.getNotes());
        recordTable.refresh(); // Refreshes the TableView to reflect changes
    }

    private void populateFormWithSelectedRecord(Record selectedRecord) {
        datePicker.setValue(LocalDate.parse(selectedRecord.getDate()));
        customerNameField.setText(selectedRecord.getCustomerName());
        productNameField.setText(selectedRecord.getProductName());
        planComboBox.setValue(selectedRecord.getPlan());
        amountField.setText(selectedRecord.getAmount());
        notesField.setText(selectedRecord.getNotes());
    }
}



