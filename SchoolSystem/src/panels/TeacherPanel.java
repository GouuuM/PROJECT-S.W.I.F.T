package panels;

import java.io.IOException;
import java.util.List;
import models.*;
import utility.FileManager;
import utility.InputHelper;

public class TeacherPanel {
    // run:  Executes the teacher panel, providing options and handling teacher actions.
    public static void run(Teacher teacher) {
        while (true) { // Main teacher panel loop
            List<String> teacherMenuOptions = List.of(
                    "Subject",
                    "Student",
                    "Assignment",
                    "Activity",
                    "Lesson",
                    "Announcement",
                    "Logout"
            );
            InputHelper.displayMenu("Teacher Panel - " + teacher.getName(), teacherMenuOptions); // Display teacher menu
            int choice = InputHelper.getIntInput("Choice: "); // Get teacher's menu choice

            switch (choice) {
                case 1 -> handleSubjectMenu();     // Handle subject-related actions
                case 2 -> handleStudentMenu();     // Handle student-related actions
                case 3 -> handleAssignmentMenu();  // Handle assignment-related actions
                case 4 -> handleActivityMenu();    // Handle activity-related actions
                case 5 -> handleLessonMenu();      // Handle lesson-related actions
                case 6 -> handleAnnouncementMenu(); // Handle announcement-related actions
                case 7 -> {                      // Handle logout
                    System.out.println("Logging out...");
                    return;                     // Return to the main menu
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // handleStudentMenu:  Handles the student sub-menu options.
    private static void handleStudentMenu() {
        while (true) { // Student sub-menu loop
            List<String> studentMenuOptions = List.of(
                    "Remove Student",
                    "View Students",
                    "Grade Student",
                    "Remove Student Grade",
                    "Back to Main Menu"
            );
            InputHelper.displayMenu("Student Menu", studentMenuOptions); // Display student menu
            int studentChoice = InputHelper.getIntInput("Choice: ");    // Get student menu choice

            switch (studentChoice) {
                case 1 -> removeStudent();       // Remove a student
                case 2 -> viewStudents();        // View all students
                case 3 -> gradeStudent();        // Grade a student
                case 4 -> removeStudentGrade();  // Remove a student's grade
                case 5 -> {                     // Go back to the main menu
                    System.out.println("Returning to Teacher Main Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // handleLessonMenu:  Handles the lesson sub-menu options.
    private static void handleLessonMenu() {
        while (true) { // Lesson sub-menu loop
            List<String> lessonMenuOptions = List.of(
                    "Add Lesson",
                    "Remove Lesson",
                    "Back to Main Menu"
            );
            InputHelper.displayMenu("Lesson Menu", lessonMenuOptions); // Display lesson menu
            int lessonChoice = InputHelper.getIntInput("Choice: ");    // Get lesson menu choice

            switch (lessonChoice) {
                case 1 -> addLesson();       // Add a lesson
                case 2 -> removeLesson();    // Remove a lesson
                case 3 -> {                 // Go back to the main menu
                    System.out.println("Returning to Teacher Main Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // handleAnnouncementMenu:  Handles the announcement sub-menu options.
    private static void handleAnnouncementMenu() {
        while (true) { // Announcement sub-menu loop
            List<String> announcementMenuOptions = List.of(
                    "Add Announcement",
                    "Remove Announcement",
                    "Back to Main Menu"
            );
            InputHelper.displayMenu("Announcement Menu", announcementMenuOptions); // Display announcement menu
            int announcementChoice = InputHelper.getIntInput("Choice: ");           // Get announcement menu choice

            switch (announcementChoice) {
                case 1 -> addAnnouncement();    // Add an announcement
                case 2 -> removeAnnouncement(); // Remove an announcement
                case 3 -> {                  // Go back to the main menu
                    System.out.println("Returning to Teacher Main Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // handleSubjectMenu:  Handles the subject sub-menu options.
    private static void handleSubjectMenu() {
        while (true) { // Subject sub-menu loop
            List<String> subjectMenuOptions = List.of(
                    "Add Subject",
                    "Remove Subject",
                    "Back to Main Menu"
            );
            InputHelper.displayMenu("Subject Menu", subjectMenuOptions); // Display subject menu
            int subjectChoice = InputHelper.getIntInput("Choice: ");    // Get subject menu choice

            switch (subjectChoice) {
                case 1 -> addSubject();       // Add a subject
                case 2 -> removeSubject();    // Remove a subject
                case 3 -> {                 // Go back to the main menu
                    System.out.println("Returning to Teacher Main Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // handleAssignmentMenu:  Handles the assignment sub-menu options.
    private static void handleAssignmentMenu() {
        while (true) { // Assignment sub-menu loop
            List<String> assignmentMenuOptions = List.of(
                    "Give Assignment",
                    "Remove Assignment",
                    "Grade Assignment",
                    "Back to Main Menu"
            );
            InputHelper.displayMenu("Assignment Menu", assignmentMenuOptions); // Display assignment menu
            int assignmentChoice = InputHelper.getIntInput("Choice: ");       // Get assignment menu choice

            switch (assignmentChoice) {
                case 1 -> giveAssignment();      // Give an assignment
                case 2 -> removeAssignment();    // Remove an assignment
                case 3 -> gradeAssignment();     // Grade an assignment
                case 4 -> {                    // Go back to the main menu
                    System.out.println("Returning to Teacher Main Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // handleActivityMenu:  Handles the activity sub-menu options.
    private static void handleActivityMenu() {
        while (true) { // Activity sub-menu loop
            List<String> activityMenuOptions = List.of(
                    "Give Activity",
                    "Remove Activity",
                    "Grade Activity",
                    "Back to Main Menu"
            );
            InputHelper.displayMenu("Activity Menu", activityMenuOptions); // Display activity menu
            int activityChoice = InputHelper.getIntInput("Choice: ");       // Get activity menu choice

            switch (activityChoice) {
                case 1 -> giveActivity();      // Give an activity
                case 2 -> removeActivity();    // Remove an activity
                case 3 -> gradeActivity();     // Grade an activity
                case 4 -> {                    // Go back to the main menu
                    System.out.println("Returning to Teacher Main Menu...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    // addSubject:  Adds a new subject.
    private static void addSubject() {
        String code = InputHelper.getStringInput("Enter subject code: ");
        String name = InputHelper.getStringInput("Enter subject name: ");
        String description = InputHelper.getStringInput("Enter subject description: ");
        String schedule = InputHelper.getStringInput("Enter subject schedule: ");
        SchoolData.getSubjects().add(new Subject(code, name, description, schedule)); // Create a new subject
        SchoolData.saveSubjects();                                                  // Save the updated subject list
        System.out.println("Subject added.");
    }

    // removeSubject:  Removes a subject.
    private static void removeSubject() {
        String code = InputHelper.getStringInput("Enter subject code to remove: ");
        Subject subjectToRemove = null;
        for (Subject subject : SchoolData.getSubjects()) { // Find the subject to remove
            if (subject.getCode().equalsIgnoreCase(code)) {
                subjectToRemove = subject;
                break;
            }
        }
        if (subjectToRemove != null) {
            SchoolData.getSubjects().removeIf(subject -> subject.getCode().equalsIgnoreCase(code)); // Remove the subject
            SchoolData.saveSubjects(); // Save the updated subject list
            System.out.println("Subject removed.");
        } else {
            System.out.println("Subject not found.");
        }
    }

    // removeStudent:  Removes a student.
    private static void removeStudent() {
        String studentId = InputHelper.getStringInput("Enter student ID to remove: ");
        Student studentToRemove = SchoolData.findStudentById(studentId); // Find the student by ID
        if (studentToRemove != null) {
            SchoolData.getStudents().remove(studentToRemove); // Remove the student
            SchoolData.saveStudents();                       // Save the updated student list
            System.out.println("Student removed.");
        } else {
            System.out.println("Student not found.");
        }
    }

    // viewStudents:  Displays all students.
    private static void viewStudents() {
        if (SchoolData.getStudents().isEmpty()) {
            System.out.println("No students available.");
        } else {
            System.out.println("\n--- Students ---");
            for (Student student : SchoolData.getStudents()) { // Iterate through all students
                System.out.println("Name: " + student.getName() + ", ID: " + student.getId());
            }
        }
    }

    // giveAssignment:  Creates and assigns an assignment to students.
    private static void giveAssignment() {
        // Display subjects for selection
        System.out.println("\n--- Available Subjects ---");
        List<Subject> subjects = SchoolData.getSubjects();
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println((i + 1) + ". " + subjects.get(i).getName() + " (" + subjects.get(i).getCode() + ")");
        }
        int subjectChoice = InputHelper.getIntInput("Select subject for assignment: ") - 1;
        if (subjectChoice >= 0 && subjectChoice < subjects.size()) {
            String subjectCode = subjects.get(subjectChoice).getCode();
            String title = InputHelper.getStringInput("Enter assignment title: ");
            String instructions = InputHelper.getStringInput("Enter instructions: ");
            SchoolData.getAssignments().add(new Assignment(title, instructions, subjectCode));
            SchoolData.saveAssignments();
            System.out.println("Assignment added for subject " + subjectCode + ".");
        } else {
            System.out.println("Invalid subject selection.");
        }
    }

    // removeAssignment:  Removes an assignment.
    private static void removeAssignment() {
        String title = InputHelper.getStringInput("Enter assignment title to remove: ");
        Assignment assignmentToRemove = null;
        for (Assignment assignment : SchoolData.getAssignments()) {
            if (assignment.getTitle().equalsIgnoreCase(title)) {
                assignmentToRemove = assignment;
                break;
            }
        }

        if (assignmentToRemove != null) {
            SchoolData.getAssignments().remove(assignmentToRemove);

             // Remove the assignment from each student's list
            for (Student student : SchoolData.getStudents()) {
                student.getAssignment().remove(assignmentToRemove);
            }
            SchoolData.saveAssignments();
            System.out.println("Assignment removed.");
        } else {
            System.out.println("Assignment not found.");
        }
    }

    // gradeAssignment:  Grades a student's assignment.
    private static void gradeAssignment() {
        String titleToGrade = InputHelper.getStringInput("Enter assignment title to grade: ");
        Assignment assignmentToGrade = null;
        for (Assignment assignment : SchoolData.getAssignments()) {
            if (assignment.getTitle().equalsIgnoreCase(titleToGrade)) {
                assignmentToGrade = assignment;
                break;
            }
        }

        if (assignmentToGrade != null) {
            String studentId = InputHelper.getStringInput("Enter student ID: ");
            String grade = InputHelper.getStringInput("Enter grade for " + studentId + ": ");
            assignmentToGrade.setGrade(grade);
        
            // Find the student to save the grade to their file
            Student student = SchoolData.findStudentById(studentId);
            if (student != null) {
                try {
                    String filename = "grades_" + student.getUsername() + ".txt";
                    String entry = assignmentToGrade.getTitle() + "," + grade;
                    FileManager.addRawEntry(filename, entry);
                    System.out.println("Assignment graded and grade saved.");
                } catch (IOException e) {
                    System.out.println("Error saving grade: " + e.getMessage());
                }
                } else {
                    System.out.println("Student not found.");
                }
            } else {
                System.out.println("Assignment not found.");
        }
    }

    // giveActivity:  Creates and assigns an activity to students.
    private static void giveActivity() {
        // Display subjects for selection
        System.out.println("\n--- Available Subjects ---");
        List<Subject> subjects = SchoolData.getSubjects();
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println((i + 1) + ". " + subjects.get(i).getName() + " (" + subjects.get(i).getCode() + ")");
        }
        int subjectChoice = InputHelper.getIntInput("Select subject for activity: ") - 1;
        if (subjectChoice >= 0 && subjectChoice < subjects.size()) {
            String subjectCode = subjects.get(subjectChoice).getCode();
            String title = InputHelper.getStringInput("Enter activity title: ");
            String instructions = InputHelper.getStringInput("Enter instructions: ");
            SchoolData.getActivities().add(new Activity(title, instructions, subjectCode));
            SchoolData.saveActivities();
            System.out.println("Activity added for subject " + subjectCode + ".");
        } else {
            System.out.println("Invalid subject selection.");
        }
    }

    // removeActivity:  Removes an activity.
    private static void removeActivity() {
        String titleToRemove = InputHelper.getStringInput("Enter activity title to remove: ");
        Activity activityToRemove = null;
        for (Activity activity : SchoolData.getActivities()) {
            if (activity.getTitle().equalsIgnoreCase(titleToRemove)) {
                activityToRemove = activity;
                break;
            }
        }

        if (activityToRemove != null) {
            SchoolData.getActivities().remove(activityToRemove);
             for (Student student : SchoolData.getStudents()) {
                student.getAssignment().remove(activityToRemove);
            }
            SchoolData.saveActivities();
            System.out.println("Activity removed.");
        } else {
            System.out.println("Activity not found.");
        }
    }

    // gradeActivity:  Grades a student's activity.
    private static void gradeActivity() {
        String titleToGrade = InputHelper.getStringInput("Enter activity title to grade: ");
        Activity activityToGrade = null;
        for (Activity activity : SchoolData.getActivities()) {
            if (activity.getTitle().equalsIgnoreCase(titleToGrade)) {
                activityToGrade = activity;
                break;
            }
        }

        if (activityToGrade != null) {
            String studentId = InputHelper.getStringInput("Enter student ID: ");
            String grade = InputHelper.getStringInput("Enter grade for " + studentId + ": ");
            activityToGrade.setGrade(grade);

        // Find the student to save the grade to their file
        Student student = SchoolData.findStudentById(studentId);
        if (student != null) {
            try {
                String filename = "grades_" + student.getUsername() + ".txt";
                String entry = activityToGrade.getTitle() + "," + grade;
                FileManager.addRawEntry(filename, entry);
                System.out.println("Activity graded and grade saved.");
            } catch (IOException e) {
                System.out.println("Error saving grade: " + e.getMessage());
            }
            } else {
                System.out.println("Student not found.");
            }
        } else {
            System.out.println("Activity not found.");
        }
    }

    // addLesson:  Adds a lesson.
    private static void addLesson() {
        // Display subjects for selection
        System.out.println("\n--- Available Subjects ---");
        List<Subject> subjects = SchoolData.getSubjects();
        for (int i = 0; i < subjects.size(); i++) {
            System.out.println((i + 1) + ". " + subjects.get(i).getName() + " (" + subjects.get(i).getCode() + ")");
        }
        int subjectChoice = InputHelper.getIntInput("Select subject for lesson plan: ") - 1;
        if (subjectChoice >= 0 && subjectChoice < subjects.size()) {
            String subjectCode = subjects.get(subjectChoice).getCode();
            String title = InputHelper.getStringInput("Enter lesson plan title: ");
            String content = InputHelper.getStringInput("Enter lesson plan content: ");
            SchoolData.getLessons().add(new Lesson(title, content, subjectCode)); // Pass subjectCode
            SchoolData.saveLessons();
            System.out.println("Lesson plan added for subject " + subjectCode + ".");
        } else {
            System.out.println("Invalid subject selection.");
        }
    }

    // removeLesson:  Removes a lesson.
    private static void removeLesson() {
        String titleToRemove = InputHelper.getStringInput("Enter lesson plan title to remove: ");
        Lesson lessonToRemove = null;
        for (Lesson lesson : SchoolData.getLessons()) {
            if (lesson.getTitle().equalsIgnoreCase(titleToRemove)) {
                lessonToRemove = lesson;
                break;
            }
        }
        if (lessonToRemove != null) {
            SchoolData.getLessons().remove(lessonToRemove);
            SchoolData.saveLessons();
            System.out.println("Lesson removed.");
        } else {
            System.out.println("Lesson not found.");
        }
    }

    // gradeStudent:  Assigns a grade to a student.
    private static void gradeStudent() {
        String studentId = InputHelper.getStringInput("Enter student ID: ");
        String score = InputHelper.getStringInput("Enter grade/score: ");
        System.out.println("Grade added for student " + studentId + " with score " + score);
    }

    // removeStudentGrade:  Removes a student's grade.
    private static void removeStudentGrade() {
        String studentId = InputHelper.getStringInput("Enter student ID to remove grade: ");
        System.out.println("Grade removed for student " + studentId);
    }

    // addAnnouncement:  Adds an announcement.
    private static void addAnnouncement() {
        String message = InputHelper.getStringInput("Enter announcement message: ");
        SchoolData.getAnnouncements().add(new Announcement(message));
        SchoolData.saveAnnouncements();
        System.out.println("Announcement added.");
    }

    // removeAnnouncement:  Removes an announcement.
    private static void removeAnnouncement() {
        String message = InputHelper.getStringInput("Enter announcement message to remove: ");
        Announcement announcementToRemove = null;
        for (Announcement announcement : SchoolData.getAnnouncements()) {
            if (announcement.getMessage().equalsIgnoreCase(message)) {
                announcementToRemove = announcement;
                break;
            }
        }

        if (announcementToRemove != null) {
            SchoolData.getAnnouncements().remove(announcementToRemove);
            SchoolData.saveAnnouncements();
            System.out.println("Announcement removed.");
        } else {
            System.out.println("Announcement not found.");
        }
    }
}