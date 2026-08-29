package MovieTheater;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MovieTheater theater = new MovieTheater();

        while (true) {

            System.out.println();
            System.out.println("=== Movie Theater ===");
            System.out.println("1. View Available Seats");
            System.out.println("2. Book Tickets");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Hall Summary");
            System.out.println("5. Exit");

            System.out.print("Choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Select hall (1-3): ");
                int hall = sc.nextInt();

                if (hall >= 1 && hall <= 3) {
                    theater.viewSeats(hall);
                } else {
                    System.out.println("Invalid hall");
                }

            } else if (choice == 2) {

                System.out.print("Select hall (1-3): ");
                int hall = sc.nextInt();

                if (hall < 1 || hall > 3) {
                    System.out.println("Invalid hall");
                    continue;
                }

                while (true) {

                    System.out.print("Enter row (A-E) or DONE: ");
                    String input = sc.next();

                    if (input.equalsIgnoreCase("DONE")) {
                        break;
                    }

                    char row = Character.toUpperCase(input.charAt(0));

                    if (row < 'A' || row > 'E') {
                        System.out.println("Invalid row");
                        continue;
                    }

                    System.out.print("Enter seat (1-8): ");
                    int seat = sc.nextInt();

                    if (seat < 1 || seat > 8) {
                        System.out.println("Invalid seat");
                        continue;
                    }

                    if (theater.bookSeat(hall, row, seat)) {
                        System.out.println(
                            "Seat " + row + seat + " booked successfully!"
                        );
                    } else {
                        System.out.println(
                            "Seat already booked. Try again."
                        );
                    }
                }

            } else if (choice == 3) {

                System.out.print("Select hall (1-3): ");
                int hall = sc.nextInt();

                if (hall < 1 || hall > 3) {
                    System.out.println("Invalid hall");
                    continue;
                }

                System.out.print("Enter row (A-E): ");
                char row = Character.toUpperCase(sc.next().charAt(0));

                System.out.print("Enter seat (1-8): ");
                int seat = sc.nextInt();

                if (row < 'A' || row > 'E' || seat < 1 || seat > 8) {
                    System.out.println("Invalid seat");
                    continue;
                }

                if (theater.cancelSeat(hall, row, seat)) {
                    System.out.println(
                        "Seat " + row + seat + " cancelled successfully!"
                    );
                } else {
                    System.out.println("Seat was not booked");
                }

            } else if (choice == 4) {

                System.out.print("Select hall (1-3): ");
                int hall = sc.nextInt();

                if (hall < 1 || hall > 3) {
                    System.out.println("Invalid hall");
                    continue;
                }

                System.out.println("Total seats: " + theater.getTotalSeats());
                System.out.println("Booked: " + theater.getBookedSeats(hall));
                System.out.println("Available: " + theater.getAvailableSeats(hall));
                System.out.println(
                    "Booking %: " + theater.getBookingPercentage(hall) + "%"
                );

            } else if (choice == 5) {

                double totalRevenue = 0;

                System.out.println();
                System.out.println("=== Final Summary ===");

                for (int hall = 1; hall <= 3; hall++) {
                    int booked = theater.getBookedSeats(hall);
                    double revenue = theater.getRevenue(hall);

                    System.out.println("Hall " + hall + ":");
                    System.out.println("Booked: " + booked);
                    System.out.println("Available: " + theater.getAvailableSeats(hall));
                    System.out.println("Revenue: Rs." + revenue);

                    totalRevenue = totalRevenue + revenue;
                }

                System.out.println("Total Revenue: Rs." + totalRevenue);
                System.out.println("Thank you!");

                break;

            } else {
                System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}
