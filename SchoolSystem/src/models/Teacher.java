package models;

public class Teacher extends User {
    private String name;

    // Constructor: Creates a Teacher object with username and password.
    public Teacher(String username, String password) {
        super(username, password);
        this.name = "N/A"; // Default name if not provided
    }

    // Constructor: Creates a Teacher object with name, username, and password.
    public Teacher(String name, String username, String password) {
        super(username, password);
        this.name = name;
    }

    // Getter: Retrieves the teacher's name.
    public String getName() {
        return name;
    }

    // Setter: Modifies the teacher's name.
    public void setName(String name) {
        this.name = name;
    }

    // toString: Provides a string representation of the Teacher object.
    @Override
    public String toString() {
        return "Teacher Name: " + name + ", Username: " + getUsername();
    }
}