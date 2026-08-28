package University;

class University {

    double getCutoff(String category) {
        if (category.equalsIgnoreCase("General")) {
            return 85;
        } else if (category.equalsIgnoreCase("OBC")) {
            return 75;
        } else if (category.equalsIgnoreCase("SC/ST")) {
            return 65;
        } else {
            return -1;
        }
    }

    double getFinalCutoff(String category, boolean sports, boolean ncc) {
        double cutoff = getCutoff(category);

        if (cutoff == -1) {
            return -1;
        }

        if (sports) {
            cutoff = cutoff - 5;
        }

        if (ncc) {
            cutoff = cutoff - 3;
        }

        return cutoff;
    }

    double getTuitionFee(String category) {
        if (category.equalsIgnoreCase("General")) {
            return 100000;
        } else if (category.equalsIgnoreCase("OBC")) {
            return 75000;
        } else if (category.equalsIgnoreCase("SC/ST")) {
            return 50000;
        } else {
            return -1;
        }
    }

    double getTotalFee(String category, boolean hostel) {
        double fee = getTuitionFee(category);

        if (hostel) {
            fee = fee + 40000;
        }

        return fee;
    }

    boolean isAdmitted(double score, double cutoff) {
        return score >= cutoff;
    }
}
