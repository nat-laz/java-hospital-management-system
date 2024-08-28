package models;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
}
