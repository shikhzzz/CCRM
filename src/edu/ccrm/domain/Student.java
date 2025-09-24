package edu.ccrm.domain;

public class Student extends Person {
    private String regNo;
    // Add other fields from the project brief, like email and status
    // private String email;
    // private String status;
    // private java.time.LocalDate enrollmentDate;

    public Student(String id, String fullName, String regNo) {
        super(id, fullName);
        this.regNo = regNo;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    @Override
    public void displayDetails() {
        System.out.println("Student ID: " + getId());
        System.out.println("Registration No: " + regNo);
        System.out.println("Name: " + getFullName());
    }
}