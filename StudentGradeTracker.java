import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    // Student class
    static class Student {
        String name;
        double grade;

        Student(String name, double grade) {
            this.name = name;
            this.grade = grade;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("     STUDENT GRADE TRACKER");
            System.out.println("================================");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Display Grade Statistics");
            System.out.println("4. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    // Add student
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter student grade (0-100): ");
                    double grade = scanner.nextDouble();

                    if (grade >= 0 && grade <= 100) {
                        students.add(new Student(name, grade));
                        System.out.println("Student added successfully!");
                    } else {
                        System.out.println("Invalid grade! Please enter a grade between 0 and 100.");
                    }
                    break;

                case 2:
                    // Display students
                    if (students.isEmpty()) {
                        System.out.println("No students available.");
                    } else {
                        System.out.println("\n-------- Student List --------");

                        for (int i = 0; i < students.size(); i++) {
                            Student student = students.get(i);

                            System.out.println(
                                (i + 1) + ". " +
                                student.name + " - " +
                                student.grade
                            );
                        }
                    }
                    break;

                case 3:
                    // Calculate statistics
                    if (students.isEmpty()) {
                        System.out.println("No grades available.");
                    } else {

                        double total = 0;
                        double highest = students.get(0).grade;
                        double lowest = students.get(0).grade;

                        for (Student student : students) {

                            total += student.grade;

                            if (student.grade > highest) {
                                highest = student.grade;
                            }

                            if (student.grade < lowest) {
                                lowest = student.grade;
                            }
                        }

                        double average = total / students.size();

                        System.out.println("\n-------- Grade Statistics --------");
                        System.out.printf("Average Grade : %.2f%n", average);
                        System.out.printf("Highest Grade : %.2f%n", highest);
                        System.out.printf("Lowest Grade  : %.2f%n", lowest);
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using Student Grade Tracker!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1-4.");
            }

        } while (choice != 4);

        scanner.close();
    }
}