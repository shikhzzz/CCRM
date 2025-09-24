package edu.ccrm.service;

import edu.ccrm.domain.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student " + student.getFullName() + " added successfully.");
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }
}
