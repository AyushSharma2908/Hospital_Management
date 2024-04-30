package model;

import java.time.LocalTime;
import java.sql.Date;

public class Appointment {
    private int id;
    private int patientId;
    private int doctorId;
    private Date date;
    private LocalTime time;

    public Appointment(){

    }
    public Appointment(int id, int patientId, int doctorId, Date date, LocalTime time){
        this.id=id;
        this.patientId=patientId;
        this.doctorId=doctorId;
        this.date= date;
        this.time= time;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalTime getTime() {
        return time;
    }
    public String toString() {
        return "Appointment [ID=" + id + ", Patient ID=" + patientId + ", Doctor ID=" + doctorId + ", Date=" + date + ", Time=" + time + "]";
    }
}
