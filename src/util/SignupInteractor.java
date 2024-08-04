package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import BCrypt.BCrypt;

public class SignupInteractor {
    public boolean signUp(String fullName, String email, String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        String query = "INSERT INTO users (full_name, email, password) VALUES (?, ?, ?)";
        try (Connection connection = Connectivity.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, hashedPassword);
            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println("User signed up: " + fullName + ", " + email);
            return rowsAffected > 0; // return true if the insert was successful
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // return false if there was an error
        }
    }
}
