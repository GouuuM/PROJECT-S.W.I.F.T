package models;

import java.util.Scanner;

public abstract class User {
    private String username;
    private String password;

    // Constructor: Creates a User object with username and password.
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter: Retrieves the username of the user.
    public String getUsername() {
        return username;
    }

    // Getter: Retrieves the password of the user.
    public String getPassword() {
        return password;
    }

    // login: Placeholder for user login functionality (not fully implemented here).
    public boolean login(Scanner sc) {
        System.out.print("Enter username: ");
        String enteredUsername = sc.nextLine();
        System.out.print("Enter password: ");
        String enteredPassword = sc.nextLine();
        return this.username.equals(enteredUsername) && this.password.equals(enteredPassword);
    }
}