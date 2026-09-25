
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Monument monument = new Monument();

        System.out.print("Enter size: ");
        int size = sc.nextInt();

        System.out.print("Enter symbol: ");
        char symbol = sc.next().charAt(0);

        System.out.println();
        monument.printMonument(size, symbol);

        sc.close();
    }
}