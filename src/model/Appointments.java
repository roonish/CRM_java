package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Appointments {
    private final StringProperty date;
    private final StringProperty time;
    private final StringProperty clientName;
    private final StringProperty email;
    private final StringProperty phone;
    private final StringProperty appointmentType;
    private final StringProperty notes;
    private final StringProperty status;

    public Appointments(String date, String time, String clientName, String email, String phone, String appointmentType, String notes, String status) {
        this.date = new SimpleStringProperty(date);
        this.time = new SimpleStringProperty(time);
        this.clientName = new SimpleStringProperty(clientName);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleStringProperty(phone);
        this.appointmentType = new SimpleStringProperty(appointmentType);
        this.notes = new SimpleStringProperty(notes);
        this.status = new SimpleStringProperty(status);
    }

    // Getter and Setter methods for date
    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public StringProperty dateProperty() {
        return date;
    }

    // Getter and Setter methods for time
    public String getTime() {
        return time.get();
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public StringProperty timeProperty() {
        return time;
    }

    // Getter and Setter methods for clientName
    public String getClientName() {
        return clientName.get();
    }

    public void setClientName(String clientName) {
        this.clientName.set(clientName);
    }

    public StringProperty clientNameProperty() {
        return clientName;
    }

    // Getter and Setter methods for email
    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

    // Getter and Setter methods for phone
    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    // Getter and Setter methods for appointmentType
    public String getAppointmentType() {
        return appointmentType.get();
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType.set(appointmentType);
    }

    public StringProperty appointmentTypeProperty() {
        return appointmentType;
    }

    // Getter and Setter methods for notes
    public String getNotes() {
        return notes.get();
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }

    public StringProperty notesProperty() {
        return notes;
    }

    // Getter and Setter methods for status
    public String getStatus() {
        return status.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public StringProperty statusProperty() {
        return status;
    }
}
