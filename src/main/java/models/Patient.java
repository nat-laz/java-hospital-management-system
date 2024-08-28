package models;

import utils.IDGenerator;

public class Patient {
    private String patientId;
    private String name;
    private int age;
    private String gender;
    private String contactInfo;

    public Patient(String name, int age, String gender, String contactInfo) {
        this.patientId = IDGenerator.generatePatientID();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactInfo = contactInfo;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Contact: " + contactInfo;
    }
}
