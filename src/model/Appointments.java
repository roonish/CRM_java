package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Appointments {
    private final IntegerProperty id;
    private final StringProperty date;
    private final StringProperty time;
    private final StringProperty clientName;
    private final StringProperty email;
    private final StringProperty phone;
    private final StringProperty appointmentType;
    private final StringProperty notes;
    private final StringProperty status;

    public Appointments(int id, String date, String time, String clientName, String email, String phone, String appointmentType, String notes, String status) {
        this.id = new SimpleIntegerProperty(id);
        this.date = new SimpleStringProperty(date);
        this.time = new SimpleStringProperty(time);
        this.clientName = new SimpleStringProperty(clientName);
        this.email = new SimpleStringProperty(email);
        this.phone = new SimpleStringProperty(phone);
        this.appointmentType = new SimpleStringProperty(appointmentType);
        this.notes = new SimpleStringProperty(notes);
        this.status = new SimpleStringProperty(status);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public StringProperty dateProperty() {
        return date;
    }

    public String getTime() {
        return time.get();
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public StringProperty timeProperty() {
        return time;
    }

    public String getClientName() {
        return clientName.get();
    }

    public void setClientName(String clientName) {
        this.clientName.set(clientName);
    }

    public StringProperty clientNameProperty() {
        return clientName;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public String getAppointmentType() {
        return appointmentType.get();
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType.set(appointmentType);
    }

    public StringProperty appointmentTypeProperty() {
        return appointmentType;
    }

    public String getNotes() {
        return notes.get();
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }

    public StringProperty notesProperty() {
        return notes;
    }

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
