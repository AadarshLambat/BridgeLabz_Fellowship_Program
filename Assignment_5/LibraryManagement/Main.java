package LibraryManagement;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        System.out.println("Library Book Search");
        System.out.println("-------------------");

        System.out.println(library.searchBook("Java Programming"));

        System.out.println(library.searchBook(
            "Data Structures",
            "Mark Allen"
        ));

        System.out.println(library.searchBook(
            "Database Systems",
            "Abraham Silberschatz",
            2021
        ));

        System.out.println();
        System.out.println("Fine Calculations");
        System.out.println("-----------------");

        System.out.println("Regular Book Fine: Rs." +
                library.calculateFine(4));

        System.out.println("Reference Book Fine: Rs." +
                library.calculateFine(4, "Reference"));

        System.out.println("Magazine Fine: Rs." +
                library.calculateFine(4, "Magazine"));
    }
}
