package ECommerceOrderSummary;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Order order = new Order();

        int customersProcessed = 0;
        double grandTotal = 0;

        while (true) {

            System.out.print("Customer ID (or DONE): ");
            String customerId = sc.next();

            if (customerId.equalsIgnoreCase("DONE")) {
                break;
            }

            System.out.print("Number of items: ");
            int numberOfItems = sc.nextInt();

            double subtotal = 0;

            for (int i = 1; i <= numberOfItems; i++) {

                System.out.print("Item " + i + " name: ");
                String itemName = sc.next();

                System.out.print("Quantity: ");
                int quantity = sc.nextInt();

                System.out.print("Unit price: ");
                double price = sc.nextDouble();

                if (!order.isValidItem(quantity, price)) {
                    System.out.println("Warning: Invalid item skipped.");
                    System.out.println();
                    continue;
                }

                double itemTotal = order.calculateItemTotal(quantity, price);

                subtotal = subtotal + itemTotal;

                System.out.println(itemName + ": " + quantity + " x " + price + " = " + itemTotal);
            }

            double discount = order.getDiscount(subtotal);
            double delivery = order.getDeliveryCharge();
            double customerTotal = order.getCustomerTotal(subtotal, discount, delivery);

            System.out.println("Subtotal: " + subtotal);
            System.out.println("Discount: " + discount);
            System.out.println("Delivery: " + delivery);
            System.out.println("Customer Total: " + customerTotal);

            grandTotal = grandTotal + customerTotal;
            customersProcessed++;
        }

        System.out.println("=== Platform Summary ===");
        System.out.println("Customers processed: " + customersProcessed);
        System.out.println("Grand Total Revenue: Rs." + grandTotal);

        sc.close();
    }
}