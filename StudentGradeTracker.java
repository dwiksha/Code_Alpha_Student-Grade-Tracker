import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Input student details
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter student score: ");
            int score = sc.nextInt();
            sc.nextLine(); // consume newline
            students.add(new Student(name, score));
        }

        // Calculate statistics
        int total = 0, highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;
        String highName = "", lowName = "";

        for (Student s : students) {
            total += s.score;

            if (s.score > highest) {
                highest = s.score;
                highName = s.name;
            }
            if (s.score < lowest) {
                lowest = s.score;
                lowName = s.name;
            }
        }

        double average = (double) total / students.size();

        // Display summary
        System.out.println("\n===== Student Grade Report =====");
        for (Student s : students) {
            System.out.println(s.name + " - " + s.score);
        }
        System.out.println("---------------------------------");
        System.out.println("Average Score: " + average);
        System.out.println("Highest Score: " + highest + " (by " + highName + ")");
        System.out.println("Lowest Score: " + lowest + " (by " + lowName + ")");
    }
}
