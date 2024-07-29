package model;

public class CustomerDetail {
    private String customer;
    private String enrolled;
    private String rating;
    private String email;

    public CustomerDetail(String customer, String enrolled, String rating, String email) {
        this.customer = customer;
        this.enrolled = enrolled;
        this.rating = rating;
        this.email = email;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getEnrolled() {
        return enrolled;
    }

    public void setEnrolled(String enrolled) {
        this.enrolled = enrolled;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
