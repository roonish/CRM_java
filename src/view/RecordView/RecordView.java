package view.RecordView;

import java.time.LocalDate;

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

public class RecordView extends VBox {
    private DatePicker datePicker;
    private TextField customerNameField;
    private TextField productNameField;
    private TextField amountField;
    private TextArea notesField;
    private Button addRecordButton;
    private Button editRecordButton;
    private Button deleteRecordButton;
    private TableView<Record> recordTable;
    private ObservableList<Record> records;
    private RecordInteractor interactor;

    public RecordView(RecordInteractor interactor) {
        this.interactor = interactor;

        this.setPadding(new Insets(20));
        this.setSpacing(20); // Increased spacing between elements
        this.setStyle("-fx-background-color: #f0f0f0;");

        // Initialize records list
        records = FXCollections.observableArrayList();

        // Title
        Text title = new Text("Record Sales Data");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-fill: black;");

        // Form to add/edit record
        GridPane formPane = new GridPane();
        formPane.setHgap(10);
        formPane.setVgap(15); // Increased vertical gap between rows
        formPane.setPadding(new Insets(20));
        formPane.setStyle("-fx-background-color: white; -fx-border-radius: 8; -fx-background-radius: 8; -fx-border-color: lightgray;");

        // Form fields
        datePicker = new DatePicker();
        customerNameField = new TextField();
        productNameField = new TextField();
        amountField = new TextField();
        notesField = new TextArea();
        notesField.setPrefHeight(60);

        // Set prompt text
        datePicker.setPromptText("Select Date");
        customerNameField.setPromptText("Enter Customer Name");
        productNameField.setPromptText("Enter Product Name");
        amountField.setPromptText("Enter Amount");
        notesField.setPromptText("Enter Notes");

        // Adding form fields to the grid with padding
        formPane.add(new Label("Date:"), 0, 0);
        formPane.add(datePicker, 1, 0);
        GridPane.setMargin(datePicker, new Insets(0, 0, 10, 0)); // Margin for spacing between fields

        formPane.add(new Label("Customer Name:"), 0, 1);
        formPane.add(customerNameField, 1, 1);
        GridPane.setMargin(customerNameField, new Insets(0, 0, 10, 0)); // Margin for spacing between fields

        formPane.add(new Label("Product Name:"), 0, 2);
        formPane.add(productNameField, 1, 2);
        GridPane.setMargin(productNameField, new Insets(0, 0, 10, 0)); // Margin for spacing between fields

        formPane.add(new Label("Amount:"), 0, 3);
        formPane.add(amountField, 1, 3);
        GridPane.setMargin(amountField, new Insets(0, 0, 10, 0)); // Margin for spacing between fields

        formPane.add(new Label("Notes:"), 0, 4);
        formPane.add(notesField, 1, 4);

        // Button box
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20, 0, 0, 0)); // Add top padding to the button box

        addRecordButton = new Button("Add Record");
        editRecordButton = new Button("Edit Record");
        deleteRecordButton = new Button("Delete Record");

        addRecordButton.setStyle("-fx-background-color: #6A1B9A; -fx-text-fill: white;");
        editRecordButton.setStyle("-fx-background-color: #6A1B9A; -fx-text-fill: white;");
        deleteRecordButton.setStyle("-fx-background-color: #6A1B9A; -fx-text-fill: white;");

        buttonBox.getChildren().addAll(addRecordButton, editRecordButton, deleteRecordButton);

        // Adding the button box to the grid
        formPane.add(buttonBox, 0, 5, 2, 1);

        // Table to display records
        recordTable = new TableView<>();
        recordTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Record, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Record, String> customerNameColumn = new TableColumn<>("Customer Name");
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));

        TableColumn<Record, String> productNameColumn = new TableColumn<>("Product Name");
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));

        TableColumn<Record, String> amountColumn = new TableColumn<>("Amount");
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        TableColumn<Record, String> notesColumn = new TableColumn<>("Notes");
        notesColumn.setCellValueFactory(new PropertyValueFactory<>("notes"));

        recordTable.getColumns().addAll(dateColumn, customerNameColumn, productNameColumn, amountColumn, notesColumn);
        recordTable.setItems(records);
        recordTable.setStyle("-fx-background-color: white;");

        // Set table to expand fully
        VBox.setVgrow(recordTable, Priority.ALWAYS);
        recordTable.setMaxWidth(Double.MAX_VALUE);

        // Adding elements to the main content container
        this.getChildren().addAll(title, formPane, recordTable);

        // Add record action
        addRecordButton.setOnAction(e -> {
            String date = datePicker.getValue() != null ? datePicker.getValue().toString() : "";
            String customerName = customerNameField.getText();
            String productName = productNameField.getText();
            String amount = amountField.getText();
            String notes = notesField.getText();

            Record record = new Record(0, date, customerName, productName, amount, notes); // id will be set by the DB
            interactor.addRecord(record);
            records.add(record);
            clearForm();
        });

        // Edit record action
        editRecordButton.setOnAction(e -> {
            Record selectedRecord = recordTable.getSelectionModel().getSelectedItem();
            if (selectedRecord != null) {
                Record newRecord = new Record(
                        selectedRecord.getId(),
                        datePicker.getValue() != null ? datePicker.getValue().toString() : "",
                        customerNameField.getText(),
                        productNameField.getText(),
                        amountField.getText(),
                        notesField.getText()
                );
                interactor.updateRecord(selectedRecord, newRecord);
                selectedRecord.setDate(newRecord.getDate());
                selectedRecord.setCustomerName(newRecord.getCustomerName());
                selectedRecord.setProductName(newRecord.getProductName());
                selectedRecord.setAmount(newRecord.getAmount());
                selectedRecord.setNotes(newRecord.getNotes());
                recordTable.refresh();
                clearForm();
            }
        });

        // Delete record action
        deleteRecordButton.setOnAction(e -> {
            Record selectedRecord = recordTable.getSelectionModel().getSelectedItem();
            if (selectedRecord != null) {
                interactor.deleteRecord(selectedRecord);
                records.remove(selectedRecord);
                clearForm();
            }
        });

        // Handle table row selection to populate form fields
        recordTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                datePicker.setValue(LocalDate.parse(newSelection.getDate()));
                customerNameField.setText(newSelection.getCustomerName());
                productNameField.setText(newSelection.getProductName());
                amountField.setText(newSelection.getAmount());
                notesField.setText(newSelection.getNotes());
            }
        });

        // Load records from database
        loadRecordsFromDatabase();
    }

    private void loadRecordsFromDatabase() {
        records.setAll(interactor.getRecords());
    }

    private void clearForm() {
        datePicker.setValue(null);
        customerNameField.clear();
        productNameField.clear();
        amountField.clear();
        notesField.clear();
    }
}
