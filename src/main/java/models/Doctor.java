package models;

public class Doctor {
    private String doctorId;
    private String name;
    private String specialization;
    private double fee;

    public Doctor(String doctorId, String name, String specialization, double fee) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.fee = fee;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public double getFee() {
        return fee;
    }

    @Override
    public String toString() {
        return "Doctor ID: " + doctorId + ", Name: " + name + ", Specialization: " + specialization + ", Fee: €" + fee;
    }
}
