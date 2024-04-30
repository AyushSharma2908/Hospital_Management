package main;

import dao.AppointmentDao;
import model.Appointment;
import dao.DoctorDao;
import model.Doctor;
import dao.PatientDao;
import model.Patient;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class HospitalManagementMain {

    private static DoctorDao doctorDao = new DoctorDao();
    private static PatientDao patientDao = new PatientDao();
    private static AppointmentDao appointmentDao = new AppointmentDao();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        while (true){
            System.out.println("Hospital Management System: ");
            System.out.println("1. Manage Patients");
            System.out.println("2. Manage Doctors");
            System.out.println("3. Manage Appointments");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    managePatients();
                    break;
                case 2:
                    manageDoctors();
                    break;
                case 3:
                    manageAppointments();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void managePatients(){
        System.out.println("Manage Patients:");
        System.out.println("1. Add Patient");
        System.out.println("2. View All Patient");
        System.out.println("3. Update Patient");
        System.out.println("4. Delete Patient");
        System.out.println("5. Get Single Patient");
        System.out.println("6. Exiting...");

        System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice){
            case 1:
                addPatient();
                break;

            case 2:
                getAllPatient();
                break;

            case 3:
                updatePatient();
                break;

            case 4:
                deletePatient();
                break;

            case 5:
                getSinglePatient();
                break;

            case 6:
                System.out.println("Exiting...");
                System.exit(0);

            default:
                System.out.println("Invalid Input.Please try again.");
        }
    }
    private static void getAllPatient(){
        List<Patient> patients = patientDao.getAllPatient();
        System.out.println("Patients List:");
        for (Patient patient : patients ){
            System.out.println(patient);
        }
    }
    private static void addPatient(){
        System.out.println("Enter Patient ID:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Patient Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Patient age:");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Patient Gender");
        String gender = scanner.nextLine();

        System.out.println("Enter Patient Contact");
        String contact = scanner.nextLine();

        Patient patient = new Patient(id,name,age,gender,contact);
        patientDao.addPatient(patient);
        System.out.println("Patient added successfully.");
    }
    private static void updatePatient(){
        System.out.println("Enter PatientId to update:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Patient name:");
        String name = scanner.nextLine();

        System.out.println("Enter Patient age:");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Patient Gender");
        String gender = scanner.nextLine();

        System.out.println("Enter Patient Contact");
        String contact = scanner.nextLine();

        Patient patient = new Patient(id,name,age,gender,contact);
        patientDao.updatePatient(patient);
        System.out.println("Patient updated successfully.");
    }
    private static void deletePatient(){
        System.out.println("Enter Patient ID to delete:");
        int id = scanner.nextInt();
        scanner.nextLine();

        patientDao.deletePatient(id);
        System.out.println("Patient deleted successfully.");
    }
    private static void getSinglePatient(){
        System.out.println("Enter Patient ID to get:");
        int id = scanner.nextInt();

        Patient patient = patientDao.getSinglePatient(id);
        System.out.println("Patient:");
        if (patient!=null){
            System.out.println("id=" + patient.getId() + ", name=" + patient.getName()+", age="+ patient.getAge()+", gender="+ patient.getGender()+", contact="+ patient.getContact());
        }
        else {
            System.out.println("Patient not found with this id: " + id);
        }
    }
    private static void manageDoctors(){
        System.out.println("Manage Doctors:");
        System.out.println("1. Add Doctor");
        System.out.println("2. View All Doctors");
        System.out.println("3. Update Doctor");
        System.out.println("4. Delete Doctor");
        System.out.println("5. Get Single Doctor");
        System.out.println("6. Exiting...");

        System.out.print("Enter your choice:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice){
            case 1:
                addDoctor();
                break;

            case 2:
                getAllDoctor();
                break;

            case 3:
                updateDoctor();
                break;

            case 4:
                deleteDoctor();
                break;

            case 5:
                getSingleDoctor();
                break;

            case 6:
                System.out.println("Exiting...");
                System.exit(0);

            default:
                System.out.println("Invalid input.Please try again.");
        }
    }
    private static void addDoctor(){
        System.out.print("Enter Doctor id:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Doctor name:");
        String name = scanner.nextLine();

        System.out.print("Enter Doctor specialty:");
        String specialty = scanner.nextLine();

        System.out.print("Enter Doctor contact:");
        String contact = scanner.nextLine();

        Doctor doctor = new Doctor(id,name,specialty,contact);
        doctorDao.addDoctor(doctor);

        System.out.println("Doctor added successfully.");
    }
    private static void getAllDoctor(){
        List<Doctor> doctors = doctorDao.getAllDoctor();
        System.out.println("Doctors list:");
        for (Doctor doctor : doctors ){
            System.out.println(doctor);
        }
    }
    private static void updateDoctor(){
        System.out.print("Enter Doctor id to update:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Doctor name:");
        String name = scanner.nextLine();

        System.out.print("Enter Doctor specialty:");
        String specialty = scanner.nextLine();

        System.out.print("Enter Doctor contact:");
        String contact = scanner.nextLine();

        Doctor doctor = new Doctor(id,name,specialty,contact);
        doctorDao.updateDoctor(doctor);

        System.out.println("Doctor updated successfully.");
    }
    private static void deleteDoctor(){

        System.out.print("Enter Doctor id to delete:");
        int id = scanner.nextInt();
        scanner.nextLine();

        doctorDao.deleteDoctor(id);
        System.out.println("Doctor delete successfully.");
    }
    private static void getSingleDoctor(){
        System.out.print("Enter Doctor Id to get:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Doctor doctor = doctorDao.getSingelDoctor(id);
        System.out.println("Doctor:");
        if (doctor!=null){
            System.out.println("id=" + doctor.getId() + " name=" + doctor.getName()+" specialization=" +doctor.getSpecialization()+" contact=" + doctor.getContact());
        }
        else {
            System.out.println("Doctor not found with this id " + id);
        }
    }

    private static void manageAppointments() throws ParseException {

        System.out.println("Manage Appointments:");
        System.out.println("1. Add Appointments");
        System.out.println("2. View All Appointments");
        System.out.println("3. Update Appointments");
        System.out.println("4. Delete Appointments");
        System.out.println("5. Get Single Appointments");
        System.out.println("6. Exiting...");

        System.out.print("Enter your choice:");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice){
            case 1:
                addAppointment();
                break;

            case 2:
                getAllAppointment();
                break;

            case 3:
                updateAppointment();
                break;

            case 4:
                deleteAppointment();
                break;

            case 5:
                getSingleAppointment();
                break;

            case 6:
                System.out.println("Exiting...");
                System.exit(0);

            default:
                System.out.println("Invalid input.Please try again.");
        }
    }

    private static void addAppointment() throws ParseException {

        System.out.print("Enter Appointment id:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Patient id:");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Doctor id:");
        int doctorId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter date (yyyy-MM-dd)");
        String dateString = scanner.next();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date date = new java.sql.Date(utilDate.getTime());

        System.out.print("Enter time (HH:mm:ss)");
        String timeString = scanner.next();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time = LocalTime.parse(timeString,format);

        boolean conflictExists = appointmentDao.isAppointmentConflict(doctorId,date,time);
        if (conflictExists){
            System.out.println("An appointment already exists in this date and time.please choose different.");
        }
        else {
            Appointment appointment = new Appointment(id, patientId, doctorId, date, time);
            appointmentDao.addAppointment(appointment);
            System.out.println("Appointment added successfully.");
        }
    }

    private static void getAllAppointment(){
        List<Appointment> appointments = appointmentDao.getAllAppointment();
        System.out.println("Appointment List:");
        for (Appointment appointment : appointments){
            System.out.println(appointment);
        }
    }
    private static void updateAppointment() throws ParseException {
        System.out.print("Enter appointment Id to update:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter patient id:");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter doctor id:");
        int doctorId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter date (yyyy-MM-dd):");
        String date1 = scanner.nextLine();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = (Date) format.parse(date1);

        System.out.print("Enter time (HH:mm:ss):");
        String timeString = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time = LocalTime.parse(timeString,formatter);

        Appointment appointment = new Appointment(id,patientId,doctorId, date,time);
        appointmentDao.updateAppointment(appointment);

        System.out.println("Appointment updated successfully.");
    }
    private static void deleteAppointment(){
        System.out.print("Enter appointment id to delete:");
        int id = scanner.nextInt();
        scanner.nextLine();

        appointmentDao.deleteAppointment(id);
        System.out.println("Appointment delete successfully.");
    }
    private static void getSingleAppointment(){
        System.out.print("Enter appointment id to get:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Appointment appointment = appointmentDao.getSingleAppointment(id);
        if (appointment!=null){
            System.out.println("id="+appointment.getId()+" patientId="+appointment.getPatientId()+" doctorId="+appointment.getDoctorId()+" date="+appointment.getDate()+" time="+appointment.getTime());
        }
        else {
            System.out.println("Appointment not found with this id " + id);
        }
    }
}

