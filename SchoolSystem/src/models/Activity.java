package models;

public class Activity {
    String title; // Name of the activity
    String instructions; // How to do the activity
    String answer; // Student's response
    String grade; // Evaluation of the answer
    private String subjectCode; // To store the subject code

    // Constructor: Creates an activity with a title and instructions.
    public Activity(String title, String instructions, String subjectCode) {
        this.title = title;
        this.instructions = instructions;
        this.subjectCode = subjectCode;
    }

    // Getter: Gets the activity's name.
    public String getTitle() {
        return title;
    }

    // Getter: Gets the activity's instructions.
    public String getInstructions() {
        return instructions;
    }

    // Setter: Sets the student's answer.
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    // Setter: Sets the grade for the activity.
    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Getter: Gets the grade for the activity.
    public String getGrade() {
        return grade;
    }

    // Getter: Gets the subject code for the subject.
    public String getSubjectCode() {
        return subjectCode;
    }
}