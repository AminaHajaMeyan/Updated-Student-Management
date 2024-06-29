
package studentmanagements;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManagements {

    public static void main(String[] args) {
        StudentService service = new StudentServerImplementation();
        Scanner scanner = new Scanner(System.in);
        Dashboard.display();
        
        try {
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Perform action based on user choice.
            switch (choice) {
                case 1:
                    service.saveStudent();
                    break;
//                 case 2:
//                     editStudent();
//                     break;
//                 case 3:
//                     deleteStudent();
//                     break;
//                 case 4:
//                     viewAllStudents();
//                     break;
//                 case 5:
//                     searchStudent();
//                     break;
                case 6:
                    // Exit the application.
                    System.exit(0);
                    break;
                default:
                    System.out.print("\033[H\033[2J");
                    System.out.println("Invalid option. Please enter a valid option between 1 and 6.");
                    Dashboard.display();
            }
        } catch (InputMismatchException e) {
            System.out.print("\033[H\033[2J");
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.nextLine(); // Clear the invalid input
            Dashboard.display();
        }
    }
    
}
