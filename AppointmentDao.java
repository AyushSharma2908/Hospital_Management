package dao;

import model.Appointment;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDao {

    public static final String URL = "jdbc:mysql://localhost:3306/Hospital";
    public static final String USER = "root";
    public static final String PASSWORD = "Hcl12345@";

    private Connection connection;

    public AppointmentDao() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addAppointment(Appointment appointment) {
        try {
            String query = "INSERT INTO appointment (id,patientId,doctorId,date,time) VALUES (?,?,?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, appointment.getId());
                statement.setInt(2, appointment.getPatientId());
                statement.setInt(3, appointment.getDoctorId());
                statement.setDate(4, appointment.getDate());
                statement.setTime(5, Time.valueOf(appointment.getTime()));
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAppointment(Appointment appointment) {
        try {
            String query = "UPDATE appointment SET patientId=?,doctorId=?,date=?,time=? WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, appointment.getPatientId());
                statement.setInt(2, appointment.getDoctorId());
                statement.setDate(3, appointment.getDate());
                statement.setTime(4, Time.valueOf(appointment.getTime()));
                statement.setInt(5, appointment.getId());
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteAppointment(int appointmentId) {
        try {
            String query = "DELETE FROM appointment WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, appointmentId);
                statement.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Appointment> getAllAppointment() {
        List<Appointment> appointments = new ArrayList<>();
        try {
            String query = "SELECT * FROM appointment";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Appointment appointment = new Appointment(resultSet.getInt("id"), resultSet.getInt("patientId"), resultSet.getInt("doctorId"), resultSet.getDate("date"), resultSet.getTime("time").toLocalTime());
                    appointments.add(appointment);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appointments;
    }

    public Appointment getSingleAppointment(int id) {
        Appointment appointment = null;
        try {
            String query = "SELECT * FROM appointment WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        appointment = new Appointment(resultSet.getInt("id"), resultSet.getInt("patientId"), resultSet.getInt("doctorId"), resultSet.getDate("date"), resultSet.getTime("time").toLocalTime());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appointment;
    }

    public boolean isAppointmentConflict(int doctorId, Date date, LocalTime time) {
        try {
            String query = "SELECT * FROM appointment WHERE doctorId=? AND date=? AND time=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, doctorId);
                statement.setDate(2, date);
                statement.setTime(3, Time.valueOf(time));

                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}


