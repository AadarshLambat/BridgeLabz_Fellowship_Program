package Incometax;
import java.util.Scanner;

public class Incometax{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter annual income: ");
        double income = sc.nextDouble();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        double tax = 0;

        if (age < 60) {
            if (income <= 300000)
                tax = 0;
            else if (income <= 500000)
                tax = income * 0.05;
            else if (income <= 1000000)
                tax = income * 0.20;
            else
                tax = income * 0.30;
        } 
        else if (age >= 60 && age <= 79) {
            if (income <= 350000)
                tax = 0;
            else if (income <= 500000)
                tax = income * 0.05;
            else if (income <= 1000000)
                tax = income * 0.20;
            else
                tax = income * 0.30;
        } 
        else {
            if (income <= 500000)
                tax = 0;
            else if (income <= 1000000)
                tax = income * 0.20;
            else
                tax = income * 0.30;
        }

        double cess = tax * 0.04;
        double totalTax = tax + cess;

        System.out.print("\nTaxable Income:"+ income);
        System.out.print("\nTax:"+ tax);
        System.out.print("\nCess:"+ cess);
        System.out.print("\nTotal Tax Payable:"+ totalTax);

        sc.close();
    }
}