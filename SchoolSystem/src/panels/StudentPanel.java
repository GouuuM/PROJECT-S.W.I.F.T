package panels;

import java.io.IOException;
import java.util.List;
import models.*;
import utility.FileManager;
import utility.InputHelper;

//  Handles the student's interactive panel within the application.
public class StudentPanel {

    // run:  Executes the student panel, providing options and handling student actions.
    public static void run(Student student) {
        while (true) {
            List<String> studentMenuOptions = List.of(
                    "Enroll in Subject",
                    "View Enrolled Subjects",
                    "Assignments",
                    "Activities",
                    "View Lessons",
                    "View Announcements",
                    "View All Subjects",
                    "Logout"
            );
            InputHelper.displayMenu("Student Panel - " + student.getName(), studentMenuOptions);
            int choice = InputHelper.getIntInput("Choice: ");

            try {
                switch (choice) {
                    case 1 -> enrollInSubject(student);
                    case 2 -> viewEnrolledSubjects(student);
                    case 3 -> handleAssignments(student);
                    case 4 -> handleActivities(student);
                    case 5 -> viewLesson();
                    case 6 -> viewAnnouncements();
                    case 7 -> viewAllSubjects();
                    case 8
                     -> {
                        System.out.println("Logging out...");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    // enrollInSubject:  Allows a student to enroll in a subject.
    private static void enrollInSubject(Student student) {
        String subjectCode = InputHelper.getStringInput("Enter the subject code to enroll: ");
        Subject subject = SchoolData.getSubjects().stream()
                .filter(s -> s.getCode().equalsIgnoreCase(subjectCode))
                .findFirst()
                .orElse(null);

        if (subject != null) {
            if (!student.getEnrolledSubjects().contains(subjectCode)) {
                student.getEnrolledSubjects().add(subjectCode);
                System.out.println("Successfully enrolled in subject: " + subjectCode);
            } else {
                System.out.println("Already enrolled in this subject.");
            }
        } else {
            System.out.println("Subject not found.");
        }
    }

    // viewEnrolledSubjects:  Displays the subjects a student is currently enrolled in.
    private static void viewEnrolledSubjects(Student student) {
        List<String> enrolledSubjects = student.getEnrolledSubjects();
        if (enrolledSubjects.isEmpty()) {
            System.out.println("You are not currently enrolled in any subjects.");
        } else {
            System.out.println("\n--- Enrolled Subjects ---");
            for (String subjectCode : enrolledSubjects) {
                System.out.println("- " + subjectCode);
            }
        }
    }

    // handleAssignments:  Handles student interactions with assignments (answer or remove).
    private static void handleAssignments(Student student) {
        while (true) { // Assignment Sub-menu loop
            List<String> assignmentOptions = List.of("Answer Assignment", "Remove Assignment", "View Graded Assignment", "Go Back");
            InputHelper.displayMenu("Assignments", assignmentOptions);
            int choice = InputHelper.getIntInput("Choice: ");

            switch (choice) {
                case 1 -> answerAssignment(student);
                case 2 -> removeAssignment(student);
                case 3 -> viewGradedAssignment(student);
                case 4 -> {
                    System.out.println("Returning to Student Main Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }    
    }

    // answerAssignment:  Allows a student to submit an answer to an assignment.
    private static void answerAssignment(Student student) {
        String assignmentTitle = InputHelper.getStringInput("Enter the assignment title: ");
        String answer = InputHelper.getStringInput("Enter your answer: ");
        System.out.println("Answer submitted for assignment: " + assignmentTitle + " - Answer: " + answer);
    }

    // removeAssignment:  Allows a student to remove a submitted assignment.
    private static void removeAssignment(Student student) {
        String assignmentTitle = InputHelper.getStringInput("Enter the title of the assignment to remove: ");
        System.out.println("Attempting to remove assignment: " + assignmentTitle);
    }

    // viewGradedAssignment: Allows a student to view their graded assignment.
    private static void viewGradedAssignment(Student student) {
        String assignmentTitle = InputHelper.getStringInput("Enter the title of the assignment to view the grade: ");
        try {
            List<String> grades = FileManager.readFile("grades_" + student.getUsername() + ".txt");
            boolean found = false;
            for (String gradeInfo : grades) {
                String[] parts = gradeInfo.split(",");
                if (parts.length == 2 && parts[0].trim().equalsIgnoreCase(assignmentTitle)) {
                    System.out.println("Grade for " + assignmentTitle + ": " + parts[1].trim());
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Grade not found for assignment: " + assignmentTitle);
            }
        } catch (IOException e) {
            System.out.println("Error viewing grades: " + e.getMessage());
        }
    }

    // handleActivities:  Handles student interactions with activities (answer, remove or view graded answer).
    private static void handleActivities(Student student) {
        while (true) { // Activity Sub-menu loop
            List<String> activityOptions = List.of("Answer Activity", "Remove Activity", "View Graded Activity", "Go Back");
            InputHelper.displayMenu("Activities", activityOptions);
            int choice = InputHelper.getIntInput("Choice: ");

            switch (choice) {
                case 1 -> answerActivity(student);
                case 2 -> removeActivity(student);
                case 3 -> viewGradedActivity(student);
                case 4 -> {
                    System.out.println("Returning to Student Main Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
    // answerActivity: Allows a student to submit an answer to an activity.
    private static void answerActivity(Student student) {
        String activityTitle = InputHelper.getStringInput("Enter the activity title: ");
        String answer = InputHelper.getStringInput("Enter your answer: ");
        System.out.println("Answer submitted for activity: " + activityTitle + " - Answer: " + answer);
    }

    // removeActivity: Allows a student to remove their answer to an activity.
    private static void removeActivity(Student student) {
        String activityTitle = InputHelper.getStringInput("Enter the title of the activity to remove: ");
        System.out.println("Attempting to remove activity: " + activityTitle);
    }

    // viewgradedActivity: Allows a student to view their graded activity.
    private static void viewGradedActivity(Student student) {
    String activityTitle = InputHelper.getStringInput("Enter the title of the activity to view the grade: ");
    try {
        List<String> grades = FileManager.readFile("grades_" + student.getUsername() + ".txt");
        boolean found = false;
        for (String gradeInfo : grades) {
            String[] parts = gradeInfo.split(",");
            if (parts.length == 2 && parts[0].trim().equalsIgnoreCase(activityTitle)) {
                System.out.println("Grade for " + activityTitle + ": " + parts[1].trim());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Grade not found for activity: " + activityTitle);
        }
    } catch (IOException e) {
        System.out.println("Error viewing grades: " + e.getMessage());
    }
}

    // viewLesson:  Displays lesson plans.
    private static void viewLesson() {
        try {
            utility.FileManager.viewFile("lessons_data.txt");
        } catch (java.io.IOException e) {
            System.out.println("Error viewing lesson: " + e.getMessage());
        }
    }

    // viewAnnouncements:  Displays school announcements.
    private static void viewAnnouncements() {
        try {
            utility.FileManager.viewFile("announcements.txt");
        } catch (java.io.IOException e) {
            System.out.println("Error viewing announcements: " + e.getMessage());
        }
    }

    // viewAllSubjects:  Displays all available subjects.
    private static void viewAllSubjects() {
        List<Subject> allSubjects = SchoolData.getSubjects();
        if (allSubjects.isEmpty()) {
            System.out.println("No subjects available.");
        } else {
            System.out.println("\n--- All Subjects ---");
            for (Subject subject : allSubjects) {
                System.out.println("Code: " + subject.getCode());
                System.out.println("Name: " + subject.getName());
                System.out.println("Description: " + subject.getDescription());
                System.out.println("Schedule: " + subject.getSchedule());
                System.out.println("-----------------------");
            }
        }
    }
}