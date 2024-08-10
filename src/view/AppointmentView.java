package view;

import util.AppointmentInteractor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Appointments;

import java.time.LocalDate;

public class AppointmentView extends VBox {
    private DatePicker datePicker;
    private ComboBox<String> timePicker;
    private TextField clientNameField;
    private TextField emailField;
    private TextField phoneField;
    private ComboBox<String> appointmentTypeField;
    private TextArea notesField;
    private Button addAppointmentButton;
    private Button editAppointmentButton;
    private Button deleteAppointmentButton;
    private Button markCompletedButton;
    private TableView<Appointments> appointmentTable;
    private ObservableList<Appointments> appointments;
    private AppointmentInteractor interactor;

    public AppointmentView() {
        interactor = new AppointmentInteractor();
        this.setPadding(new Insets(20));
        this.setSpacing(20); // Increased spacing between elements
        this.setStyle("-fx-background-color: #f0f0f0;");

        // Initialize appointments list
        appointments = FXCollections.observableArrayList(interactor.getAllAppointments());

        // Title
        Text title = new Text("Appointments");
        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-fill: black;");

        // Form to add/edit Appointments
        GridPane formPane = new GridPane();
        formPane.setHgap(10);
        formPane.setVgap(15); // Increased vertical gap between rows
        formPane.setPadding(new Insets(20));
        formPane.setStyle("-fx-background-color: white; -fx-border-radius: 8; -fx-background-radius: 8; -fx-border-color: lightgray;");

        // Form fields
        datePicker = new DatePicker();
        timePicker = new ComboBox<>(FXCollections.observableArrayList(
                "08:00 AM", "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM",
                "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM"
        ));
        clientNameField = new TextField();
        emailField = new TextField();
        phoneField = new TextField();
        appointmentTypeField = new ComboBox<>(FXCollections.observableArrayList(
                "Consultation", "Follow-up", "Meeting"
        ));
        notesField = new TextArea();
        notesField.setPrefHeight(60);

        // Set prompt text
        datePicker.setPromptText("Select Date");
        timePicker.setPromptText("Select Time");
        clientNameField.setPromptText("Client Name");
        emailField.setPromptText("Email Address");
        phoneField.setPromptText("Phone Number");
        appointmentTypeField.setPromptText("Select Type");
        notesField.setPromptText("Additional Notes");

        // Adding form fields to the grid with padding
        formPane.add(new Label("Date:"), 0, 0);
        formPane.add(datePicker, 1, 0);
        GridPane.setMargin(datePicker, new Insets(0, 0, 10, 0)); // Margin for spacing between fields

        formPane.add(new Label("Time:"), 0, 1);
        formPane.add(timePicker, 1, 1);
        GridPane.setMargin(timePicker, new Insets(0, 0, 10, 0)); // Margin for spacing between fields

        formPane.add(new Label("Client Name:"), 0, 2);
        formPane.add(clientNameField, 1, 2);
        GridPane.setMargin(clientNameField, new Insets(0, 0, 10, 0)); // Margin for spacing between fields

        formPane.add(new Label("Email:"), 0, 3);
        formPane.add(emailField, 1, 3);
        GridPane.setMargin(emailField, new Insets(0, 0, 10, 0)); // Margin for spacing between fields

        formPane.add(new Label("Phone:"), 0, 4);
        formPane.add(phoneField, 1, 4);
        GridPane.setMargin(phoneField, new Insets(0, 0, 10, 0)); // Margin for spacing between fields

        formPane.add(new Label("Appointment Type:"), 0, 5);
        formPane.add(appointmentTypeField, 1, 5);
        GridPane.setMargin(appointmentTypeField, new Insets(0, 0, 10, 0)); // Margin for spacing between fields

        formPane.add(new Label("Notes:"), 0, 6);
        formPane.add(notesField, 1, 6);

        // Button box
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20, 0, 0, 0)); // Add top padding to the button box

        addAppointmentButton = new Button("Add Appointment");
        editAppointmentButton = new Button("Edit Appointment");
        deleteAppointmentButton = new Button("Delete Appointment");
        markCompletedButton = new Button("Mark as Completed");

        addAppointmentButton.setStyle("-fx-background-color: #6A1B9A; -fx-text-fill: white;");
        editAppointmentButton.setStyle("-fx-background-color: #6A1B9A; -fx-text-fill: white;");
        deleteAppointmentButton.setStyle("-fx-background-color: #6A1B9A; -fx-text-fill: white;");
        markCompletedButton.setStyle("-fx-background-color: #6A1B9A; -fx-text-fill: white;");

        buttonBox.getChildren().addAll(addAppointmentButton, editAppointmentButton, deleteAppointmentButton, markCompletedButton);

        // Adding the button box to the grid
        formPane.add(buttonBox, 0, 7, 2, 1);

        // Table to display appointments
        appointmentTable = new TableView<>(appointments);
        TableColumn<Appointments, String> dateColumn = new TableColumn<>("Date");
        TableColumn<Appointments, String> timeColumn = new TableColumn<>("Time");
        TableColumn<Appointments, String> clientNameColumn = new TableColumn<>("Client Name");
        TableColumn<Appointments, String> emailColumn = new TableColumn<>("Email");
        TableColumn<Appointments, String> phoneColumn = new TableColumn<>("Phone");
        TableColumn<Appointments, String> typeColumn = new TableColumn<>("Appointment Type");
        TableColumn<Appointments, String> notesColumn = new TableColumn<>("Notes");
        TableColumn<Appointments, String> statusColumn = new TableColumn<>("Status");
        TableColumn<Appointments, String> assignedToColumn = new TableColumn<>("Assigned To");
        
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        timeColumn.setCellValueFactory(cellData -> cellData.getValue().timeProperty());
        clientNameColumn.setCellValueFactory(cellData -> cellData.getValue().clientNameProperty());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        typeColumn.setCellValueFactory(cellData -> cellData.getValue().appointmentTypeProperty());
        notesColumn.setCellValueFactory(cellData -> cellData.getValue().notesProperty());
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
        assignedToColumn.setCellValueFactory(cellData -> cellData.getValue().assignedToProperty());


        appointmentTable.getColumns().addAll(dateColumn, timeColumn, clientNameColumn, emailColumn, phoneColumn, typeColumn, notesColumn, statusColumn,assignedToColumn);
        appointmentTable.setStyle("-fx-background-color: white;");

        this.getChildren().addAll(title, formPane, appointmentTable);

        // Add Appointment action
        addAppointmentButton.setOnAction(e -> {
            String date = datePicker.getValue() != null ? datePicker.getValue().toString() : "";
            String time = timePicker.getValue() != null ? timePicker.getValue() : "";
            String clientName = clientNameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String appointmentType = appointmentTypeField.getValue() != null ? appointmentTypeField.getValue() : "";
            String notes = notesField.getText();
            String status = "Scheduled";

            Appointments appointment = new Appointments(date, time, clientName, email, phone, appointmentType, notes, status,"");
            interactor.addAppointment(appointment);
            appointments.add(appointment);

            // Clear form fields after adding appointment
            clearForm();

        });

     // Edit Appointment action
        editAppointmentButton.setOnAction(e -> {
            Appointments selectedAppointment = appointmentTable.getSelectionModel().getSelectedItem();
            if (selectedAppointment != null) {
                selectedAppointment.setDate(datePicker.getValue() != null ? datePicker.getValue().toString() : "");
                selectedAppointment.setTime(timePicker.getValue() != null ? timePicker.getValue() : "");
                selectedAppointment.setClientName(clientNameField.getText());
                selectedAppointment.setEmail(emailField.getText());
                selectedAppointment.setPhone(phoneField.getText());
                selectedAppointment.setAppointmentType(appointmentTypeField.getValue() != null ? appointmentTypeField.getValue() : "");
                selectedAppointment.setNotes(notesField.getText());
                interactor.updateAppointment(selectedAppointment);
                appointmentTable.refresh();

                // Clear form fields after editing appointment
                clearForm();

            }
        });

        // Delete Appointment action
        deleteAppointmentButton.setOnAction(e -> {
            Appointments selectedAppointment = appointmentTable.getSelectionModel().getSelectedItem();
            if (selectedAppointment != null) {
                interactor.deleteAppointment(selectedAppointment);
                appointments.remove(selectedAppointment);
            }
            // Clear form fields after deleting appointment
            clearForm();
        });

        // Mark as Completed action
        markCompletedButton.setOnAction(e -> {
            Appointments selectedAppointment = appointmentTable.getSelectionModel().getSelectedItem();
            if (selectedAppointment != null) {
                selectedAppointment.setStatus("Completed");
                interactor.updateAppointment(selectedAppointment);
                appointmentTable.refresh();
            }
        });

        // Populate form fields when selecting an appointment from the table
        appointmentTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                datePicker.setValue(LocalDate.parse(newValue.getDate()));
                timePicker.setValue(newValue.getTime());
                clientNameField.setText(newValue.getClientName());
                emailField.setText(newValue.getEmail());
                phoneField.setText(newValue.getPhone());
                appointmentTypeField.setValue(newValue.getAppointmentType());
                notesField.setText(newValue.getNotes());
            }
        });
        
    }
    
    public void clearForm() {
   	 // Clear form fields after editing appointment
       datePicker.setValue(null);
       timePicker.setValue(null);
       clientNameField.clear();
       emailField.clear();
       phoneField.clear();
       appointmentTypeField.setValue(null);
       notesField.clear();
   }
}



