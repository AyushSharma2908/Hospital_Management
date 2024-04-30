package dao;

import model.Doctor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoctorDao {

    public static final String URL="jdbc:mysql://localhost:3306/Hospital";
    public static final String USER="root";
    public static final String PASSWORD="Hcl12345@";
    private static Connection connection;

    public DoctorDao(){
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Doctor> getAllDoctor(){
        List<Doctor> doctors = new ArrayList<>();

        try {
            String query = "SELECT * FROM doctors";
            try(PreparedStatement statement = connection.prepareStatement(query);
                ResultSet resultSet = statement.executeQuery()){
                while (resultSet.next()){
                    Doctor doctor = new Doctor(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getString("specialization"),resultSet.getString("contact"));
                    doctors.add(doctor);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return doctors;
    }

    public Doctor getSingelDoctor(int doctorId){
        Doctor doctor = null;
        try {
            String query = "SELECT * FROM doctors WHERE id=?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, doctorId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        doctor = new Doctor(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("specialization"), resultSet.getString("contact"));
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return doctor;
    }

    public void addDoctor(Doctor doctor){
        try {
            String query = "INSERT INTO doctors (id,name,specialization,contact) VALUES(?,?,?,?)";
            try(PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, doctor.getId());
                statement.setString(2,doctor.getName());
                statement.setString(3,doctor.getSpecialization());
                statement.setString(4,doctor.getContact());
                statement.executeUpdate();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateDoctor(Doctor doctor){
        try {
            String query = "UPDATE doctors SETS name=?,specialization=?,contact=? WHERE id=?";
            try(PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1,doctor.getName());
                statement.setString(2,doctor.getSpecialization());
                statement.setString(3,doctor.getContact());
                statement.setInt(4,doctor.getId());
                statement.executeUpdate();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteDoctor(int doctorId){
        try {
            String query = "DELETE FROM doctors WHERE id=?";
            try(PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1,doctorId);
                statement.executeUpdate();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

