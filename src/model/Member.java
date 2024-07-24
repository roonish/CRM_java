package model;

import javafx.beans.property.SimpleStringProperty;

public class Member {
    private final SimpleStringProperty name;
    private final SimpleStringProperty mobile;
    private final SimpleStringProperty email;
    private final SimpleStringProperty role;

    public Member(String name, String mobile, String email,String role) {
        this.name = new SimpleStringProperty(name);
        this.mobile = new SimpleStringProperty(mobile);
        this.email = new SimpleStringProperty(email);
        this.role = new SimpleStringProperty(role);
    }

    public String getName() {
        return name.get();
    }

    public String getMobile() {
        return mobile.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getRole() {
        return role.get();
    }
}
