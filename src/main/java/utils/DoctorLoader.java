package utils;

import models.Doctor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DoctorLoader {
    public static List<Doctor> loadDoctors(String filepath) {
        List<Doctor> doctors = new ArrayList<>();
        try {
            File file = new File(filepath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] details = line.split(";");
                if (details.length == 3) {
                    doctors.add(new Doctor(details[1], details[0], details[2]));
                }
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("Error reading doctors file: " + e.getMessage());
        }
        return doctors;
    }
}
