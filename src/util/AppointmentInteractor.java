package util;


import model.Appointments;
import model.Employees;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import util.Connectivity;

import java.lang.reflect.Type;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javafx.collections.ObservableList;

public class AppointmentInteractor {

    public void addAppointment(Appointments appointment) {
        String assignedTo = findAssignedEmployee(appointment.getTime(), appointment.getDate());

        String query = "INSERT INTO Appointments (date, time, clientName, email, phone, appointmentType, notes, status, assignedTo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Connectivity.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, appointment.getDate());
            stmt.setString(2, appointment.getTime());
            stmt.setString(3, appointment.getClientName());
            stmt.setString(4, appointment.getEmail());
            stmt.setString(5, appointment.getPhone());
            stmt.setString(6, appointment.getAppointmentType());
            stmt.setString(7, appointment.getNotes());
            stmt.setString(8, appointment.getStatus());
            stmt.setString(9, assignedTo); 
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private String findAssignedEmployee(String appointmentTime, String appointmentDate) {
        String assignedTo = "";
        String query = "SELECT name, available_times FROM members";
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");

        try (Connection conn = Connectivity.getConnection(); 
             PreparedStatement stmt = conn.prepareStatement(query); 
             ResultSet rs = stmt.executeQuery()) {

            LocalTime appointmentLocalTime = LocalTime.parse(appointmentTime, timeFormatter);
            LocalTime closestTime = null;
            String closestEmployee = null;

            while (rs.next()) {
                String name = rs.getString("name");
                String availableTimesJson = rs.getString("available_times");

                List<String> availableTimes = parseAvailableTimes(availableTimesJson);

                for (String time : availableTimes) {
                    try {
                        LocalTime availableLocalTime = LocalTime.parse(time, timeFormatter);

                        // Check if this employee is already assigned to an appointment at the same date and time
                        if (!isEmployeeAlreadyAssigned(conn, name, appointmentTime, appointmentDate)) {
                            if (availableLocalTime.equals(appointmentLocalTime)) {
                                // Exact match found, return immediately
                                return name;
                            } else if (availableLocalTime.isAfter(appointmentLocalTime)) {
                                if (closestTime == null || availableLocalTime.isBefore(closestTime)) {
                                    closestEmployee = name;
                                    closestTime = availableLocalTime;
                                }
                            }
                        }
                    } catch (DateTimeParseException e) {
                        System.err.println("Failed to parse time: " + time);
                    }
                }
            }

            // If no exact match is found, return the closest available employee
            if (closestEmployee != null) {
                assignedTo = closestEmployee;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return assignedTo;
    }

    private boolean isEmployeeAlreadyAssigned(Connection conn, String employeeName, String appointmentTime, String appointmentDate) {
        String query = "SELECT COUNT(*) FROM Appointments WHERE assignedTo = ? AND time = ? AND date = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, employeeName);
            stmt.setString(2, appointmentTime);
            stmt.setString(3, appointmentDate);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    private List<String> parseAvailableTimes(String availableTimesJson) {
    	 Gson gson = new Gson();
         Type listType = new TypeToken<List<String>>(){}.getType();
         List<String> timeList =  gson.fromJson(availableTimesJson, listType);
        
        return timeList;
    }


    public boolean isTimeFullyBooked(String time, LocalDate date) {
        String query = "SELECT COUNT(*) AS booked_count FROM Appointments " +
                       "WHERE date = ? AND time = ?";
        try (Connection conn = Connectivity.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, date.toString());
            stmt.setString(2, time);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int bookedCount = rs.getInt("booked_count");
                    return bookedCount > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    private int getNumberOfAvailableEmployees(String requestedTime) {
    	EmployeeLogsInteractor employeeLogsInteractor = new EmployeeLogsInteractor();
        // Retrieve the list of all employees
        ObservableList<Employees> employees = employeeLogsInteractor.getMembers();

        // Count the number of employees available at the requested time
        int availableCount = 0;
        for (Employees employee : employees) {
            List<String> availableTimes = employee.getAvailableTimes();
            if (availableTimes.contains(requestedTime)) {
                availableCount++;
            }
        }
        return availableCount;
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
                    rs.getString("status"),
                    rs.getString("assignedTo")
                );
                appointments.add(appointment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appointments;
    }
}
