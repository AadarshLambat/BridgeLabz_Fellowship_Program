package HospitalPatientBilling;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Hospital hospital = new Hospital();

        System.out.print("Enter doctor type: ");
        String doctorType = sc.nextLine();

        System.out.print("Enter number of tests: ");
        int testCount = sc.nextInt();
        sc.nextLine();

        String[] tests = new String[testCount];

        for (int i = 0; i < testCount; i++) {
            System.out.print("Enter test " + (i + 1) + ": ");
            tests[i] = sc.nextLine();
        }

        System.out.print("Enter number of room days: ");
        int days = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter room type: ");
        String roomType = sc.nextLine();

        System.out.print("Enter number of medicines: ");
        int medicineCount = sc.nextInt();

        double[] medicineCosts = new double[medicineCount];

        for (int i = 0; i < medicineCount; i++) {
            System.out.print("Enter medicine cost " + (i + 1) + ": ");
            medicineCosts[i] = sc.nextDouble();
        }

        sc.nextLine();

        System.out.print("Enter insurance: ");
        String insurance = sc.nextLine();

        double consultationFee =
                hospital.calculateConsultationFee(doctorType);

        double testFee =
                hospital.calculateTestFee(tests);

        double roomFee =
                hospital.calculateRoomFee(days, roomType);

        double medicineFee =
                hospital.calculateMedicineFee(medicineCosts);

        double totalBill =
                hospital.calculateTotalBill(
                        consultationFee,
                        testFee,
                        roomFee,
                        medicineFee
                );

        double insuranceDiscount =
                hospital.applyInsuranceDiscount(totalBill, insurance);

        double finalBill = totalBill - insuranceDiscount;

        System.out.println();
        System.out.println("Hospital Patient Bill");
        System.out.println("---------------------");
        System.out.println("Doctor Type: " + doctorType);
        System.out.println("Consultation Fee: Rs." + consultationFee);
        System.out.println("Test Fee: Rs." + testFee);
        System.out.println("Room Fee: Rs." + roomFee);
        System.out.println("Medicine Fee: Rs." + medicineFee);
        System.out.println("Total Bill: Rs." + totalBill);
        System.out.println("Insurance Discount: Rs." + insuranceDiscount);
        System.out.println("Final Bill: Rs." + finalBill);

        sc.close();
    }
}
