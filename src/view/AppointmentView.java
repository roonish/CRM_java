//package view;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.control.*;
//import javafx.scene.layout.*;
//import javafx.scene.text.Text;
//import model.Appointments;
//
//import java.time.LocalDate;
//
//public class AppointmentView extends VBox {
//    private DatePicker datePicker;
//    private ComboBox<String> timePicker;
//    private TextField clientNameField;
//    private TextField emailField;
//    private TextField phoneField;
//    private ComboBox<String> appointmentTypeField;
//    private TextArea notesField;
//    private Button addAppointmentButton;
//    private Button editAppointmentButton;
//    private Button deleteAppointmentButton;
//    private Button markCompletedButton;
//    private TableView<Appointments> appointmentTable;
//    private ObservableList<Appointments> appointments;
//
//    public AppointmentView() {
//        this.setPadding(new Insets(20));
//        this.setSpacing(20); // Increased spacing between elements
//        this.setStyle("-fx-background-color: #f0f0f0;");
//
//        // Initialize appointments list
//        appointments = FXCollections.observableArrayList();
//
//        // Title
//        Text title = new Text("Appointments");
//        title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-fill: black;");
//
//        // Form to add/edit Appointments
//        GridPane formPane = new GridPane();
//        formPane.setHgap(10);
//        formPane.setVgap(15); // Increased vertical gap between rows
//        formPane.setPadding(new Insets(20));
//        formPane.setStyle("-fx-background-color: white; -fx-border-radius: 8; -fx-background-radius: 8; -fx-border-color: lightgray;");
//
//        // Form fields
//        datePicker = new DatePicker();
//        timePicker = new ComboBox<>(FXCollections.observableArrayList(
//                "08:00 AM", "09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM",
//                "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM"
//        ));
//        clientNameField = new TextField();
//        emailField = new TextField();
//        phoneField = new TextField();
//        appointmentTypeField = new ComboBox<>(FXCollections.observableArrayList(
//                "Consultation", "Follow-up", "Meeting"
//        ));
//        notesField = new TextArea();
//        notesField.setPrefHeight(60);
//
//        // Set prompt text
//        datePicker.setPromptText("Select Date");
//        timePicker.setPromptText("Select Time");
//        clientNameField.setPromptText("Client Name");
//        emailField.setPromptText("Email Address");
//        phoneField.setPromptText("Phone Number");
//        appointmentTypeField.setPromptText("Select Type");
//        notesField.setPromptText("Additional Notes");
//
//        // Adding form fields to the grid with padding
//        formPane.add(new Label("Date:"), 0, 0);
//        formPane.add(datePicker, 1, 0);
//        GridPane.setMargin(datePicker, new Insets(0, 0, 10, 0)); // Margin for spacing between fields
//
//        formPane.add(new Label("Time:"), 0, 1);
//        formPane.add(timePicker, 1, 1);
//        GridPane.setMargin(timePicker, new Insets(0, 0, 10, 0)); // Margin for spacing between fields
//
//        formPane.add(new Label("Client Name:"), 0, 2);
//        formPane.add(clientNameField, 1, 2);
//        GridPane.setMargin(clientNameField, new Insets(0, 0, 10, 0)); // Margin for spacing between fields
//
//        formPane.add(new Label("Email:"), 0, 3);
//        formPane.add(emailField, 1, 3);
//        GridPane.setMargin(emailField, new Insets(0, 0, 10, 0)); // Margin for spacing between fields
//
//        formPane.add(new Label("Phone:"), 0, 4);
//        formPane.add(phoneField, 1, 4);
//        GridPane.setMargin(phoneField, new Insets(0, 0, 10, 0)); // Margin for spacing between fields
//
//        formPane.add(new Label("Appointments Type:"), 0, 5);
//        formPane.add(appointmentTypeField, 1, 5);
//        GridPane.setMargin(appointmentTypeField, new Insets(0, 0, 10, 0)); // Margin for spacing between fields
//
//        formPane.add(new Label("Notes:"), 0, 6);
//        formPane.add(notesField, 1, 6);
//
//        // Button box
//        HBox buttonBox = new HBox(10);
//        buttonBox.setAlignment(Pos.CENTER);
//        buttonBox.setPadding(new Insets(20, 0, 0, 0)); // Add top padding to the button box
//
//        addAppointmentButton = new Button("Add Appointments");
//        editAppointmentButton = new Button("Edit Appointments");
//        deleteAppointmentButton = new Button("Delete Appointments");
//        markCompletedButton = new Button("Mark as Completed");
//
//        addAppointmentButton.setStyle("-fx-background-color: #6A1B9A; -fx-text-fill: white;");
//        editAppointmentButton.setStyle("-fx-background-color: #6A1B9A; -fx-text-fill: white;");
//        deleteAppointmentButton.setStyle("-fx-background-color: #6A1B9A; -fx-text-fill: white;");
//        markCompletedButton.setStyle("-fx-background-color: #6A1B9A; -fx-text-fill: white;");
//
//        buttonBox.getChildren().addAll(addAppointmentButton, editAppointmentButton, deleteAppointmentButton, markCompletedButton);
//
//        // Adding the button box to the grid
//        formPane.add(buttonBox, 0, 7, 2, 1);
//
//        // Table to display appointments
//        appointmentTable = new TableView<>();
//        TableColumn<Appointments, String> dateColumn = new TableColumn<>("Date");
//        TableColumn<Appointments, String> timeColumn = new TableColumn<>("Time");
//        TableColumn<Appointments, String> clientNameColumn = new TableColumn<>("Client Name");
//        TableColumn<Appointments, String> emailColumn = new TableColumn<>("Email");
//        TableColumn<Appointments, String> phoneColumn = new TableColumn<>("Phone");
//        TableColumn<Appointments, String> typeColumn = new TableColumn<>("Type");
//        TableColumn<Appointments, String> notesColumn = new TableColumn<>("Notes");
//        TableColumn<Appointments, String> statusColumn = new TableColumn<>("Status");
//
//        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
//        timeColumn.setCellValueFactory(cellData -> cellData.getValue().timeProperty());
//        clientNameColumn.setCellValueFactory(cellData -> cellData.getValue().clientNameProperty());
//        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
//        phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
//        typeColumn.setCellValueFactory(cellData -> cellData.getValue().appointmentTypeProperty());
//        notesColumn.setCellValueFactory(cellData -> cellData.getValue().notesProperty());
//        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
//
//        appointmentTable.getColumns().addAll(dateColumn, timeColumn, clientNameColumn, emailColumn, phoneColumn, typeColumn, notesColumn, statusColumn);
//        appointmentTable.setItems(appointments);
//        appointmentTable.setStyle("-fx-background-color: white;");
//
//        this.getChildren().addAll(title, formPane, appointmentTable);
//
//        // Add Appointments action
//        addAppointmentButton.setOnAction(e -> {
//            String date = datePicker.getValue() != null ? datePicker.getValue().toString() : "";
//            String time = timePicker.getValue() != null ? timePicker.getValue() : "";
//            String clientName = clientNameField.getText();
//            String email = emailField.getText();
//            String phone = phoneField.getText();
//            String appointmentType = appointmentTypeField.getValue() != null ? appointmentTypeField.getValue() : "";
//            String notes = notesField.getText();
//            String status = "Scheduled";
//
//            Appointments Appointments = new Appointments(date, time, clientName, email, phone, appointmentType, notes, status);
//            appointments.add(Appointments);
//
//            // Clear form fields after adding Appointments
//            datePicker.setValue(null);
//            timePicker.setValue(null);
//            clientNameField.clear();
//            emailField.clear();
//            phoneField.clear();
//            appointmentTypeField.setValue(null);
//            notesField.clear();
//        });
//
//        // Edit Appointments action
//        editAppointmentButton.setOnAction(e -> {
//            Appointments selectedAppointment = appointmentTable.getSelectionModel().getSelectedItem();
//            if (selectedAppointment != null) {
//                selectedAppointment.setDate(datePicker.getValue() != null ? datePicker.getValue().toString() : "");
//                selectedAppointment.setTime(timePicker.getValue() != null ? timePicker.getValue() : "");
//                selectedAppointment.setClientName(clientNameField.getText());
//                selectedAppointment.setEmail(emailField.getText());
//                selectedAppointment.setPhone(phoneField.getText());
//                selectedAppointment.setAppointmentType(appointmentTypeField.getValue() != null ? appointmentTypeField.getValue() : "");
//                selectedAppointment.setNotes(notesField.getText());
//                appointmentTable.refresh();
//            }
//        });
//
//        // Delete Appointments action
//        deleteAppointmentButton.setOnAction(e -> {
//            Appointments selectedAppointment = appointmentTable.getSelectionModel().getSelectedItem();
//            if (selectedAppointment != null) {
//                appointments.remove(selectedAppointment);
//            }
//        });
//
//        // Mark as completed action
//        markCompletedButton.setOnAction(e -> {
//            Appointments selectedAppointment = appointmentTable.getSelectionModel().getSelectedItem();
//            if (selectedAppointment != null) {
//                selectedAppointment.setStatus("Completed");
//                appointmentTable.refresh();
//            }
//        });
//
//        // Handle table row selection to populate form fields
//        appointmentTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
//            if (newSelection != null) {
//                datePicker.setValue(newSelection.getDate() != null ? LocalDate.parse(newSelection.getDate()) : null);
//                timePicker.setValue(newSelection.getTime());
//                clientNameField.setText(newSelection.getClientName());
//                emailField.setText(newSelection.getEmail());
//                phoneField.setText(newSelection.getPhone());
//                appointmentTypeField.setValue(newSelection.getAppointmentType());
//                notesField.setText(newSelection.getNotes());
//            }
//        });
//    }
//}



package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import model.Appointments;
import util.Connectivity;

import java.sql.*;
import java.time.LocalDate;

public class AppointmentView extends VBox {
    private final DatePicker datePicker = new DatePicker();
    private final ComboBox<String> timePicker = new ComboBox<>();
    private final TextField clientNameField = new TextField();
    private final TextField emailField = new TextField();
    private final TextField phoneField = new TextField();
    private final ComboBox<String> appointmentTypeField = new ComboBox<>();
    private final TextArea notesField = new TextArea();
    private final Button addAppointmentButton = new Button("Add Appointment");
    private final Button editAppointmentButton = new Button("Edit Appointment");
    private final Button deleteAppointmentButton = new Button("Delete Appointment");
    private final Button markCompletedButton = new Button("Mark as Completed");
    private final TableView<Appointments> appointmentTable = new TableView<>();
    private final ObservableList<Appointments> appointments = FXCollections.observableArrayList();

    public AppointmentView() {
        setupLayout();
        setupTable();
        loadAppointmentsFromDatabase();

        addAppointmentButton.setOnAction(e -> addAppointment());
        editAppointmentButton.setOnAction(e -> editAppointment());
        deleteAppointmentButton.setOnAction(e -> deleteAppointment());
        markCompletedButton.setOnAction(e -> markCompleted());

        appointmentTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                datePicker.setValue(newSelection.getDate() != null ? LocalDate.parse(newSelection.getDate()) : null);
                timePicker.setValue(newSelection.getTime());
                clientNameField.setText(newSelection.getClientName());
                emailField.setText(newSelection.getEmail());
                phoneField.setText(newSelection.getPhone());
                appointmentTypeField.setValue(newSelection.getAppointmentType());
                notesField.setText(newSelection.getNotes());
            }
        });
    }

    private void setupLayout() {
        // Define the layout and add components
        HBox formBox = new HBox(10, new VBox(10, new Label("Date:"), datePicker),
                                     new VBox(10, new Label("Time:"), timePicker),
                                     new VBox(10, new Label("Client Name:"), clientNameField),
                                     new VBox(10, new Label("Email:"), emailField),
                                     new VBox(10, new Label("Phone:"), phoneField),
                                     new VBox(10, new Label("Type:"), appointmentTypeField),
                                     new VBox(10, new Label("Notes:"), notesField));
        formBox.setAlignment(Pos.CENTER);
        formBox.setPadding(new Insets(10));

        HBox buttonBox = new HBox(10, addAppointmentButton, editAppointmentButton, deleteAppointmentButton, markCompletedButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(10));

        VBox mainLayout = new VBox(10, formBox, buttonBox, appointmentTable);
        mainLayout.setPadding(new Insets(10));
        mainLayout.setAlignment(Pos.CENTER);
        this.getChildren().add(mainLayout);

        // Populate the ComboBox fields
        timePicker.getItems().addAll("09:00 AM", "10:00 AM", "11:00 AM", "12:00 PM", "01:00 PM", "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM");
        appointmentTypeField.getItems().addAll("Consultation", "Follow-up", "Routine Check-up", "Emergency");
    }

    private void setupTable() {
        TableColumn<Appointments, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());

        TableColumn<Appointments, String> timeColumn = new TableColumn<>("Time");
        timeColumn.setCellValueFactory(cellData -> cellData.getValue().timeProperty());

        TableColumn<Appointments, String> clientNameColumn = new TableColumn<>("Client Name");
        clientNameColumn.setCellValueFactory(cellData -> cellData.getValue().clientNameProperty());

        TableColumn<Appointments, String> emailColumn = new TableColumn<>("Email");
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());

        TableColumn<Appointments, String> phoneColumn = new TableColumn<>("Phone");
        phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());

        TableColumn<Appointments, String> appointmentTypeColumn = new TableColumn<>("Type");
        appointmentTypeColumn.setCellValueFactory(cellData -> cellData.getValue().appointmentTypeProperty());

        TableColumn<Appointments, String> notesColumn = new TableColumn<>("Notes");
        notesColumn.setCellValueFactory(cellData -> cellData.getValue().notesProperty());

        TableColumn<Appointments, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());

        appointmentTable.getColumns().addAll(dateColumn, timeColumn, clientNameColumn, emailColumn, phoneColumn, appointmentTypeColumn, notesColumn, statusColumn);
        appointmentTable.setItems(appointments);
    }

    private void loadAppointmentsFromDatabase() {
        Connectivity connectivity = new Connectivity();
        Connection connection = connectivity.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM appointments");

            while (resultSet.next()) {
                Appointments appointment = new Appointments(
                        resultSet.getInt("id"), // Add the id field here
                        resultSet.getString("date"),
                        resultSet.getString("time"),
                        resultSet.getString("clientName"),
                        resultSet.getString("email"),
                        resultSet.getString("phone"),
                        resultSet.getString("appointmentType"),
                        resultSet.getString("notes"),
                        resultSet.getString("status")
                );
                appointments.add(appointment);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addAppointment() {
        String date = datePicker.getValue() != null ? datePicker.getValue().toString() : "";
        String time = timePicker.getValue() != null ? timePicker.getValue() : "";
        String clientName = clientNameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        String appointmentType = appointmentTypeField.getValue() != null ? appointmentTypeField.getValue() : "";
        String notes = notesField.getText();
        String status = "Scheduled";

        Connectivity connectivity = new Connectivity();
        Connection connection = connectivity.getConnection();

        try {
            String query = "INSERT INTO appointments (date, time, clientName, email, phone, appointmentType, notes, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, time);
            preparedStatement.setString(3, clientName);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, phone);
            preparedStatement.setString(6, appointmentType);
            preparedStatement.setString(7, notes);
            preparedStatement.setString(8, status);
            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            int id = 0;
            if (rs.next()) {
                id = rs.getInt(1);
            }

            Appointments appointment = new Appointments(id, date, time, clientName, email, phone, appointmentType, notes, status);
            appointments.add(appointment);

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        datePicker.setValue(null);
        timePicker.setValue(null);
        clientNameField.clear();
        emailField.clear();
        phoneField.clear();
        appointmentTypeField.setValue(null);
        notesField.clear();
    }

    private void editAppointment() {
        Appointments selectedAppointment = appointmentTable.getSelectionModel().getSelectedItem();
        if (selectedAppointment != null) {
            String date = datePicker.getValue() != null ? datePicker.getValue().toString() : "";
            String time = timePicker.getValue() != null ? timePicker.getValue() : "";
            String clientName = clientNameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String appointmentType = appointmentTypeField.getValue() != null ? appointmentTypeField.getValue() : "";
            String notes = notesField.getText();

            Connectivity connectivity = new Connectivity();
            Connection connection = connectivity.getConnection();

            try {
                String query = "UPDATE appointments SET date = ?, time = ?, clientName = ?, email = ?, phone = ?, appointmentType = ?, notes = ? WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, date);
                preparedStatement.setString(2, time);
                preparedStatement.setString(3, clientName);
                preparedStatement.setString(4, email);
                preparedStatement.setString(5, phone);
                preparedStatement.setString(6, appointmentType);
                preparedStatement.setString(7, notes);
                preparedStatement.setInt(8, selectedAppointment.getId());
                preparedStatement.executeUpdate();

                selectedAppointment.setDate(date);
                selectedAppointment.setTime(time);
                selectedAppointment.setClientName(clientName);
                selectedAppointment.setEmail(email);
                selectedAppointment.setPhone(phone);
                selectedAppointment.setAppointmentType(appointmentType);
                selectedAppointment.setNotes(notes);
                appointmentTable.refresh();

                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void deleteAppointment() {
        Appointments selectedAppointment = appointmentTable.getSelectionModel().getSelectedItem();
        if (selectedAppointment != null) {
            Connectivity connectivity = new Connectivity();
            Connection connection = connectivity.getConnection();

            try {
                String query = "DELETE FROM appointments WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, selectedAppointment.getId());
                preparedStatement.executeUpdate();

                appointments.remove(selectedAppointment);

                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void markCompleted() {
        Appointments selectedAppointment = appointmentTable.getSelectionModel().getSelectedItem();
        if (selectedAppointment != null) {
            Connectivity connectivity = new Connectivity();
            Connection connection = connectivity.getConnection();

            try {
                String query = "UPDATE appointments SET status = ? WHERE id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, "Completed");
                preparedStatement.setInt(2, selectedAppointment.getId());
                preparedStatement.executeUpdate();

                selectedAppointment.setStatus("Completed");
                appointmentTable.refresh();

                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
