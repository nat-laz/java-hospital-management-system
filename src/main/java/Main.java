import models.Hospital;
import ui.ConsoleUI;
import utils.DoctorLoader;

public class Main {
    public static void main(String[] args) {
        Hospital hospital = new Hospital();

        // Load doctors from the file and add them to the hospital
        hospital.getDoctors().addAll(DoctorLoader.loadDoctors("src/main/resources/doctors.txt"));

        // Start the console UI
        ConsoleUI consoleUI = new ConsoleUI(hospital);
        consoleUI.start();
    }
}
