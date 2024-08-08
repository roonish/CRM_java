package util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Record;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecordInteractor {

    public void addRecord(Record record) {
        String query = "INSERT INTO records (date, customer_name, product_name, amount, notes) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = Connectivity.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, record.getDate());
            preparedStatement.setString(2, record.getCustomerName());
            preparedStatement.setString(3, record.getProductName());
            preparedStatement.setString(4, record.getAmount());
            preparedStatement.setString(5, record.getNotes());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRecord(Record oldRecord, Record newRecord) {
        String query = "UPDATE records SET date = ?, customer_name = ?, product_name = ?, amount = ?, notes = ? WHERE id = ?";
        try (Connection connection = Connectivity.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, newRecord.getDate());
            preparedStatement.setString(2, newRecord.getCustomerName());
            preparedStatement.setString(3, newRecord.getProductName());
            preparedStatement.setString(4, newRecord.getAmount());
            preparedStatement.setString(5, newRecord.getNotes());
            preparedStatement.setInt(6, oldRecord.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

    public ObservableList<Record> getRecords() {
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
