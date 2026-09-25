package HospitalPatientBilling;

class Hospital {

    double calculateConsultationFee(String doctorType) {
        if (doctorType.equalsIgnoreCase("General")) {
            return 500;
        } 
        else if (doctorType.equalsIgnoreCase("Specialist")) {
            return 1000;
        } 
        else if (doctorType.equalsIgnoreCase("Surgeon")) {
            return 2000;
        }

        return 0;
    }

    double calculateTestFee(String[] tests) {
        double total = 0;

        for (int i = 0; i < tests.length; i++) {
            if (tests[i].equalsIgnoreCase("Blood")) {
                total = total + 300;
            } 
            else if (tests[i].equalsIgnoreCase("XRay")) {
                total = total + 500;
            } 
            else if (tests[i].equalsIgnoreCase("MRI")) {
                total = total + 2000;
            } 
            else if (tests[i].equalsIgnoreCase("CTScan")) {
                total = total + 1500;
            }
        }

        return total;
    }

    double calculateRoomFee(int days, String roomType) {
        double rate = 0;

        if (roomType.equalsIgnoreCase("General")) {
            rate = 1000;
        } 
        else if (roomType.equalsIgnoreCase("ICU")) {
            rate = 5000;
        } 
        else if (roomType.equalsIgnoreCase("Private")) {
            rate = 3000;
        }

        return days * rate;
    }

    double calculateMedicineFee(double[] medicineCosts) {
        double total = 0;

        for (int i = 0; i < medicineCosts.length; i++) {
            total = total + medicineCosts[i];
        }

        return total;
    }

    double calculateTotalBill(double... fees) {
        double total = 0;

        for (int i = 0; i < fees.length; i++) {
            total = total + fees[i];
        }

        return total;
    }

    double applyInsuranceDiscount(double total, String insurance) {
        double discount = 0;

        if (insurance.equalsIgnoreCase("StarHealth")) {
            discount = total * 0.15;
        } 
        else if (insurance.equalsIgnoreCase("LIC")) {
            discount = total * 0.10;
        }

        return discount;
    }
}
