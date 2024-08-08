//package util;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import model.Employees;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class EmployeeLogsInteractor {
//    private Connection connection;
//
//    public EmployeeLogsInteractor() {
//        connection = Connectivity.getConnection();
//    }
//
//    public ObservableList<Employees> getMembers() {
//        ObservableList<Employees> members = FXCollections.observableArrayList();
//        String query = "SELECT * FROM members";
//
//        try (Statement stmt = connection.createStatement();
//             ResultSet rs = stmt.executeQuery(query)) {
//
//            while (rs.next()) {
//                String name = rs.getString("name");
//                String mobile = rs.getString("mobile");
//                String email = rs.getString("email");
//                String role = rs.getString("role");
//                String availableTimesStr = rs.getString("available_times");
//                List<String> availableTimes = new ArrayList<>(Arrays.asList(availableTimesStr.split(", ")));
//
//                Employees employee = new Employees(name, mobile, email, role, availableTimes);
//                members.add(employee);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return members;
//    }
//
//    public void addMember(Employees employee) {
//        String query = "INSERT INTO members (name, mobile, email, role, available_times) VALUES (?, ?, ?, ?, ?)";
//
//        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
//            pstmt.setString(1, employee.getName());
//            pstmt.setString(2, employee.getMobile());
//            pstmt.setString(3, employee.getEmail());
//            pstmt.setString(4, employee.getRole());
//            pstmt.setString(5, String.join(", ", employee.getAvailableTimes()));
//
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void updateMember(Employees oldEmployee, Employees newEmployee) {
//        String query = "UPDATE members SET name = ?, mobile = ?, email = ?, role = ?, available_times = ? WHERE name = ? AND mobile = ? AND email = ? AND role = ? AND available_times = ?";
//
//        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
//            pstmt.setString(1, newEmployee.getName());
//            pstmt.setString(2, newEmployee.getMobile());
//            pstmt.setString(3, newEmployee.getEmail());
//            pstmt.setString(4, newEmployee.getRole());
//            pstmt.setString(5, String.join(", ", newEmployee.getAvailableTimes()));
//            pstmt.setString(6, oldEmployee.getName());
//            pstmt.setString(7, oldEmployee.getMobile());
//            pstmt.setString(8, oldEmployee.getEmail());
//            pstmt.setString(9, oldEmployee.getRole());
//            pstmt.setString(10, String.join(", ", oldEmployee.getAvailableTimes()));
//
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void deleteMember(Employees employee) {
//        String query = "DELETE FROM members WHERE name = ? AND mobile = ? AND email = ? AND role = ? AND available_times = ?";
//
//        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
//            pstmt.setString(1, employee.getName());
//            pstmt.setString(2, employee.getMobile());
//            pstmt.setString(3, employee.getEmail());
//            pstmt.setString(4, employee.getRole());
//            pstmt.setString(5, String.join(", ", employee.getAvailableTimes()));
//
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//package util;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import model.Employees;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class EmployeeLogsInteractor {
//    private Connection connection;
//
//    public EmployeeLogsInteractor() {
//        connection = Connectivity.getConnection();
//    }
//
//    public ObservableList<Employees> getMembers() {
//        ObservableList<Employees> members = FXCollections.observableArrayList();
//        String query = "SELECT * FROM members";
//
//        try (Statement stmt = connection.createStatement();
//             ResultSet rs = stmt.executeQuery(query)) {
//
//            while (rs.next()) {
//                String name = rs.getString("name");
//                String mobile = rs.getString("mobile");
//                String email = rs.getString("email");
//                String role = rs.getString("role");
//                String availableTimesStr = rs.getString("available_times");
//                List<String> availableTimes = new ArrayList<>(Arrays.asList(availableTimesStr.replaceAll("[\\[\\]\"]", "").split(",")));
//
//                Employees employee = new Employees(name, mobile, email, role, availableTimes);
//                members.add(employee);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return members;
//    }
//
//    public void addMember(Employees employee) {
//        String query = "INSERT INTO members (name, mobile, email, role, available_times) VALUES (?, ?, ?, ?, ?)";
//
//        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
//            pstmt.setString(1, employee.getName());
//            pstmt.setString(2, employee.getMobile());
//            pstmt.setString(3, employee.getEmail());
//            pstmt.setString(4, employee.getRole());
//            pstmt.setString(5, String.join(", ", employee.getAvailableTimes()));
//
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void updateMember(Employees oldEmployee, Employees newEmployee) {
//        String query = "UPDATE members SET name = ?, mobile = ?, email = ?, role = ?, available_times = ? WHERE name = ? AND mobile = ? AND email = ? AND role = ? AND available_times = ?";
//
//        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
//            pstmt.setString(1, newEmployee.getName());
//            pstmt.setString(2, newEmployee.getMobile());
//            pstmt.setString(3, newEmployee.getEmail());
//            pstmt.setString(4, newEmployee.getRole());
//            pstmt.setString(5, String.join(", ", newEmployee.getAvailableTimes()));
//            pstmt.setString(6, oldEmployee.getName());
//            pstmt.setString(7, oldEmployee.getMobile());
//            pstmt.setString(8, oldEmployee.getEmail());
//            pstmt.setString(9, oldEmployee.getRole());
//            pstmt.setString(10, String.join(", ", oldEmployee.getAvailableTimes()));
//
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void deleteMember(Employees employee) {
//        String query = "DELETE FROM members WHERE name = ? AND mobile = ? AND email = ? AND role = ? AND available_times = ?";
//
//        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
//            pstmt.setString(1, employee.getName());
//            pstmt.setString(2, employee.getMobile());
//            pstmt.setString(3, employee.getEmail());
//            pstmt.setString(4, employee.getRole());
//            pstmt.setString(5, String.join(", ", employee.getAvailableTimes()));
//
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}

package util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Employees;
import org.json.JSONArray;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeLogsInteractor {
    private Connection connection;

    public EmployeeLogsInteractor() {
        connection = Connectivity.getConnection();
    }

    public ObservableList<Employees> getMembers() {
        ObservableList<Employees> members = FXCollections.observableArrayList();
        String query = "SELECT * FROM members";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                String name = rs.getString("name");
                String mobile = rs.getString("mobile");
                String email = rs.getString("email");
                String role = rs.getString("role");
                String availableTimesStr = rs.getString("available_times");

                // Parse the JSON array
                JSONArray jsonArray = new JSONArray(availableTimesStr);
                List<String> availableTimes = new ArrayList<>();
                for (int i = 0; i < jsonArray.length(); i++) {
                    availableTimes.add(jsonArray.getString(i));
                }

                Employees employee = new Employees(name, mobile, email, role, availableTimes);
                members.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return members;
    }

    public void addMember(Employees employee) {
        String query = "INSERT INTO members (name, mobile, email, role, available_times) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getMobile());
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, employee.getRole());
            
            // Convert the list to a JSON array
            JSONArray jsonArray = new JSONArray(employee.getAvailableTimes());
            pstmt.setString(5, jsonArray.toString());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMember(Employees oldEmployee, Employees newEmployee) {
        String query = "UPDATE members SET name = ?, mobile = ?, email = ?, role = ?, available_times = ? WHERE name = ? AND mobile = ? AND email = ? AND role = ? AND available_times = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, newEmployee.getName());
            pstmt.setString(2, newEmployee.getMobile());
            pstmt.setString(3, newEmployee.getEmail());
            pstmt.setString(4, newEmployee.getRole());
            
            // Convert the list to a JSON array
            JSONArray jsonArray = new JSONArray(newEmployee.getAvailableTimes());
            pstmt.setString(5, jsonArray.toString());

            pstmt.setString(6, oldEmployee.getName());
            pstmt.setString(7, oldEmployee.getMobile());
            pstmt.setString(8, oldEmployee.getEmail());
            pstmt.setString(9, oldEmployee.getRole());
            JSONArray oldJsonArray = new JSONArray(oldEmployee.getAvailableTimes());
            pstmt.setString(10, oldJsonArray.toString());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMember(Employees employee) {
        String query = "DELETE FROM members WHERE name = ? AND mobile = ? AND email = ? AND role = ? AND available_times = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, employee.getName());
            pstmt.setString(2, employee.getMobile());
            pstmt.setString(3, employee.getEmail());
            pstmt.setString(4, employee.getRole());
            JSONArray jsonArray = new JSONArray(employee.getAvailableTimes());
            pstmt.setString(5, jsonArray.toString());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


