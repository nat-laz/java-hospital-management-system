package services;

import models.Hospital;
import models.Patient;
import utils.ValidationUtils;

import java.util.Scanner;

public class PatientServices {
    private Hospital hospital;

    public PatientServices(Hospital hospital) {
        this.hospital = hospital;
    }

    public String registerPatient() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Patient Name:");
        String name = scanner.nextLine();

        System.out.println("Enter Patient Age:");
        int age = scanner.nextInt();
        scanner.nextLine();

        if (!ValidationUtils.isValidAge(age)) {
            System.out.println("Invalid age. Please enter a positive number.");
            return null;
        }

        System.out.println("Enter Patient Gender:");
        String gender = scanner.nextLine();

        System.out.println("Enter Contact Information:");
        String contactInfo = scanner.nextLine();

        Patient patient = new Patient(name, age, gender, contactInfo);
        hospital.addPatient(patient);

        System.out.println("Patient registered successfully with ID: " + patient.getPatientId());

        return patient.getPatientId();
    }

    public void viewPatientDetails() {
        if (hospital.getPatients().isEmpty()) {
            System.out.println("No patient registered yet. Please register a patient first.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Patient ID:");
        String patientId = scanner.nextLine();

        for (Patient patient : hospital.getPatients()) {
            if (patient.getPatientId().equalsIgnoreCase(patientId)) {
                System.out.println(patient.toString());
                return;
            }
        }
        System.out.println("Patient not found.");
    }
}
