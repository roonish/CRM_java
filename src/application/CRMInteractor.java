package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CRMInteractor {
    private ObservableList<Member> members;

    public CRMInteractor() {
        // Initialize with some dummy data
        members = FXCollections.observableArrayList(
                new Member("Ronish Siwakoti", "+1-437-432-4650", "ronish.siwakoti@gmail.com", "IT Developer"),
                new Member("Cute Samridhi", "+1-449-234-6789", "cute.samrirdhi@email.com", "CEO"),
                new Member("Apple Ball", "+1-431-675-9867", "apple.ball@email.com", "Project Manager")
        );
    }

    public ObservableList<Member> getMembers() {
        return members;
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void updateMember(Member oldMember, Member updatedMember) {
        int index = members.indexOf(oldMember);
        if (index != -1) {
            members.set(index, updatedMember);
        }
    }

    public void deleteMember(Member member) {
        members.remove(member);
    }
}
