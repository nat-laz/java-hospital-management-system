package services;

import models.Doctor;
import models.Hospital;

import java.util.Scanner;

public class DoctorServices {
    private Hospital hospital;

    public DoctorServices(Hospital hospital) {
        this.hospital = hospital;
    }

    public void displayAvailableDoctors() {
        for (Doctor doctor : hospital.getDoctors()) {
            System.out.println(doctor.toString());
        }
    }

    public Doctor assignDoctorToPatient() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available Doctors:");
        displayAvailableDoctors();

        System.out.println("Enter Doctor ID to assign:");
        String doctorId = scanner.nextLine();

        for (Doctor doctor : hospital.getDoctors()) {
            if (doctor.getDoctorId().equalsIgnoreCase(doctorId)) {
                System.out.println("Assigned Doctor: " + doctor.getName());
                return doctor;
            }
        }
        System.out.println("Doctor ID not found.");
        return null;
    }

    public void viewDoctorDetails(String doctorId) {
        for (Doctor doctor : hospital.getDoctors()) {
            if (doctor.getDoctorId().equalsIgnoreCase(doctorId)) {
                System.out.println(doctor.toString());
                return;
            }
        }
        System.out.println("Doctor not found.");
    }
}
