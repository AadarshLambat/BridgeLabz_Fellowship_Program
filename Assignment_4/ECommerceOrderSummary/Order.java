package ECommerceOrderSummary;

class Order {

    double calculateItemTotal(int quantity, double price) {
        return quantity * price;
    }

    double calculateSubtotal(double subtotal) {
        return subtotal;
    }

    double getDiscount(double subtotal) {
        if (subtotal > 1000) {
            return subtotal * 0.10;
        } else {
            return 0;
        }
    }

    double getDeliveryCharge() {
        return 50;
    }

    double getCustomerTotal(double subtotal, double discount, double delivery) {
        return subtotal - discount + delivery;
    }

    boolean isValidItem(int quantity, double price) {
        return quantity > 0 && price > 0;
    }
}