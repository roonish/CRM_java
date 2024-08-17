package model;

import java.util.List;
//Employees class represents an employee with various details and availability information
public class Employees {
    private String name;
    private String mobile;
    private String email;
    private String role;
    private List<String> availableTimes;
    // Constructor to initialize an Employees object with the provided details

    public Employees(String name, String mobile, String email, String role, List<String> availableTimes) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.role = role;
        this.availableTimes = availableTimes;
    }
    // Getter for employee's name
    public String getName() {
        return name;
    }
    // Getter for employee's mobile number
    public String getMobile() {
        return mobile;
    }
    // Getter for employee's email address

    public String getEmail() {
        return email;
    }
    // Getter for employee's role
    public String getRole() {
        return role;
    }
    

    // Getter for employee's available times as a list
    public List<String> getAvailableTimes() {
        return availableTimes;
    }
 // Method to get available times as a single comma-separated string


    public String getAvailableTimesString() {
        return String.join(", ", availableTimes);
    }
    // Setter for employee's available times
    public void setAvailableTimes(List<String> availableTimes) {
        this.availableTimes = availableTimes;
    }
}
