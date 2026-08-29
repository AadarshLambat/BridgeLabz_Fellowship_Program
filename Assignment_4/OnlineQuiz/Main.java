package OnlineQuiz;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Quiz quiz = new Quiz();

        int score = 0;
        int attempted = 0;

        for (int i = 1; i <= 5; i++) {

            System.out.println("Q" + i + ": " + quiz.getQuestion(i));
            System.out.print("Your answer: ");

            char answer = Character.toUpperCase(sc.next().charAt(0));

            if (answer == 'Q') {
                System.out.println("You quit the quiz.");
                break;
            }

            attempted++;

            if (quiz.checkAnswer(i, answer)) {
                score = score + 10;
                System.out.println("Correct! Score: " + score);
            } else {
                System.out.println("Wrong! Score: " + score);
            }
        }

        System.out.println("=== Quiz Over ===");
        System.out.println("Questions attempted: " + attempted);
        System.out.println("Final score: " + score + "/" + (attempted * 10));

        double percentage = 0;

        if (attempted > 0) {
            percentage = (double) score / (attempted * 10) * 100;
        }

        System.out.println("Percentage: " + percentage + "%");

        sc.close();
    }
}