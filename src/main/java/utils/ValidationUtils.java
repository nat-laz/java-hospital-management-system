package utils;

public class ValidationUtils {

    public static boolean isValidAge(int age) {
        return age > 0;
    }

    public static boolean isValidTime(String time) {
        return time.matches("\\d{2}:\\d{2}");
    }
}
