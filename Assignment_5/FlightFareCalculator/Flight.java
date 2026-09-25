package FlightFareCalculator;

class Flight {

    double calculateBaseFare(String source, String destination) {
        if ((source.equalsIgnoreCase("India") &&
             destination.equalsIgnoreCase("Dubai")) ||
            (source.equalsIgnoreCase("Dubai") &&
             destination.equalsIgnoreCase("India"))) {
            return 5000;
        }

        return 2000;
    }

    double calculateClassFare(double base, String classType) {
        if (classType.equalsIgnoreCase("Economy")) {
            return base;
        } 
        else if (classType.equalsIgnoreCase("Business")) {
            return base * 2;
        } 
        else if (classType.equalsIgnoreCase("First")) {
            return base * 3;
        }

        return base;
    }

    double calculateLuggageFare(double weight) {
        if (weight <= 15) {
            return 0;
        }

        return (weight - 15) * 100;
    }

    double calculateTotalFare(double base, double classFare,
                              double luggage, boolean isStudent) {

        double amount = base + classFare + luggage;

        if (isStudent) {
            double discount = (base + classFare) * 0.20;
            amount = amount - discount;
        }

        return amount;
    }
}