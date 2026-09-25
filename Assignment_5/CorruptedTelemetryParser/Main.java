package CorruptedTelemetryParser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TelemetryParser parser = new TelemetryParser();

        System.out.print("Enter telemetry: ");
        String raw = sc.nextLine();

        parser.parseTelemetry(raw);

        sc.close();
    }
}