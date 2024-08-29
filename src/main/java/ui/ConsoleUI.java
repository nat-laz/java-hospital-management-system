package ui;

import models.Hospital;
import services.AppointmentServices;
import services.DoctorServices;
import services.PatientServices;

import java.util.Scanner;

public class ConsoleUI {
    private Hospital hospital;
    private PatientServices patientServices;
    private DoctorServices doctorServices;
    private AppointmentServices appointmentServices;

    public ConsoleUI(Hospital hospital) {
        this.hospital = hospital;
        this.patientServices = new PatientServices(hospital);
        this.doctorServices = new DoctorServices(hospital);
        this.appointmentServices = new AppointmentServices(hospital);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("==== Hospital Management System ====");
            System.out.println("1. Register Patient");
            System.out.println("2. Schedule Appointment");
            System.out.println("3. View Patient Details");
            System.out.println("4. View Doctor Details");
            System.out.println("5. View Appointments and Generate Bill");
            System.out.println("6. Exit");
            System.out.println("Choose an option:");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    patientServices.registerPatient();
                    break;
                case 2:
                    appointmentServices.scheduleAppointment();
                    break;
                case 3:
                    patientServices.viewPatientDetails();
                    break;
                case 4:
                    System.out.println("Enter Doctor ID:");
                    String doctorId = scanner.nextLine();
                    doctorServices.viewDoctorDetails(doctorId);
                    break;
                case 5:
                    appointmentServices.viewAppointmentsAndGenerateBill();
                    break;
                case 6:
                    System.out.println("Exiting system.");
                    return;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}
