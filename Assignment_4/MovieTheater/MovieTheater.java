package MovieTheater;

class MovieTheater {

    boolean[][][] seats = new boolean[3][5][8];

    int getHallIndex(int hall) {
        return hall - 1;
    }

    int getRowIndex(char row) {
        return row - 'A';
    }

    void viewSeats(int hall) {
        int h = getHallIndex(hall);

        System.out.println("Hall " + hall);
        System.out.println("   1 2 3 4 5 6 7 8");

        for (int row = 0; row < 5; row++) {
            System.out.print((char)('A' + row) + "  ");

            for (int seat = 0; seat < 8; seat++) {
                if (seats[h][row][seat]) {
                    System.out.print("B ");
                } else {
                    System.out.print("A ");
                }
            }

            System.out.println();
        }
    }

    boolean isBooked(int hall, char row, int seat) {
        return seats[getHallIndex(hall)][getRowIndex(row)][seat - 1];
    }

    boolean bookSeat(int hall, char row, int seat) {
        int h = getHallIndex(hall);
        int r = getRowIndex(row);
        int s = seat - 1;

        if (seats[h][r][s]) {
            return false;
        }

        seats[h][r][s] = true;
        return true;
    }

    boolean cancelSeat(int hall, char row, int seat) {
        int h = getHallIndex(hall);
        int r = getRowIndex(row);
        int s = seat - 1;

        if (!seats[h][r][s]) {
            return false;
        }

        seats[h][r][s] = false;
        return true;
    }

    int getBookedSeats(int hall) {
        int h = getHallIndex(hall);
        int booked = 0;

        for (int row = 0; row < 5; row++) {
            for (int seat = 0; seat < 8; seat++) {
                if (seats[h][row][seat]) {
                    booked++;
                }
            }
        }

        return booked;
    }

    int getTotalSeats() {
        return 5 * 8;
    }

    int getAvailableSeats(int hall) {
        return getTotalSeats() - getBookedSeats(hall);
    }

    double getBookingPercentage(int hall) {
        return (double) getBookedSeats(hall) / getTotalSeats() * 100;
    }

    double getRevenue(int hall) {
        return getBookedSeats(hall) * 250;
    }
}