package panels;

import java.util.List;
import models.SchoolData;
import models.Student;
import models.Teacher;
import utility.InputHelper;

public class SystemManager {
    private Student loggedInStudent = null;
    private Teacher loggedInTeacher = null;

    // Constructor: Initializes the SystemManager by loading data from various sources.
    public SystemManager() {
        SchoolData.loadStudents();     // Loads student data from storage.
        SchoolData.loadAssignments();  // Loads assignment data.
        SchoolData.loadLessons();      // Loads lesson data.
        SchoolData.loadAnnouncements(); // Loads announcement data.
        SchoolData.loadGrades();       // Loads grade data.
        SchoolData.loadSubjects();     // Loads subject data.
        SchoolData.loadTeachers();     // Loads teacher data.
    }

    // run:  The main loop that runs the school management system.
    public void run() {
        while (true) { // Main program loop
            List<String> mainMenuOptions = List.of("Register", "Login", "Exit");
            InputHelper.displayMenu("Project: S.W.I.F.T", mainMenuOptions); // Display main menu
            int choice = InputHelper.getIntInput("Choice: ");       // Get user's menu choice

            switch (choice) {
                case 1 -> register();  // Handle registration
                case 2 -> login();     // Handle login
                case 3 -> {           // Handle exit
                    saveAllData();   // Save all data before exiting
                    System.out.println("Exiting system. Goodbye!");
                    InputHelper.closeScanner(); // Close input scanner
                    return;            // Terminate the program
                }
                default -> System.out.println("Invalid choice.");
            }

            // After processing the main menu, check for logged-in users and run their panels.
            if (loggedInStudent != null) {
                // Fetch the most up-to-date student data
                Student currentStudent = SchoolData.getStudents().stream()
                        .filter(s -> s.getUsername().equals(loggedInStudent.getUsername()))
                        .findFirst()
                        .orElse(null);
                if (currentStudent != null) {
                    StudentPanel.run(currentStudent); // Run the student panel
                }
                loggedInStudent = null; // Reset after student panel exits to return to main menu
            } else if (loggedInTeacher != null) {
                // Fetch the most up-to-date teacher data
                Teacher currentTeacher = SchoolData.getTeachers().stream()
                        .filter(t -> t.getUsername().equals(loggedInTeacher.getUsername()))
                        .findFirst()
                        .orElse(null);
                if (currentTeacher != null) {
                    TeacherPanel.run(currentTeacher); // Run the teacher panel
                }
                loggedInTeacher = null; // Reset after teacher panel exits to return to main menu
            }
            // The loop restarts, showing the Register/Login menu.
        }
    }

    // register:  Handles the user registration process.
    private void register() {
        List<String> registerOptions = List.of("Teacher", "Student", "Go Back");
        InputHelper.displayMenu("Register as", registerOptions); // Display registration options
        int role = InputHelper.getIntInput("Choice: ");          // Get user's role choice

        if (role == 3) {
            System.out.println("Returning to main menu.");
            return; // Go back to the main menu
        }

        String username = InputHelper.getStringInput("Enter your username: ");
        String password = InputHelper.getStringInput("Enter your password: ");

        try {
            switch (role) {
                case 1 -> { // Register as a teacher
                    String name = InputHelper.getStringInput("Enter your name: "); // Get teacher's name
                    SchoolData.getTeachers().add(new Teacher(name, username, password)); // Create Teacher object
                    SchoolData.saveTeachers(); // Save teacher data
                    System.out.println("Teacher registered successfully!");
                }
                case 2 -> { // Register as a student
                    String name = InputHelper.getStringInput("Enter your name: ");
                    String id = InputHelper.getStringInput("Enter your student ID: ");
                    SchoolData.getStudents().add(new Student(name, id, username, password)); // Create Student object
                    SchoolData.saveStudents(); // Save student data
                    System.out.println("Student registered successfully!");
                }
                default -> System.out.println("Invalid role.");
            }
        } catch (Exception e) {
            System.out.println("Registration failed: " + e.getMessage());
        }
    }

    // login: Handles the user login process.
    private void login() {
        List<String> loginOptions = List.of("Teacher", "Student", "Go Back");
        InputHelper.displayMenu("Login as", loginOptions); // Display login options
        int role = InputHelper.getIntInput("Choice: ");      // Get user's role choice

        if (role == 3) {
            System.out.println("Returning to main menu.");
            return; // Go back to the main menu
        }

        switch (role) {
            case 1 -> loggedInTeacher = TeacherLogin.login(); // Handle teacher login
            case 2 -> { // Handle student login
                loggedInStudent = StudentLogin.login();
                // Fetch the complete student object after basic login validation
                if (loggedInStudent != null) {
                    loggedInStudent = SchoolData.getStudents().stream()
                            .filter(s -> s.getUsername().equals(loggedInStudent.getUsername()))
                            .findFirst()
                            .orElse(null);
                }
            }
            default -> System.out.println("Invalid role.");
        }
    }

    // saveAllData: Saves all data to persistent storage.
    private void saveAllData() {
        SchoolData.saveStudents();
        SchoolData.saveAssignments();
        SchoolData.saveLessons();
        SchoolData.saveAnnouncements();
        SchoolData.saveGrades();
        SchoolData.saveSubjects();
        SchoolData.saveTeachers();
    }
}