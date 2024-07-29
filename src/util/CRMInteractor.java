package util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Member;

public class CRMInteractor {
    private ObservableList<Member> members;

    public CRMInteractor() {
        members = FXCollections.observableArrayList();
    }

    public ObservableList<Member> getMembers() {
        return members;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void deleteMember(Member member) {
        members.remove(member);
    }

    public void updateMember(Member oldMember, Member newMember) {
        int index = members.indexOf(oldMember);
        if (index >= 0) {
            members.set(index, newMember);
        }
    }
}