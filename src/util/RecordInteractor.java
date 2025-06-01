package util;

import model.Record;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecordInteractor {
    // Method to get appointments not in the records table
    public ObservableList<Record> getAppointmentsNotInRecords() {
        ObservableList<Record> newRecords = FXCollections.observableArrayList();
        String query = "SELECT * FROM appointments WHERE (date NOT IN (SELECT date from records) AND clientName NOT IN (SELECT customer_name FROM records)) AND status='Completed'";

        try (Connection connection = Connectivity.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Record record = new Record(
                    0, // Assuming ID will be auto-generated
                    resultSet.getString("date"),
                    resultSet.getString("clientName"), // Ensure this matches your appointments table schema
                    "Financial Services", // Default value; adjust if needed
                    "N/A", // Default value; adjust if needed
                    "N/A",
                    resultSet.getString("notes")
                );
                newRecords.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newRecords;
    }

    // Method to add new records to the records table
    public void addRecordsToTable(ObservableList<Record> newRecords) {
        String insertQuery = "INSERT INTO records (date, customer_name, product_name, plan, amount, notes) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = Connectivity.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            for (Record record : newRecords) {
                preparedStatement.setString(1, record.getDate());
                preparedStatement.setString(2, record.getCustomerName());
                preparedStatement.setString(3, record.getProductName());
                preparedStatement.setString(4, record.getPlan());
                preparedStatement.setString(5, record.getAmount());
                preparedStatement.setString(6, record.getNotes());
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a record
    public void addRecord(Record record) {
        String query = "INSERT INTO records (date, customer_name, product_name, plan, amount, notes) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = Connectivity.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, record.getDate());
            preparedStatement.setString(2, record.getCustomerName());
            preparedStatement.setString(3, record.getProductName());
            preparedStatement.setString(4, record.getPlan());
            preparedStatement.setString(5, record.getAmount());
            preparedStatement.setString(6, record.getNotes());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update a record
    public void updateRecord(Record oldRecord, Record newRecord) {
        String query = "UPDATE records SET date = ?, customer_name = ?, product_name = ?, plan = ?, amount = ?, notes = ? WHERE id = ?";
        try (Connection conn = Connectivity.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, newRecord.getDate());
            stmt.setString(2, newRecord.getCustomerName());
            stmt.setString(3, newRecord.getProductName());
            stmt.setString(4, newRecord.getPlan());
            stmt.setString(5, newRecord.getAmount());
            stmt.setString(6, newRecord.getNotes());
            stmt.setInt(7, oldRecord.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a record
 // Method to delete a record
    public void deleteRecord(Record record) {
        String query = "DELETE FROM records WHERE id = ?";
        try (Connection connection = Connectivity.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, record.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to fetch all records
    public ObservableList<Record> getAllRecords() {
        ObservableList<Record> records = FXCollections.observableArrayList();
        String query = "SELECT * FROM records";

        try (Connection connection = Connectivity.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Record record = new Record(
                    resultSet.getInt("id"),
                    resultSet.getString("date"),
                    resultSet.getString("customer_name"),
                    resultSet.getString("product_name"),
                    resultSet.getString("plan"),
                    resultSet.getString("amount"),
                    resultSet.getString("notes")
                );
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }
}