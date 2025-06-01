package model;
//CustomerDetail class represents the details of a customer in the CRM system
public class CustomerDetail {
    private String customer;
    private String enrolled;
    private String rating;
    private String email;
    // Constructor to initialize a CustomerDetail object with the provided information

    public CustomerDetail(String customer, String enrolled, String rating, String email) {
        this.customer = customer;
        this.enrolled = enrolled;
        this.rating = rating;
        this.email = email;
    }
    // Getter and setter for the customer name
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
    // Getter and setter for the enrollment status or date
    public String getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(String enrolled) {
        this.enrolled = enrolled;
    }
    // Getter and setter for the customer rating
    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    // Getter and setter for the customer's email address
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
