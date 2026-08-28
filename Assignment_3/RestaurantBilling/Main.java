package RestaurantBilling;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Restaurant restaurant = new Restaurant();

        System.out.print("Enter bill amount: ");
        double bill = sc.nextDouble();

        System.out.print("Enter customer type (1-Regular, 2-Member, 3-VIP): ");
        int customerType = sc.nextInt();

        System.out.print("Is it weekend? (true/false): ");
        boolean weekend = sc.nextBoolean();

        System.out.print("Enter payment mode (1-Cash, 2-Card, 3-UPI): ");
        int paymentMode = sc.nextInt();

        double discount = restaurant.getCustomerDiscount(customerType, bill);

        if (discount == -1) {
            System.out.println("Invalid customer type");
            sc.close();
            return;
        }

        double amountAfterDiscount = bill - discount;

        double loyaltyDiscount = restaurant.getLoyaltyDiscount(bill);

        double amountAfterLoyalty = amountAfterDiscount - loyaltyDiscount;

        double weekendSurcharge = restaurant.getWeekendSurcharge(amountAfterLoyalty, weekend);

        double amountAfterWeekend = amountAfterLoyalty + weekendSurcharge;

        double gst = restaurant.getGST(amountAfterWeekend);

        double amountAfterGST = amountAfterWeekend + gst;

        double paymentCharge = restaurant.getPaymentCharge(paymentMode, amountAfterGST);

        if (paymentCharge == -1) {
            System.out.println("Invalid payment mode");
            sc.close();
            return;
        }

        double finalAmount = amountAfterGST + paymentCharge;

        System.out.println();
        System.out.println("=== Restaurant Bill ===");
        System.out.println("Customer Type: " + restaurant.getCustomerType(customerType));
        System.out.println("Bill Amount: Rs." + bill);
        System.out.println("Customer Discount: Rs." + discount);
        System.out.println("Loyalty Discount: Rs." + loyaltyDiscount);
        System.out.println("Weekend Surcharge: Rs." + weekendSurcharge);
        System.out.println("GST: Rs." + gst);

        if (paymentMode == 3) {
            System.out.println("UPI Cashback: Rs.50.0");
        } else if (paymentMode == 2) {
            System.out.println("Card Convenience Fee: Rs." + paymentCharge);
        } else {
            System.out.println("Payment Charge: Rs.0.0");
        }

        System.out.println("Payment Mode: " + restaurant.getPaymentMode(paymentMode));
        System.out.println("Final Amount: Rs." + finalAmount);

        sc.close();
    }
}