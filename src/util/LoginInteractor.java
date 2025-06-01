package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import BCrypt.BCrypt;


public class LoginInteractor {
    public boolean authenticate(String email, String password) {
        String query = "SELECT password FROM users WHERE email = ?";
        try (Connection connection = Connectivity.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String storedHash = resultSet.getString("password");
                return BCrypt.checkpw(password, storedHash);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public String loadUserNameFromDatabase(String email) {
        String query = "SELECT full_name FROM users WHERE email = ?";
        try (Connection connection = Connectivity.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String fullname = resultSet.getString("full_name");
                return fullname;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "User";
    }
}
