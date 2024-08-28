package services;

import utils.ValidationUtils;
import models.Appointment;
import models.Doctor;
import models.Hospital;
import models.Patient;

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

        System.out.println("Enter Date (YYYY-MM-DD):");
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

    public void viewAppointments() {
        for (Appointment appointment : hospital.getAppointments()) {
            System.out.println(appointment.toString());
        }
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
