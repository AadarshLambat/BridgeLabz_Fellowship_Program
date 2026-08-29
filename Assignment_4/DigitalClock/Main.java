package DigitalClock;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DigitalClock clock = new DigitalClock();

        System.out.print("Enter a digit (0-9): ");
        int digit = sc.nextInt();

        if (digit >= 0 && digit <= 9) {
            clock.printDigit(digit);
        } else {
            System.out.println("Invalid digit");
        }

        sc.close();
    }
}
