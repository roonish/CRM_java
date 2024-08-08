package model;

import java.util.List;

public class Employees {
    private String name;
    private String mobile;
    private String email;
    private String role;
    private List<String> availableTimes;

    public Employees(String name, String mobile, String email, String role, List<String> availableTimes) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.role = role;
        this.availableTimes = availableTimes;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public List<String> getAvailableTimes() {
        return availableTimes;
    }

    public String getAvailableTimesString() {
        return String.join(", ", availableTimes);
    }

    public void setAvailableTimes(List<String> availableTimes) {
        this.availableTimes = availableTimes;
    }
}
