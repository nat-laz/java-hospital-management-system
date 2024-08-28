package models;

public class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;

    public Appointment(Patient patient, Doctor doctor, String date, String time) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Appointment [Patient: " + patient.getName() + ", Doctor: " + doctor.getName() + ", Date: " + date + ", Time: " + time + "]";
    }
}
