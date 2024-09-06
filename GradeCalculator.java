import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] subjects = {"Maths", "Science", "English", "History", "Geography"};
        double[] marks = new double[subjects.length];
        double totalMarks = 0;

        for (int i = 0; i < subjects.length; i++) {
            while (true) {
                System.out.print("Enter marks obtained in " + subjects[i] + " (out of 100): ");
                if (scanner.hasNextDouble()) {
                    marks[i] = scanner.nextDouble();
                    if (marks[i] >= 0 && marks[i] <= 100) {
                        totalMarks += marks[i];
                        break;
                    } else {
                        System.out.println("Invalid input. Marks should be between 0 and 100.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a numerical value.");
                    scanner.next(); // Consume the invalid input
                }
            }
        }

        double averagePercentage = totalMarks / subjects.length;
        char grade = calculateGrade(averagePercentage);

        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage);
        System.out.println("Grade: " + grade);
    }

    private static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return 'A';
        } else if (averagePercentage >= 80) {
            return 'B';
        } else if (averagePercentage >= 70) {
            return 'C';
        } else if (averagePercentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
}