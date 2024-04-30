package dao;


import model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDao {

    private static final String URL = "jdbc:mysql://localhost:3306/Hospital";
    private static final String USER = "root";
    private static final String PASSWORD = "Hcl12345@";

    private static Connection connection;

    public PatientDao(){
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Patient> getAllPatient(){

        List<Patient> patients = new ArrayList<>();

        try {
            String query = "SELECT * FROM PATIENTS";
            try (PreparedStatement statement = connection.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()){
                    Patient patient = new Patient(resultSet.getInt("id"),resultSet.getString("name"),resultSet.getInt("age"),resultSet.getString("gender"),resultSet.getString("contact"));
                    patients.add(patient);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return patients;
    }

    public Patient getSinglePatient(int patientId){
        Patient patient = null;
        String query = "SELECT * FROM PATIENTS WHERE id=?";
        try(PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, patientId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    patient = new Patient(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("age"), resultSet.getString("gender"),resultSet.getString("contact"));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return patient;
    }

    public void addPatient(Patient patient){
        try {
            String query = "INSERT INTO patients (id,name,age,gender,contact) VALUES (?,?,?,?,?)";
            try(PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1,patient.getId());
                statement.setString(2, patient.getName());
                statement.setInt(3,patient.getAge());
                statement.setString(4, patient.getGender());
                statement.setString(5, patient.getContact());
                statement.executeUpdate();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updatePatient(Patient patient){
        try {
            String query = "UPDATE PATIENTS SET name=?,age=?,gender=?,contact=? WHERE id=?";
            try(PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1,patient.getName());
                statement.setInt(2,patient.getAge());
                statement.setString(3, patient.getGender());
                statement.setString(4, patient.getContact());
                statement.setInt(5,patient.getId());
                statement.executeUpdate();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void deletePatient(int patientid){
        try {
            String query = "DELETE FROM patients WHERE id = ?";
            try(PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1,patientid);
                statement.executeUpdate();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

