package LibraryBookReturn;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        int booksProcessed = 0;
        double totalFine = 0;
        String overdueBooks = "";

        while (true) {

            System.out.print("Book ID: ");
            String bookId = sc.next();

            System.out.print("Due date (day): ");
            int dueDate = sc.nextInt();

            System.out.print("Return date (day): ");
            int returnDate = sc.nextInt();

            booksProcessed++;

            if (library.isOverdue(returnDate, dueDate)) {

                int overdueDays = returnDate - dueDate;
                double fine = library.calculateFine(returnDate, dueDate);

                totalFine = totalFine + fine;

                overdueBooks = library.addOverdueBook(
                    overdueBooks,
                    bookId,
                    overdueDays
                );

                System.out.println(
                    "Overdue! Fine for " + bookId + ": Rs." + fine
                );

            } else if (library.isEarly(returnDate, dueDate)) {

                System.out.println(
                    "Early return! Thank you for " + bookId
                );

            } else {

                System.out.println(
                    "Returned on time: " + bookId
                );
            }

            System.out.print("Process another book? (Y/N): ");
            char choice = Character.toUpperCase(sc.next().charAt(0));

            if (choice == 'N') {
                break;
            }
        }

        System.out.println("=== Return Summary ===");
        System.out.println("Books processed: " + booksProcessed);
        System.out.println("Total fine: Rs." + totalFine);
        System.out.println("Overdue books: " + overdueBooks);

        sc.close();
    }
}