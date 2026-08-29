package OnlineQuiz;
class Quiz {

    String getQuestion(int question) {
        switch (question) {
            case 1:
                return "What is the capital of France? (A) London (B) Paris (C) Berlin (D) Madrid";
            case 2:
                return "5 + 3 = ? (A) 7 (B) 8 (C) 9 (D) 6";
            case 3:
                return "Java is a: (A) Database (B) OS (C) Language (D) Browser";
            case 4:
                return "Which is an operating system? (A) Python (B) Linux (C) HTML (D) MySQL";
            case 5:
                return "Which symbol is used for comments in Java? (A) // (B) ## (C) ** (D) %%";
            default:
                return "";
        }
    }

    char getCorrectAnswer(int question) {
        switch (question) {
            case 1:
                return 'B';
            case 2:
                return 'B';
            case 3:
                return 'C';
            case 4:
                return 'B';
            case 5:
                return 'A';
            default:
                return ' ';
        }
    }

    boolean checkAnswer(int question, char answer) {
        return answer == getCorrectAnswer(question);
    }
}
