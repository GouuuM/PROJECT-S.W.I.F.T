package models;

public class Grade {
    private String studentId;
    private String score;

    // Constructor: Creates a Grade object with student ID and score.
    public Grade(String studentId, String score) {
        this.studentId = studentId;
        this.score = score;
    }

    // Getter: Retrieves the student's ID.
    public String getStudentId() {
        return studentId;
    }

    // Getter: Retrieves the grade score.
    public String getScore() {
        return score;
    }

    // Setter: Modifies the grade score.
    public void setScore(String score) {
        this.score = score;
    }

    // toString: Provides a string representation of the Grade object.
    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Grade: " + score;
    }
}