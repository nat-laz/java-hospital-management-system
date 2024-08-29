package services;

import models.Appointment;

import java.util.List;

public class BillingService {
    public static void generateBill(List<Appointment> appointments) {
        double totalFee = 0;
        System.out.println();
        System.out.println("Generating bill for the following appointments:");
        for (Appointment appointment : appointments) {
            double fee = appointment.getDoctor().getFee();
            totalFee += fee;
            System.out.println(appointment + ", Fee: €" + fee);
        }
        System.out.println("Total Fee: €" + totalFee);
    }
}
