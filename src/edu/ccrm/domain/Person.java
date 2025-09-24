package edu.ccrm.domain;

public abstract class Person {
    private String id;
    private String fullName;

    public Person(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

    // Getters and Setters for encapsulation
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // This is an abstract method that must be implemented by subclasses
    public abstract void displayDetails();
}