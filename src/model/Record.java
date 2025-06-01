package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
//Record class represents a sales record with details about the transaction
public class Record {
    private int id;
    private StringProperty date;
    private StringProperty customer_name;
    private StringProperty product_name;
    private StringProperty plan;
    private StringProperty amount;
    private StringProperty notes;
    // Constructor to initialize a Record object with the provided details
    public Record(int id, String date, String customer_name, String product_name, String plan, String amount, String notes) {
        this.id = id;
        this.date = new SimpleStringProperty(date);
        this.customer_name = new SimpleStringProperty(customer_name);
        this.product_name = new SimpleStringProperty(product_name);
        this.plan = new SimpleStringProperty(plan);
        this.amount = new SimpleStringProperty(amount);
        this.notes = new SimpleStringProperty(notes);
    }
    // Getter and setter for the record ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    // Getter and setter for the transaction date
    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public StringProperty dateProperty() {
        return date;
    }
    // Getter and setter for the customer name
    public String getCustomerName() {
        return customer_name.get();
    }

    public void setCustomerName(String customerName) {
        this.customer_name.set(customerName);
    }

    public StringProperty customerNameProperty() {
        return customer_name;
    }

    public String getProductName() {
        return product_name.get();
    }

    public void setProductName(String productName) {
        this.product_name.set(productName);
    }

    public StringProperty productNameProperty() {
        return product_name;
    }

    public String getPlan() {
        return plan.get();
    }

    public void setPlan(String plan) {
        this.plan.set(plan);
        setAmountBasedOnPlan(plan);
    }

    public StringProperty planProperty() {
        return plan;
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

    // Automatically set the amount based on the selected plan
    private void setAmountBasedOnPlan(String plan) {
        switch (plan) {
            case "community":
                setAmount("100");
                break;
            case "basic":
                setAmount("200");
                break;
            case "standard":
                setAmount("300");
                break;
            case "enterprise":
                setAmount("500");
                break;
            default:
                setAmount("0");
                break;
        }
    }
}
