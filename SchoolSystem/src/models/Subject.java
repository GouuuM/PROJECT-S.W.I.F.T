package models;

public class Subject {
    private String code;
    private String name;
    private String description;
    private String schedule;

    // Constructor: Creates a Subject object with code, name, description, and schedule.
    public Subject(String code, String name, String description, String schedule) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.schedule = schedule;
    }

    // Getter: Retrieves the subject code.
    public String getCode() {
        return code;
    }

    // Getter: Retrieves the subject name.
    public String getName() {
        return name;
    }

    // Getter: Retrieves the subject description.
    public String getDescription() {
        return description;
    }

    // Getter: Retrieves the subject schedule.
    public String getSchedule() {
        return schedule;
    }

    // Setter: Modifies the subject schedule.
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}