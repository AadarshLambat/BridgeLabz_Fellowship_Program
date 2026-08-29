package BankFixedDeposit;

class FixedDeposit {

    double calculateInterest(double balance, double rate) {
        return balance * rate / 100;
    }

    double calculateClosingBalance(double balance, double interest) {
        return balance + interest;
    }
}