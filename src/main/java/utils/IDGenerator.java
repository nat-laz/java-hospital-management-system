package utils;

import java.util.UUID;

public class IDGenerator {
    public static String generatePatientID() {
        return "P" + UUID.randomUUID().toString().substring(0, 4).toUpperCase();
    }
}
