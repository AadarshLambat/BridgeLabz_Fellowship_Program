package TrainBooking;

class Train {

    double getBaseFare(int trainClass) {
        switch (trainClass) {
            case 1:
                return 3000;
            case 2:
                return 2000;
            case 3:
                return 800;
            case 4:
                return 300;
            default:
                return -1;
        }
    }

    String getClassName(int trainClass) {
        switch (trainClass) {
            case 1:
                return "AC First";
            case 2:
                return "AC Second";
            case 3:
                return "Sleeper";
            case 4:
                return "General";
            default:
                return "Invalid";
        }
    }

    double getDiscount(double fare, int age) {
        if (age < 5) {
            return fare;
        } else if (age >= 5 && age <= 12) {
            return fare * 0.50;
        } else if (age >= 60) {
            return fare * 0.30;
        } else {
            return 0;
        }
    }

    double getTatkalCharge(int trainClass, int tatkal) {
        if (tatkal == 1) {
            if (trainClass == 1 || trainClass == 2) {
                return 500;
            } else if (trainClass == 3 || trainClass == 4) {
                return 200;
            }
        }

        return 0;
    }

    double getTotalFare(double fare, double discount, double tatkalCharge) {
        return fare - discount + tatkalCharge;
    }
}
