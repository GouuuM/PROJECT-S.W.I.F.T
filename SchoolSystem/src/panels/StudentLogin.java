package panels;

import models.Student;
import utility.FileManager;
import utility.InputHelper;

// Handles student login functionality.
public class StudentLogin {

    // login: Handles student login and returns a Student object if successful.
    public static Student login() {
        String username = InputHelper.getStringInput("Enter username: ");
        String password = InputHelper.getStringInput("Enter password: ");
        System.out.println("Attempting student login for user: " + username); // Added logging
        try {
            // Validate the provided credentials against stored student data.
            if (FileManager.validateCredentials("students_data.txt", username, password)) {
                System.out.println("Student login successful based on credentials."); // Added logging
                return new Student(username, password); // Assuming the basic constructor is sufficient for login
            } else {
                System.out.println("Invalid student credentials."); // Added logging
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error during student login: " + e.getMessage());
            return null;
        }
    }
}