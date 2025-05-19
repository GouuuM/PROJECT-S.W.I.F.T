package models;

public class Lesson {
    private String title;
    private String content;
    private String subjectCode;

    // Constructor: Creates a Lesson object with title and content.
    public Lesson(String title, String content, String subjectCode) {
        this.title = title;
        this.content = content;
        this.subjectCode = "";
    }

    // Getter: Retrieves the lesson title.
    public String getTitle() {
        return title;
    }

    // Getter: Retrieves the lesson content.
    public String getContent() {
        return content;
    }

    // Setter: Modifies the lesson content.
    public void setContent(String content) {
        this.content = content;
    }

    // Getter: Gets the subject code for the subject.
    public String getSubjectCode() {
        return subjectCode;
    }

    // Setter: Setter for subjectCode
    public String setSubjectCode(String subjectCode) {
        return this.subjectCode = subjectCode;
    }

    // toString: Provides a string representation of the Lesson object.
    @Override
    public String toString() {
        return "Lesson: " + title + "\nContent: " + content;
    }
}