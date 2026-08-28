package TrainBooking;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Train train = new Train();

        System.out.print("Enter class (1-AC First, 2-AC Second, 3-Sleeper, 4-General): ");
        int trainClass = sc.nextInt();

        System.out.print("Enter passenger age: ");
        int age = sc.nextInt();

        System.out.print("Is this a Tatkal booking? (1-Yes, 0-No): ");
        int tatkal = sc.nextInt();

        double baseFare = train.getBaseFare(trainClass);

        if (baseFare == -1) {
            System.out.println("Invalid class");
            sc.close();
            return;
        }

        double discount = train.getDiscount(baseFare, age);
        double tatkalCharge = train.getTatkalCharge(trainClass, tatkal);
        double totalFare = train.getTotalFare(baseFare, discount, tatkalCharge);

        System.out.println();
        System.out.println("----- Ticket Details -----");
        System.out.println("Class: " + train.getClassName(trainClass));
        System.out.println("Base Fare: Rs. " + baseFare);
        System.out.println("Discount: Rs. " + discount);
        System.out.println("Tatkal Surcharge: Rs. " + tatkalCharge);
        System.out.println("Total Fare: Rs. " + totalFare);

        sc.close();
    }
}