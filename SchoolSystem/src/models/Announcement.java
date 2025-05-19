package models;

public class Announcement {
    private String message;

    // Constructor: Initializes an Announcement object with the given message.
    public Announcement(String message) {
        this.message = message;
    }

    // Getter: Retrieves the message of the announcement.
    public String getMessage() {
        return message;
    }

    // Setter: Modifies the message of the announcement.
    public void setMessage(String message) {
        this.message = message;
    }

    // toString: Provides a string representation of the Announcement object.
    @Override
    public String toString() {
        return "Announcement: " + message;
    }
}