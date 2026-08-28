package LoanEligiblity;
import java.util.Scanner;

public class LoanEligibility {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        System.out.print("Enter employment type (1-Salaried, 2-Self-Employed, 3-Business): ");
        int type = sc.nextInt();

        double income = 0;
        int creditScore = 0;
        double loanAmount = 0;
        double limit = 0;
        String reason = "";

        if (age < 21 || age > 60) {
            reason = "Age must be between 21 and 60";
        } else {

            switch (type) {
                case 1:
                    System.out.print("Enter monthly income: ");
                    income = sc.nextDouble();

                    System.out.print("Enter credit score: ");
                    creditScore = sc.nextInt();

                    System.out.print("Enter loan amount requested: ");
                    loanAmount = sc.nextDouble();

                    limit = income * 10;

                    if (income < 25000)
                        reason = "Monthly income must be at least Rs.25,000";
                    else if (creditScore < 650)
                        reason = "Credit score must be at least 650";
                    else if (loanAmount > limit)
                        reason = "Loan amount exceeds 10x monthly income";
                    break;

                case 2:
                    System.out.print("Enter annual income: ");
                    income = sc.nextDouble();

                    System.out.print("Enter credit score: ");
                    creditScore = sc.nextInt();

                    System.out.print("Enter loan amount requested: ");
                    loanAmount = sc.nextDouble();

                    limit = income * 5;

                    if (income < 500000)
                        reason = "Annual income must be at least Rs.5,00,000";
                    else if (creditScore < 700)
                        reason = "Credit score must be at least 700";
                    else if (loanAmount > limit)
                        reason = "Loan amount exceeds 5x annual income";
                    break;

                case 3:
                    System.out.print("Enter annual turnover: ");
                    income = sc.nextDouble();

                    System.out.print("Enter credit score: ");
                    creditScore = sc.nextInt();

                    System.out.print("Enter loan amount requested: ");
                    loanAmount = sc.nextDouble();

                    limit = income * 5;

                    if (income < 1000000)
                        reason = "Annual turnover must be at least Rs.10,00,000";
                    else if (creditScore < 750)
                        reason = "Credit score must be at least 750";
                    else if (loanAmount > limit)
                        reason = "Loan amount exceeds 5x annual turnover";
                    break;

                default:
                    reason = "Invalid employment type";
            }
        }

        if (reason.isEmpty())
            System.out.println("Approved");
        else
            System.out.println("Rejected: " + reason);

        sc.close();
    }
}