package Assignment3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student student = new Student();

        System.out.print("Enter marks for Subject 1: ");
        double mark1 = sc.nextDouble();

        System.out.print("Enter marks for Subject 2: ");
        double mark2 = sc.nextDouble();

        System.out.print("Enter marks for Subject 3: ");
        double mark3 = sc.nextDouble();

        if (!student.validateMarks(mark1, mark2, mark3)) {
            System.out.println("Invalid marks entered");
            sc.close();
            return;
        }

        double average = student.getAverage(mark1, mark2, mark3);
        boolean passed = student.isPassed(mark1, mark2, mark3, average);

        if (!passed) {

            int graceSubject = student.getGraceSubject(mark1, mark2, mark3);

            if (graceSubject == 1) {
                mark1 = mark1 + 5;
                System.out.println("Grace marks applied to Subject 1");
                System.out.println("Re-evaluated Subject 1: " + mark1);
            } else if (graceSubject == 2) {
                mark2 = mark2 + 5;
                System.out.println("Grace marks applied to Subject 2");
                System.out.println("Re-evaluated Subject 2: " + mark2);
            } else if (graceSubject == 3) {
                mark3 = mark3 + 5;
                System.out.println("Grace marks applied to Subject 3");
                System.out.println("Re-evaluated Subject 3: " + mark3);
            }

            if (graceSubject != 0) {
                average = student.getAverage(mark1, mark2, mark3);
                passed = student.isPassed(mark1, mark2, mark3, average);
            }
        }

        String grade = student.getGrade(average);
        String remark = student.getRemark(grade);

        System.out.println();
        System.out.println("=== Report Card ===");
        System.out.println("Subject 1: " + mark1);
        System.out.println("Subject 2: " + mark2);
        System.out.println("Subject 3: " + mark3);
        System.out.println("Average: " + average);
        System.out.println("Grade: " + grade);
        System.out.println("Remark: " + remark);

        if (passed) {
            System.out.println("Status: Passed");
        } else {
            System.out.println("Status: Failed");
        }

        System.out.println("==================");

        sc.close();
    }
}