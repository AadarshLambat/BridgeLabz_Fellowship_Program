package University;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        University university = new University();

        System.out.print("Enter category: ");
        String category = sc.next();

        System.out.print("Enter entrance exam score: ");
        double score = sc.nextDouble();

        System.out.print("Sports quota? (true/false): ");
        boolean sports = sc.nextBoolean();

        System.out.print("NCC certificate? (true/false): ");
        boolean ncc = sc.nextBoolean();

        System.out.print("Hostel required? (true/false): ");
        boolean hostel = sc.nextBoolean();

        double cutoff = university.getFinalCutoff(category, sports, ncc);

        if (cutoff == -1) {
            System.out.println("Invalid category");
            sc.close();
            return;
        }

        boolean admitted = university.isAdmitted(score, cutoff);

        System.out.println();
        System.out.println("=== Admission Result ===");
        System.out.println("Category: " + category.toUpperCase());
        System.out.println("Score: " + score);
        System.out.println("Required Cutoff: " + cutoff);

        if (admitted) {
            System.out.println("Status: ADMITTED");

            double tuitionFee = university.getTuitionFee(category);
            double totalFee = university.getTotalFee(category, hostel);

            System.out.println("Tuition Fee: Rs." + totalFee);
        } else {
            System.out.println("Status: NOT ADMITTED");
            System.out.println("Reason: Score below cutoff");
        }

        sc.close();
    }
}