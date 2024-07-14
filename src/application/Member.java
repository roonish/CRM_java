package application;

import javafx.beans.property.SimpleStringProperty;

public class Member {
    private final SimpleStringProperty name;
    private final SimpleStringProperty mobile;
    private final SimpleStringProperty email;
    private final SimpleStringProperty action;

    public Member(String name, String mobile, String email) {
        this.name = new SimpleStringProperty(name);
        this.mobile = new SimpleStringProperty(mobile);
        this.email = new SimpleStringProperty(email);
        this.action = new SimpleStringProperty("Block");
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

    public String getAction() {
        return action.get();
    }
}

