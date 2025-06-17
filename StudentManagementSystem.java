import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n=== Student Grade Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Marks");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter roll number: ");
                    int roll = sc.nextInt();
                    System.out.print("Enter marks: ");
                    int marks = sc.nextInt();
                    students.add(new Student(name, roll, marks));
                    System.out.println("Student added successfully!");
                    break;
                case 2:
                    for (Student s : students) {
                        s.display();
                    }
                    break;
                case 3:
                    System.out.print("Enter roll number to update marks: ");
                    int rollUpdate = sc.nextInt();
                    boolean found = false;
                    for (Student s : students) {
                        if (s.getRollNumber() == rollUpdate) {
                            System.out.print("Enter new marks: ");
                            int newMarks = sc.nextInt();
                            s.setMarks(newMarks);
                            System.out.println("Marks updated.");
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
