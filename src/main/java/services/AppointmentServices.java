package services;

import models.Appointment;
import models.Doctor;
import models.Hospital;
import models.Patient;
import utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppointmentServices {
    private Hospital hospital;

    public AppointmentServices(Hospital hospital) {
        this.hospital = hospital;
    }

    public void scheduleAppointment() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Patient ID:");
        String patientId = scanner.nextLine();
        Patient patient = findPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        DoctorServices doctorServices = new DoctorServices(hospital);
        Doctor doctor = doctorServices.assignDoctorToPatient();
        if (doctor == null) {
            return;
        }

        System.out.println("Enter Date (DD-MM-YYYY):");
        String date = scanner.nextLine();

        System.out.println("Enter Time (HH:MM):");
        String time = scanner.nextLine();

        if (!ValidationUtils.isValidTime(time)) {
            System.out.println("Invalid time format.");
            return;
        }

        Appointment appointment = new Appointment(patient, doctor, date, time);
        hospital.addAppointment(appointment);

        System.out.println("Appointment scheduled successfully.");
    }

    public void viewAppointmentsAndGenerateBill() {
        if (hospital.getPatients().isEmpty()) {
            System.out.println("No patient registered yet. Please register a patient first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Patient ID:");
        String patientId = scanner.nextLine();

        List<Appointment> patientAppointments = new ArrayList<>();
        for (Appointment appointment : hospital.getAppointments()) {
            if (appointment.getPatient().getPatientId().equalsIgnoreCase(patientId)) {
                patientAppointments.add(appointment);
            }
        }

        if (patientAppointments.isEmpty()) {
            System.out.println("No appointments found for this patient.");
            return;
        }

        System.out.println("Appointments for Patient ID: " + patientId);
        for (Appointment appointment : patientAppointments) {
            System.out.println(appointment);
        }

        // Generate the bill for the patient's appointments
        BillingService.generateBill(patientAppointments);
    }


    private Patient findPatientById(String patientId) {
        for (Patient patient : hospital.getPatients()) {
            if (patient.getPatientId().equalsIgnoreCase(patientId)) {
                return patient;
            }
        }
        return null;
    }
}
