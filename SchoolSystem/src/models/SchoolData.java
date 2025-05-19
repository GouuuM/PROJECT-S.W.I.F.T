package models;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import utility.FileManager;

public class SchoolData {
    public static List<Activity> activities = new ArrayList<>();
    public static List<Announcement> announcements = new ArrayList<>();
    public static List<Assignment> assignments = new ArrayList<>();
    public static List<Grade> grades = new ArrayList<>();
    public static List<Lesson> lessons = new ArrayList<>();
    public static List<Student> students = new ArrayList<>();
    public static List<Subject> subjects = new ArrayList<>();
    public static List<Teacher> teachers = new ArrayList<>();

    private static final String STUDENTS_FILE = "students_data.txt";
    private static final String ASSIGNMENTS_FILE = "assignments_data.txt";
    private static final String LESSONS_FILE = "lessons_data.txt";
    private static final String ANNOUNCEMENTS_FILE = "announcements.txt";
    private static final String GRADES_FILE = "grades_data.txt";
    private static final String ACTIVITIES_FILE = "activities.txt";
    private static final String SUBJECTS_FILE = "subjects_data.txt";
    private static final String TEACHERS_FILE = "teachers_data.txt";

    // Static initializer: Loads initial subjects and teachers.
    static {
        loadSubjects();
        loadTeachers(); // Load teachers on startup
    }

    // loadData: Generic method to load data from a file into a list.
    private static <T> void loadData(String filename, Function<String[], T> mapper, List<T> targetList) {
        targetList.clear();
        try {
            List<String> lines = FileManager.readFile(filename);
            for (String line : lines) {
                String[] parts = line.split(",");
                T item = mapper.apply(parts);
                if (item != null) {
                    targetList.add(item);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading data from " + filename + ": " + e.getMessage());
        }
    }

    // saveData: Generic method to save data from a list to a file.
    private static <T> void saveData(String filename, Function<T, String> mapper, List<T> sourceList) {
        List<String> lines = new ArrayList<>();
        for (T item : sourceList) {
            lines.add(mapper.apply(item));
        }
        try {
            FileManager.writeFile(filename, lines);
        } catch (IOException e) {
            System.out.println("Error saving data to " + filename + ": " + e.getMessage());
        }
    }

    // loadStudents: Loads student data from file.
    public static void loadStudents() {
        loadData(STUDENTS_FILE, parts ->
                        parts.length == 4 ? new Student(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim()) : null,
                students);
    }

    // saveStudents: Saves student data to file.
    public static void saveStudents() {
        saveData(STUDENTS_FILE, student ->
                        student.getName() + "," + student.getId() + "," + student.getUsername() + "," + student.getPassword(),
                students);
    }

    // loadAssignments: Loads assignment data from file.
    public static void loadAssignments() {
        loadData(ASSIGNMENTS_FILE, parts ->
                        parts.length == 3 ? new Assignment(parts[0].trim(), parts[1].trim(), parts[2].trim()) : null,
                assignments);
    }

    // saveAssignments: Saves assignment data to file.
    public static void saveAssignments() {
        saveData(ASSIGNMENTS_FILE, assignment ->
                        assignment.getTitle() + "," + assignment.getInstructions() + "," + assignment.getSubjectCode(),
                assignments);
    }
    

    // loadLessons: Loads lesson data from file.
    public static void loadLessons() {
        loadData(LESSONS_FILE, parts ->
                        parts.length == 3 ? new Lesson(parts[0].trim(), parts[1].trim(), parts[3].trim()) : null,
                lessons);
    }

    // saveLessons: Saves lesson data to file.
    public static void saveLessons() {
        saveData(LESSONS_FILE, lesson ->
                        lesson.getTitle() + "," + lesson.getContent() + "," + lesson.getSubjectCode(),
                lessons);
    }

    // loadAnnouncements: Loads announcement data from file.
    public static void loadAnnouncements() {
        loadData(ANNOUNCEMENTS_FILE, parts ->
                        parts.length == 1 ? new Announcement(parts[0].trim()) : null,
                announcements);
    }

    // saveAnnouncements: Saves announcement data to file.
    public static void saveAnnouncements() {
        saveData(ANNOUNCEMENTS_FILE, announcement ->
                        announcement.getMessage(),
                announcements);
    }

    // loadGrades: Loads grade data from file.
    public static void loadGrades() {
        loadData(GRADES_FILE, parts ->
                        parts.length == 2 ? new Grade(parts[0].trim(), parts[1].trim()) : null,
                grades);
    }

    // saveGrades: Saves grade data to file.
    public static void saveGrades() {
        saveData(GRADES_FILE, grade ->
                        grade.getStudentId() + "," + grade.getScore(),
                grades);
    }

    // loadActivities: Loads activity data from file.
    public static void loadActivities() {
        loadData(ACTIVITIES_FILE, parts ->
                        parts.length == 3 ? new Activity(parts[0].trim(), parts[1].trim(), parts[2].trim()) : null,
                activities);
    }

    // saveActivities: Saves activity data to file.
    public static void saveActivities() {
        saveData(ACTIVITIES_FILE, activity ->
                        activity.getTitle() + "," + activity.getInstructions() + "," + activity.getSubjectCode(),
                activities);
    }

    // loadSubjects: Loads subject data from file.
    public static void loadSubjects() {
        loadData(SUBJECTS_FILE, parts ->
                        parts.length == 4 ? new Subject(parts[0].trim(), parts[1].trim(), parts[2].trim(), parts[3].trim()) : null,
                subjects);
    }

    // saveSubjects: Saves subject data to file.
    public static void saveSubjects() {
        saveData(SUBJECTS_FILE, subject ->
                        subject.getCode() + "," + subject.getName() + "," + subject.getDescription() + "," + subject.getSchedule(),
                subjects);
    }

    // findStudentById: Finds a student by their ID.
    public static Student findStudentById(String id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // getStudents: Retrieves the list of all students.
    public static List<Student> getStudents() {
        return students;
    }

    // getAssignments: Retrieves the list of all assignments.
    public static List<Assignment> getAssignments() {
        return assignments;
    }

    // getLessons: Retrieves the list of all lessons.
    public static List<Lesson> getLessons() {
        return lessons;
    }

    // getAnnouncements: Retrieves the list of all announcements.
    public static List<Announcement> getAnnouncements() {
        return announcements;
    }

    // getGrades: Retrieves the list of all grades.
    public static List<Grade> getGrades() {
        return grades;
    }

    // getActivities: Retrieves the list of all activities.
    public static List<Activity> getActivities() {
        return activities;
    }

    // getSubjects: Retrieves the list of all subjects.
    public static List<Subject> getSubjects() {
        return subjects;
    }

    // getTeachers: Retrieves the list of all teachers.
    public static List<Teacher> getTeachers() {
        return teachers;
    }

    // loadTeachers: Loads teacher data from file.
    public static void loadTeachers() {
        loadData(TEACHERS_FILE, parts ->
                        parts.length == 3 ? new Teacher(parts[0].trim(), parts[1].trim(), parts[2].trim()) : null,
                teachers);
    }

    // saveTeachers: Saves teacher data to file.
    public static void saveTeachers() {
        saveData(TEACHERS_FILE, teacher ->
                        teacher.getName() + "," + teacher.getUsername() + "," + teacher.getPassword(),
                teachers);
    }

    // findTeacherByUsername: Finds a teacher by their username.
    public static Teacher findTeacherByUsername(String username) {
        return teachers.stream()
                .filter(teacher -> teacher.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }
}