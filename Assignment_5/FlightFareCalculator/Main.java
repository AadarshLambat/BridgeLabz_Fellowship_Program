package FlightFareCalculator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Flight flight = new Flight();

        System.out.print("Enter source: ");
        String source = sc.nextLine();

        System.out.print("Enter destination: ");
        String destination = sc.nextLine();

        System.out.print("Enter class type: ");
        String classType = sc.nextLine();

        System.out.print("Enter luggage weight (kg): ");
        double weight = sc.nextDouble();

        System.out.print("Are you a student? (true/false): ");
        boolean isStudent = sc.nextBoolean();

        double baseFare = flight.calculateBaseFare(source, destination);
        double classFare = flight.calculateClassFare(baseFare, classType);
        double luggageFare = flight.calculateLuggageFare(weight);
        double totalFare = flight.calculateTotalFare(
                baseFare,
                classFare,
                luggageFare,
                isStudent
        );

        double studentDiscount = 0;

        if (isStudent) {
            studentDiscount = (baseFare + classFare) * 0.20;
        }

        System.out.println();
        System.out.println("Flight Ticket");
        System.out.println("-------------");
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("Class: " + classType);
        System.out.println("Base Fare: Rs." + baseFare);
        System.out.println("Class Fare: Rs." + classFare);
        System.out.println("Luggage Fare: Rs." + luggageFare);
        System.out.println("Student Discount: Rs." + studentDiscount);
        System.out.println("Total Fare: Rs." + totalFare);

        sc.close();
    }
} 

