package utility;

import java.io.*;
import java.util.*;

public class FileManager {

    // Validates user credentials (username and password) against stored data in a file.
    public static boolean validateCredentials(String filename, String username, String password) throws IOException {
        File file = new File(filename);
        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File does not exist: " + filename);
            return false;
        }
        try (Scanner sc = new Scanner(file)) {
            // Read file line by line
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(",");
                // Handle teacher data format
                if (filename.equals("teachers_data.txt") && parts.length >= 3) {
                    String fileUsername = parts[1].trim();
                    String filePassword = parts[2].trim();
                    System.out.println("Comparing (Teacher): " + fileUsername + ":" + filePassword + " with " + username + ":" + password);
                    // Compare provided credentials with file data
                    if (fileUsername.equals(username.trim()) && filePassword.equals(password.trim())) {
                        System.out.println("Teacher credentials match!");
                        return true;
                    }
                    // Handle student data format
                } else if (filename.equals("students_data.txt") && parts.length >= 4) {
                    String fileUsername = parts[2].trim(); // Username is the third part for students
                    String filePassword = parts[3].trim(); // Password is the fourth part for students
                    System.out.println("Comparing (Student): " + fileUsername + ":" + filePassword + " with " + username + ":" + password);
                    // Compare provided credentials with file data
                    if (fileUsername.equals(username.trim()) && filePassword.equals(password.trim())) {
                        System.out.println("Student credentials match!");
                        return true;
                    }
                } else {
                    System.out.println("Invalid line format in " + filename + ": " + line);
                }
            }
        }
        System.out.println("Credentials do not match in " + filename);
        return false;
    }

    // Reads all lines from a file and returns them as a List of Strings.
    public static List<String> readFile(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        File file = new File(filename);
        // Check if the file exists
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                // Read file line by line
                while ((line = reader.readLine()) != null) {
                    lines.add(line);
                }
            }
        }
        return lines;
    }

    // Writes a List of Strings to a file, each string on a new line.
    public static void writeFile(String filename, List<String> lines) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            // Write each line to the file
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    // Adds a new entry to the end of a file.
    public static void addEntry(String filename, Scanner sc, String prompt) throws IOException {
        System.out.print(prompt);
        String entry = sc.nextLine();
        // Open file in append mode and write the entry
        try (FileWriter fw = new FileWriter(filename, true)) {
            fw.write(entry + "\n");
        }
    }

    // Adds a raw string entry to the end of a file.
    public static void addRawEntry(String filename, String entry) throws IOException {
        // Open file in append mode and write the entry
        try (FileWriter fw = new FileWriter(filename, true)) {
            fw.write(entry + "\n");
        }
    }

    // Removes a specific entry from a file.
    public static void removeEntry(String filename, Scanner sc, String prompt) throws IOException {
        System.out.print(prompt);
        String toRemove = sc.nextLine();
        File inputFile = new File(filename);
        File tempFile = new File("temp.txt");

        try (Scanner fileScanner = new Scanner(inputFile);
             PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {
            // Read the input file and write to a temporary file, excluding the line to remove
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (!line.toLowerCase().contains(toRemove.toLowerCase())) {
                    writer.println(line);
                }
            }
        }
        // Replace the original file with the temporary file (which now has the entry removed)
        inputFile.delete();
        tempFile.renameTo(inputFile);
    }

    // Displays the contents of a file to the console.
    public static void viewFile(String filename) throws IOException {
        File file = new File(filename);
        // Check if the file exists
        if (!file.exists()) {
            System.out.println("File does not exist: " + filename);
        } else {
            try (Scanner scanner = new Scanner(file)) {
                // Read and print the file content line by line
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
            }
        }
    }
}