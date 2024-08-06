package util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LogsInteractor {
    public void addMember(Member member) {
        String query = "INSERT INTO members (name, mobile, email, role) VALUES (?, ?, ?, ?)";
        try (Connection connection = Connectivity.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, member.getName());
            preparedStatement.setString(2, member.getMobile());
            preparedStatement.setString(3, member.getEmail());
            preparedStatement.setString(4, member.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMember(Member oldMember, Member newMember) {
        String query = "UPDATE members SET name = ?, mobile = ?, email = ?, role = ? WHERE name = ? AND mobile = ? AND email = ? AND role = ?";
        try (Connection connection = Connectivity.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newMember.getName());
            preparedStatement.setString(2, newMember.getMobile());
            preparedStatement.setString(3, newMember.getEmail());
            preparedStatement.setString(4, newMember.getRole());
            preparedStatement.setString(5, oldMember.getName());
            preparedStatement.setString(6, oldMember.getMobile());
            preparedStatement.setString(7, oldMember.getEmail());
            preparedStatement.setString(8, oldMember.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMember(Member member) {
        String query = "DELETE FROM members WHERE name = ? AND mobile = ? AND email = ? AND role = ?";
        try (Connection connection = Connectivity.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, member.getName());
            preparedStatement.setString(2, member.getMobile());
            preparedStatement.setString(3, member.getEmail());
            preparedStatement.setString(4, member.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ObservableList<Member> getMembers() {
        ObservableList<Member> members = FXCollections.observableArrayList();
        String query = "SELECT * FROM members";
        try (Connection connection = Connectivity.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                Member member = new Member(
                    resultSet.getString("name"),
                    resultSet.getString("mobile"),
                    resultSet.getString("email"),
                    resultSet.getString("role")
                );
                members.add(member);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }
}
