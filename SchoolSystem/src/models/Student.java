package models;

import java.util.ArrayList;
import java.util.List;

// Represents a student in the school system.
public class Student extends User {
    private String name; // The student's name.
    private String id;   // The student's unique identifier.
    private List<Assignment> assignment; // List of assignments associated with the student.
    private List<Assignment> activity; // List of activities associated with the student.
    private List<String> enrolledSubjects; // List of subject codes the student is enrolled in.

    // Constructor: Creates a Student object with default name and ID.
    public Student(String username, String password) {
        super(username, password); // Calls the constructor of the User class.
        this.name = "N/A";
        this.id = "N/A";
        this.assignment = new ArrayList<>();
        this.activity = new ArrayList<>();
        this.enrolledSubjects = new ArrayList<>();
    }

    // Constructor: Creates a Student object with specified name, ID, username, and password.
    public Student(String name, String id, String username, String password) {
        super(username, password); // Calls the constructor of the User class.
        this.name = name;
        this.id = id;
        this.assignment = new ArrayList<>();
        this.activity = new ArrayList<>();
        this.enrolledSubjects = new ArrayList<>();
    }

    // Getter: Retrieves the student's name.
    public String getName() {
        return name;
    }

    // Getter: Retrieves the student's ID.
    public String getId() {
        return id;
    }

    // Getter: Retrieves the list of assignments for the student.
    public List<Assignment> getAssignment() {
        return assignment;
    }

    // Getter: Retrieves the list of activity for the student.
    public List<Assignment> getActivity() {
        return activity;
    }

    // Getter: Retrieves the list of subjects the student is enrolled in.
    public List<String> getEnrolledSubjects() {
        return enrolledSubjects;
    }
}