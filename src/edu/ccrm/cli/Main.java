package edu.ccrm.cli;

import edu.ccrm.config.AppConfig;
import edu.ccrm.domain.Student;
import edu.ccrm.io.ImportExportService;
import edu.ccrm.io.BackupService;
import edu.ccrm.service.StudentService;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    private static StudentService studentService = new StudentService();
    private static ImportExportService importExportService = new ImportExportService();
    private static BackupService backupService = new BackupService();

    public static void main(String[] args) {
        System.out.println("Welcome to the Campus Course & Records Manager!");
        System.out.println("Version: " + AppConfig.getInstance().getAppVersion());

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n--- Main Menu ---");
                System.out.println("1. Student Management");
                System.out.println("2. Course Management");
                System.out.println("3. Enrollment & Grading");
                System.out.println("4. File Operations");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        handleStudentManagement(scanner);
                        break;
                    case "2":
                        // handleCourseManagement(scanner);
                        break;
                    case "3":
                        // handleEnrollmentAndGrading(scanner);
                        break;
                    case "4":
                        handleFileOperations(scanner);
                        break;
                    case "5":
                        System.out.println("Exiting application. Goodbye!");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
    
    // All methods must be at the class level, not inside other methods.
    private static void handleStudentManagement(Scanner scanner) {
        while (true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add a new student");
            System.out.println("2. List all students");
            System.out.println("3. Back to main menu");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addStudent(scanner);
                    break;
                case "2":
                    listStudents();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter full name: ");
        String fullName = scanner.nextLine();
        System.out.print("Enter registration number: ");
        String regNo = scanner.nextLine();

        // Assertion to check a condition. Requires -ea JVM argument to run.
        assert id != null && !id.isEmpty() : "Student ID cannot be null or empty.";

        studentService.addStudent(new Student(id, fullName, regNo));
    }

    private static void listStudents() {
        System.out.println("\n--- All Students ---");
        for (Student s : studentService.getAllStudents()) {
            s.displayDetails();
            System.out.println("--------------------");
        }
    }
    
    private static void handleFileOperations(Scanner scanner) {
        while (true) {
            System.out.println("\n--- File Operations ---");
            System.out.println("1. Import data");
            System.out.println("2. Export data");
            System.out.println("3. Backup data");
            System.out.println("4. Back to main menu");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        // Placeholder for import logic
                        break;
                    case "2":
                        // Placeholder for export logic
                        break;
                    case "3":
                        // Use a dummy 'data' directory for backup
                        backupService.createTimestampedBackup(Paths.get("data"), Paths.get("backups"));
                        long totalSize = backupService.calculateSize(Paths.get("backups"));
                        System.out.printf("Total backup size: %.2f KB\n", totalSize / 1024.0);
                        break;
                    case "4":
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (IOException e) {
                System.out.println("A file operation error occurred: " + e.getMessage());
            }
        }
    }
}