package DigitalClock;

class DigitalClock {

    void printDigit(int digit) {

        for (int row = 0; row < 5; row++) {

            for (int col = 0; col < 3; col++) {

                boolean star = false;

                if (digit == 0) {
                    if (row == 0 || row == 4 || col == 0 || col == 2)
                        star = true;
                } 
                else if (digit == 1) {
                    if (col == 1)
                        star = true;
                } 
                else if (digit == 2) {
                    if (row == 0 || row == 2 || row == 4 ||
                        (row == 1 && col == 2) ||
                        (row == 3 && col == 0))
                        star = true;
                } 
                else if (digit == 3) {
                    if (row == 0 || row == 2 || row == 4 || col == 2)
                        star = true;
                } 
                else if (digit == 4) {
                    if (row == 2 || col == 2 ||
                        (row < 2 && col == 0))
                        star = true;
                } 
                else if (digit == 5) {
                    if (row == 0 || row == 2 || row == 4 ||
                        (row == 1 && col == 0) ||
                        (row == 3 && col == 2))
                        star = true;
                } 
                else if (digit == 6) {
                    if (row == 0 || row == 2 || row == 4 ||
                        col == 0 ||
                        (row == 3 && col == 2))
                        star = true;
                } 
                else if (digit == 7) {
                    if (row == 0 || col == 2)
                        star = true;
                } 
                else if (digit == 8) {
                    if (row == 0 || row == 2 || row == 4 ||
                        col == 0 || col == 2)
                        star = true;
                } 
                else if (digit == 9) {
                    if (row == 0 || row == 2 ||
                        col == 2 ||
                        (row == 1 && col == 0))
                        star = true;
                }

                if (star)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }

            System.out.println();
        }
    }
}