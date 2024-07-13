import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input: Name of Student
        System.out.print("Enter the name of Student: ");
        String name = scanner.nextLine();
        // Input: Roll Number of Student
        System.out.print("Enter the ROll Number: ");
        int rollNo = scanner.nextInt();
        // Input: Class of Student
        System.out.print("Enter the class of Student: ");
        int Class = scanner.nextInt();
        // Input: Number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Create arrays to store subject names and marks
        String[] subjectNames = new String[numSubjects];
        int[] marksArray = new int[numSubjects];

        // Input: Subject names and marks
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter name of subject " + (i + 1) + ": ");
            subjectNames[i] = scanner.next();
            System.out.print("Enter marks of " + subjectNames[i] + ": ");
            marksArray[i] = scanner.nextInt();
        }

        // Calculate total marks
        int totalMarks = 0;
        for (int marks : marksArray) {
            totalMarks += marks;
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Grade Calculation
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display Results
        System.out.println("\nResults:");
        System.out.println("Student Name is: " + name);
        System.out.println("Student Roll Number is: " + rollNo);
        System.out.println("Student class is: " + Class);
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}
