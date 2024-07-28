package util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Member;

public class CRMInteractor {
    private ObservableList<Member> members;

    public CRMInteractor() {
        members = FXCollections.observableArrayList();
        members.add(new Member("John Doe", "123-456-7890", "john@example.com", "Manager"));
        members.add(new Member("Jane Smith", "234-567-8901", "jane@example.com", "Developer"));
    }

    public ObservableList<Member> getMembers() {
        return members;
    }
}
