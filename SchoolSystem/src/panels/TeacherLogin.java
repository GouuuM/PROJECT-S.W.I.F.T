package panels;

import models.SchoolData;
import models.Teacher;
import utility.FileManager;
import utility.InputHelper;

// Handles teacher login functionality.
public class TeacherLogin {

    // login: Handles teacher login and returns a Teacher object if successful.
    public static Teacher login() {
        String username = InputHelper.getStringInput("Enter username: "); // Get username from the user
        String password = InputHelper.getStringInput("Enter password: "); // Get password from the user
        System.out.println("Attempting login for user: " + username); // Log the attempted login

        try {
            // Validate the provided credentials against stored teacher data.
            if (FileManager.validateCredentials("teachers_data.txt", username, password)) {
                // Fetch the Teacher object from SchoolData using the username.
                Teacher loggedInTeacher = SchoolData.findTeacherByUsername(username);
                if (loggedInTeacher != null) {
                    System.out.println("Login successful.");
                    return loggedInTeacher; // Return the logged-in Teacher object
                } else {
                    System.out.println("Error: Teacher not found after successful credential validation.");
                    return null; // Return null if teacher not found
                }
            } else {
                System.out.println("Invalid credentials.");
                return null; // Return null for invalid credentials
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null; // Return null in case of an error
        }
    }
}