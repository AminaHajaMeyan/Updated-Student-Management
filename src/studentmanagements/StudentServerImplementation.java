/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;

public class StudentServerImplementation implements StudentService {
    private static DbConfig dbconfig= DbConfig.getInstance();
    Scanner scanner = new Scanner(System.in);
    
    public void saveStudent() {
        System.out.print("\033[H\033[2J");
        System.out.println("\t--------- * ---------");
        System.out.println("\t     Add Student      ");
        System.out.println("\t--------- * ---------");
        
        try {
            // Collect student details from the user.
            System.out.print("\nEnter student Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter student Gender: ");
            String gender = scanner.nextLine();

            String age;
            while (true) {
                System.out.print("Enter student Age: ");
                age = scanner.nextLine();
                if (isValidAge(age)) {
                    break;
                } else {
                    System.out.println("Please enter a valid age.");
                }
            }
            System.out.print("Enter student Date of Birth (DD/MM/YYYY): ");
            String dob = scanner.nextLine();

            String contactNumber;
            while (true) {
                System.out.print("Enter student Contact Number: ");
                contactNumber = scanner.nextLine();
                if (isValidPhoneNumber(contactNumber)) {
                    break;
                } else {
                    System.out.println("Please enter a valid contact number.");
                }
            }
           
        

        
        System.out.println(name+" "+age+" "+" "+" "+" ");
             
        // Add student to the database.
            String sql = "INSERT INTO student(name, age, gender, dob, contact_number)" + " VALUES (?, ?, ?, ?, ?)";
            try (Connection con = dbconfig.dbConnection()) {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, name);
                ps.setInt(2, Integer.parseInt(age));
                ps.setString(3, gender);
                ps.setString(4, dob);
                ps.setString(5, contactNumber);

                int row = ps.executeUpdate();
                System.out.println(row + " student(s) added.");
            }

            System.out.println("\nStudent added successfully.");

            // Ask user if they want to add another student.
            System.out.print("Do you want to add another student? Press \"Y\" for Yes or \"N\" for No: ");
            String selection = scanner.nextLine();

            if (selection.equalsIgnoreCase("y")) {
                saveStudent();
            } else {
                System.out.print("\033[H\033[2J");
                Dashboard.display();
            }
        } catch (InputMismatchException | SQLException e) {
            System.out.println("Invalid input or database error. Please try again.");
            scanner.nextLine(); // Clear the invalid input
            saveStudent(); // Retry adding a student
        }
    }
    private static boolean isValidAge(String age) {
        try {
            int ageInt = Integer.parseInt(age);
            return ageInt > 0 && ageInt < 100;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{10}");
    }
}
