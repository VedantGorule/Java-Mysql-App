import java.sql.*;
import java.util.Scanner;

public class MySQLConnect {
    public static void main(String[] args) {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/javapp", "root", "VedGo#69");

            System.out.println("Connection successful!");

            // Create a statement object
            Statement stmt = conn.createStatement();

            // Scanner object for user input
            Scanner scanner = new Scanner(System.in);

            // Menu to provide options to the user
            while (true) {
                System.out.println("\nSelect an option:");
                System.out.println("1. Add Students");
                System.out.println("2. Delete Student");
                System.out.println("3. Update Student");
                System.out.println("4. Display All Students");
                System.out.println("5. Exit");

                int choice = scanner.nextInt();
                scanner.nextLine(); // consume the newline character

                switch (choice) {
                    case 1:
                        // Add students functionality
                        System.out.print("Enter the number of students you want to add: ");
                        int count = scanner.nextInt();
                        scanner.nextLine(); // consume the newline character

                        for (int i = 1; i <= count; i++) {
                            System.out.println("Enter details for student " + i + ":");

                            System.out.print("Enter student's roll number: ");
                            int rollNo = scanner.nextInt();
                            scanner.nextLine(); // consume the newline character

                            System.out.print("Enter student's name: ");
                            String name = scanner.nextLine();

                            System.out.print("Enter student's age: ");
                            int age = scanner.nextInt();
                            scanner.nextLine(); // consume the newline character

                            String insertSQL = "INSERT INTO students (roll_no, name, age) VALUES (" + rollNo + ", '" + name + "', " + age + ")";
                            stmt.executeUpdate(insertSQL);
                            System.out.println("Student " + i + " added successfully!");
                        }
                        break;

                    case 2:
                        // Delete student functionality
                        System.out.print("Enter the roll number of the student you want to delete: ");
                        int rollToDelete = scanner.nextInt();
                        scanner.nextLine(); // consume the newline character

                        String deleteSQL = "DELETE FROM students WHERE roll_no = " + rollToDelete;
                        int rowsDeleted = stmt.executeUpdate(deleteSQL);
                        if (rowsDeleted > 0) {
                            System.out.println("Student with roll number " + rollToDelete + " deleted successfully.");
                        } else {
                            System.out.println("Student with roll number " + rollToDelete + " not found.");
                        }
                        break;

                    case 3:
                        // Update student functionality
                        System.out.print("Enter the roll number of the student you want to update: ");
                        int rollToUpdate = scanner.nextInt();
                        scanner.nextLine(); // consume the newline character

                        System.out.print("Enter the new name for the student: ");
                        String newName = scanner.nextLine();

                        System.out.print("Enter the new age for the student: ");
                        int newAge = scanner.nextInt();
                        scanner.nextLine(); // consume the newline character

                        String updateSQL = "UPDATE students SET name = '" + newName + "', age = " + newAge + " WHERE roll_no = " + rollToUpdate;
                        int rowsUpdated = stmt.executeUpdate(updateSQL);
                        if (rowsUpdated > 0) {
                            System.out.println("Student with roll number " + rollToUpdate + " updated successfully.");
                        } else {
                            System.out.println("Student with roll number " + rollToUpdate + " not found.");
                        }
                        break;

                    case 4:
                        // Display all students
                        String querySQL = "SELECT * FROM students";
                        ResultSet rs = stmt.executeQuery(querySQL);

                        System.out.println("\nStudents List:");
                        while (rs.next()) {
                            System.out.println("ID: " + rs.getInt("id") + ", Roll No: " + rs.getInt("roll_no") + ", Name: " + rs.getString("name") + ", Age: " + rs.getInt("age"));
                        }
                        break;

                    case 5:
                        // Exit
                        System.out.println("Exiting the program.");
                        conn.close();
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
