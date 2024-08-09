package util;

import model.Appointments;
import util.Connectivity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentInteractor {

    public void addAppointment(Appointments appointment) {
        String query = "INSERT INTO Appointments (date, time, clientName, email, phone, appointmentType, notes, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Connectivity.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, appointment.getDate());
            stmt.setString(2, appointment.getTime());
            stmt.setString(3, appointment.getClientName());
            stmt.setString(4, appointment.getEmail());
            stmt.setString(5, appointment.getPhone());
            stmt.setString(6, appointment.getAppointmentType());
            stmt.setString(7, appointment.getNotes());
            stmt.setString(8, appointment.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAppointment(Appointments appointment) {
        String query = "UPDATE Appointments SET date = ?, time = ?, clientName = ?, email = ?, phone = ?, appointmentType = ?, notes = ?, status = ? WHERE date = ? AND time = ? AND clientName = ?";
        try (Connection conn = Connectivity.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, appointment.getDate());
            stmt.setString(2, appointment.getTime());
            stmt.setString(3, appointment.getClientName());
            stmt.setString(4, appointment.getEmail());
            stmt.setString(5, appointment.getPhone());
            stmt.setString(6, appointment.getAppointmentType());
            stmt.setString(7, appointment.getNotes());
            stmt.setString(8, appointment.getStatus());
            stmt.setString(9, appointment.getDate());
            stmt.setString(10, appointment.getTime());
            stmt.setString(11, appointment.getClientName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
}

    public void deleteAppointment(Appointments appointment) {
        String query = "DELETE FROM Appointments WHERE date = ? AND time = ? AND clientName = ?";
        try (Connection conn = Connectivity.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, appointment.getDate());
            stmt.setString(2, appointment.getTime());
            stmt.setString(3, appointment.getClientName());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Appointments> getAllAppointments() {
        List<Appointments> appointments = new ArrayList<>();
        String query = "SELECT * FROM Appointments";
        try (Connection conn = Connectivity.getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Appointments appointment = new Appointments(
                    rs.getString("date"),
                    rs.getString("time"),
                    rs.getString("clientName"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getString("appointmentType"),
                    rs.getString("notes"),
                    rs.getString("status")
                );
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }
}