package CorruptedTelemetryParser;

class TelemetryParser {

    double processValue(double val) {
        if (val < 0) {
            val = 0;
        }

        return val;
    }

    void parseTelemetry(String raw) {
        String[] pairs = raw.split(";");

        double[] temperatures = new double[pairs.length];
        double[] pressures = new double[pairs.length];
        String[] statuses = new String[pairs.length];

        int tempCount = 0;
        int pressureCount = 0;
        int statusCount = 0;

        for (int i = 0; i < pairs.length; i++) {
            String pair = pairs[i];

            int colon = pair.indexOf(':');

            if (colon == -1) {
                continue;
            }

            String key = pair.substring(0, colon);
            String value = pair.substring(colon + 1);

            if (key.equals("T")) {
                try {
                    double val = Double.parseDouble(value);
                    val = processValue(val);
                    temperatures[tempCount] = val;
                    tempCount++;
                } catch (Exception e) {
                    temperatures[tempCount] = -1;
                    tempCount++;
                }
            } 
            else if (key.equals("P")) {
                try {
                    double val = Double.parseDouble(value);
                    val = processValue(val);
                    pressures[pressureCount] = val;
                    pressureCount++;
                } catch (Exception e) {
                    pressures[pressureCount] = -1;
                    pressureCount++;
                }
            } 
            else if (key.equals("S")) {
                if (value.length() > 0) {
                    statuses[statusCount] = value;
                } else {
                    statuses[statusCount] = "ERROR";
                }

                statusCount++;
            }
        }

        double temperatureSum = 0;
        int validTemperatures = 0;

        for (int i = 0; i < tempCount; i++) {
            if (temperatures[i] != -1) {
                temperatureSum = temperatureSum + temperatures[i];
                validTemperatures++;
            }
        }

        double averageTemperature = 0;

        if (validTemperatures > 0) {
            averageTemperature = temperatureSum / validTemperatures;
        }

        double maximumPressure = -1;

        for (int i = 0; i < pressureCount; i++) {
            if (pressures[i] != -1) {
                if (maximumPressure == -1 || pressures[i] > maximumPressure) {
                    maximumPressure = pressures[i];
                }
            }
        }

        System.out.println();
        System.out.println("Telemetry Report");
        System.out.println("----------------");

        if (validTemperatures > 0) {
            System.out.println("Average Temperature: " + averageTemperature);
        } else {
            System.out.println("Average Temperature: -1");
        }

        System.out.println("Maximum Pressure: " + maximumPressure);

        System.out.println("Status Values:");

        for (int i = 0; i < statusCount; i++) {
            System.out.println(statuses[i]);
        }
    }
}
