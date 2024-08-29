package models;

import java.util.ArrayList;
import java.util.List;

public class Hospital {
    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

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

    public Patient findPatientById(String patientId) {
        for (Patient patient : patients) {
            if (patient.getPatientId().equalsIgnoreCase(patientId)) {
                return patient;
            }
        }
        return null;
    }

    public void displayAllPatientsWithIds() {
        if (getPatients().isEmpty()) {
            System.out.println("No patients are registered.");
            return;
        }

        System.out.println("Listing all patients with their IDs:");
        for (Patient patient : getPatients()) {
            System.out.println("ID: " + RED+ patient.getPatientId() + RESET + ", Name: " + patient.getName());
        }
    }
}
