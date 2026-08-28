package Assignment3;

class Student {

    boolean validateMarks(double mark1, double mark2, double mark3) {
        return mark1 >= 0 && mark1 <= 100 &&
               mark2 >= 0 && mark2 <= 100 &&
               mark3 >= 0 && mark3 <= 100;
    }

    double getAverage(double mark1, double mark2, double mark3) {
        return (mark1 + mark2 + mark3) / 3;
    }

    String getGrade(double average) {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    String getRemark(String grade) {
        switch (grade) {
            case "A":
                return "Excellent";
            case "B":
                return "Good";
            case "C":
                return "Average";
            case "D":
                return "Below Average";
            case "F":
                return "Fail";
            default:
                return "Invalid";
        }
    }

    boolean isPassed(double mark1, double mark2, double mark3, double average) {
        return mark1 >= 40 && mark2 >= 40 && mark3 >= 40 && average >= 50;
    }

    int getGraceSubject(double mark1, double mark2, double mark3) {
        int count = 0;
        int subject = 0;

        if (mark1 >= 35 && mark1 <= 39) {
            count++;
            subject = 1;
        }

        if (mark2 >= 35 && mark2 <= 39) {
            count++;
            subject = 2;
        }

        if (mark3 >= 35 && mark3 <= 39) {
            count++;
            subject = 3;
        }

        if (count == 1) {
            return subject;
        }

        return 0;
    }
}

