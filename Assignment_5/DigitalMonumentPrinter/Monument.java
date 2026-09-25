class Monument {

    void printMonument(int size) {
        printMonument(size, '*');
    }

    void printMonument(int size, char symbol) {

        if (size <= 0) {
            System.out.println("Invalid size");
            return;
        }

        while (true) {
            if (size > 15) {
                size = 15;
                break;
            }
            break;
        }

        int row = 1;

        while (row <= size) {

            for (int space = size - row; space > 0; space--) {
                System.out.print(" ");
            }

            for (int number = 1; number <= 2 * row - 1; number++) {

                if (row % 3 == 0) {
                    System.out.print(number);
                    continue;
                }

                if (number == 1 || number == 2 * row - 1) {
                    System.out.print(number);
                } else {
                    System.out.print(symbol);
                }
            }

            System.out.println();
            row++;
        }

        row = size - 1;

        do {

            for (int space = size - row; space > 0; space--) {
                System.out.print(" ");
            }

            for (int number = 1; number <= 2 * row - 1; number++) {

                if (row % 3 == 0) {
                    System.out.print(number);
                    continue;
                }

                if (number == 1 || number == 2 * row - 1) {
                    System.out.print(number);
                } else {
                    System.out.print(symbol);
                }
            }

            System.out.println();
            row--;

        } while (row >= 1);
    }
}