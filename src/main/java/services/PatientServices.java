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

        System.out.println("Patient registered successfully with ID: " + hospital.RED + patient.getPatientId() + hospital.RESET);

        return patient.getPatientId();
    }

    public void viewPatientDetails() {
        if (hospital.getPatients().isEmpty()) {
            System.out.println("No patient registered yet. Please register a patient first.");
            return;
        }

        hospital.displayAllPatientsWithIds();

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

    public void updatePatientInformation() {
        if (hospital.getPatients().isEmpty()) {
            System.out.println("No patient registered yet. Please register a patient first.");
            return;
        }

        hospital.displayAllPatientsWithIds();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Patient ID:");
        String patientId = scanner.nextLine();

        Patient patient = hospital.findPatientById(patientId);
        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.println("Updating information for Patient ID: " + patientId);
        System.out.println("Current Name: " + patient.getName());
        System.out.println("Enter new name (or press Enter to keep current):");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            patient.setName(name);
        }

        System.out.println("Current Age: " + patient.getAge());
        System.out.println("Enter new age (or press Enter to keep current):");
        String ageInput = scanner.nextLine();
        if (!ageInput.isEmpty()) {
            int age = Integer.parseInt(ageInput);
            if (ValidationUtils.isValidAge(age)) {
                patient.setAge(age);
            } else {
                System.out.println("Invalid age entered. Keeping current age.");
            }
        }

        System.out.println("Current Gender: " + patient.getGender());
        System.out.println("Enter new gender (or press Enter to keep current):");
        String gender = scanner.nextLine();
        if (!gender.isEmpty()) {
            patient.setGender(gender);
        }

        System.out.println("Current Contact Info: " + patient.getContactInfo());
        System.out.println("Enter new contact info (or press Enter to keep current):");
        String contactInfo = scanner.nextLine();
        if (!contactInfo.isEmpty()) {
            patient.setContactInfo(contactInfo);
        }

        System.out.println("Patient information updated successfully.");
    }

}
