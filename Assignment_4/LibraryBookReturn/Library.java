package LibraryBookReturn;

class Library {

    boolean isOverdue(int returnDate, int dueDate) {
        return returnDate > dueDate;
    }

    boolean isEarly(int returnDate, int dueDate) {
        return returnDate < dueDate;
    }

    double calculateFine(int returnDate, int dueDate) {
        return (returnDate - dueDate) * 5;
    }

    String addOverdueBook(String list, String bookId, int overdueDays) {
        if (list.isEmpty()) {
            return bookId + " (" + overdueDays + " days)";
        } else {
            return list + ", " + bookId + " (" + overdueDays + " days)";
        }
    }
}