package BankFixedDeposit;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        FixedDeposit fd = new FixedDeposit();

        System.out.print("Enter principal amount: ");
        double principal = sc.nextDouble();

        System.out.print("Enter annual interest rate: ");
        double rate = sc.nextDouble();

        System.out.print("Enter tenure in years: ");
        int years = sc.nextInt();

        double balance = principal;
        double totalInterest = 0;

        System.out.println();
        System.out.println("Year | Opening | Interest | Closing");
        System.out.println("----------------------------------------");

        for (int year = 1; year <= years; year++) {

            double openingBalance = balance;
            double interest = fd.calculateInterest(balance, rate);
            balance = fd.calculateClosingBalance(balance, interest);

            totalInterest = totalInterest + interest;

            System.out.println(
                year + " | " +
                String.format("%.2f", openingBalance) + " | " +
                String.format("%.2f", interest) + " | " +
                String.format("%.2f", balance)
            );
        }

        System.out.println("----------------------------------------");
        System.out.println("Maturity Amount: " + String.format("%.2f", balance));
        System.out.println("Total Interest: " + String.format("%.2f", totalInterest));

        sc.close();
    }
}
