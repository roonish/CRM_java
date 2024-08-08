package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Record {
    private int id;
    private StringProperty date;
    private StringProperty customerName;
    private StringProperty productName;
    private StringProperty amount;
    private StringProperty notes;

    public Record(int id, String date, String customerName, String productName, String amount, String notes) {
        this.id = id;
        this.date = new SimpleStringProperty(date);
        this.customerName = new SimpleStringProperty(customerName);
        this.productName = new SimpleStringProperty(productName);
        this.amount = new SimpleStringProperty(amount);
        this.notes = new SimpleStringProperty(notes);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCustomerName() {
        return customerName.get();
    }

    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }

    public StringProperty customerNameProperty() {
        return customerName;
    }

    public String getProductName() {
        return productName.get();
    }

    public void setProductName(String productName) {
        this.productName.set(productName);
    }

    public StringProperty productNameProperty() {
        return productName;
    }

    public String getAmount() {
        return amount.get();
    }

    public void setAmount(String amount) {
        this.amount.set(amount);
    }

    public StringProperty amountProperty() {
        return amount;
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
}
