package LibraryManagement;

class Library {

    String[] titles = {"Java Programming", "Data Structures", "Database Systems"};
    String[] authors = {"James Gosling", "Mark Allen", "Abraham Silberschatz"};
    int[] years = {2020, 2019, 2021};

    String searchBook(String title) {
        for (int i = 0; i < titles.length; i++) {
            if (titles[i].equalsIgnoreCase(title)) {
                return "Found: " + titles[i];
            }
        }

        return "Not Found";
    }

    String searchBook(String title, String author) {
        for (int i = 0; i < titles.length; i++) {
            if (titles[i].equalsIgnoreCase(title) &&
                authors[i].equalsIgnoreCase(author)) {
                return "Found: " + titles[i];
            }
        }

        return "Not Found";
    }

    String searchBook(String title, String author, int year) {
        for (int i = 0; i < titles.length; i++) {
            if (titles[i].equalsIgnoreCase(title) &&
                authors[i].equalsIgnoreCase(author) &&
                years[i] == year) {
                return "Found: " + titles[i];
            }
        }

        return "Not Found";
    }

    double calculateFine(int daysOverdue) {
        return daysOverdue * 5;
    }

    double calculateFine(int daysOverdue, String bookType) {
        if (bookType.equalsIgnoreCase("Reference")) {
            return daysOverdue * 10;
        } 
        else if (bookType.equalsIgnoreCase("Magazine")) {
            return daysOverdue * 3;
        } 
        else {
            return daysOverdue * 5;
        }
    }
}
