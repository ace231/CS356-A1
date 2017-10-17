/**
 * Alfredo Ceballos
 * CS 356 - Object Oriented Design and Programming
 * Professor Yu Sun
 * Assignment 1
 */

/**
 * This multiple choice question class allows up to 5
 * possible answers to be displayed to students
 * and 3 to be selected
 */
public class MultChoiceQuestion implements Question {
    /**
     * The question is stored as a String, answers are saved in an
     * array of String for quick access, the number of maximum selections
     * allowed is saved as an integer value, and the number of possible
     * answers is also an integer
     */
    private String question;
    private String[] answers;
    private int maxSelection;
    private int numOfAnswers;

    /**
     * Constructors of this class must either receive a question first,
     * allowing for questions later, or receive the question and set of
     * answers at the same time. The set of answers must be 5 possible answers
     */
    public MultChoiceQuestion(String q) {
        setQuestion(q);
        setMaxSelection(3);
        setNumOfAnswers(5);
    }

    public MultChoiceQuestion(String q, String[] ans) {
        question = q;
        setAnswers(ans);
        setMaxSelection(3);
        setNumOfAnswers(5);
    }

    @Override
    public void setQuestion(String q) {
        question = q;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public void setNumOfAnswers(int n) {
        numOfAnswers = n;
    }

    @Override
    public int getNumOfAnswers() {
        return numOfAnswers;
    }

    /**
     * In order to set the answers for a multiple choice question,
     * all the possible answers have to be submitted at once as an
     * array of Strings
     */
    @Override
    public void setAnswers(String[] ans) {
        if (answers.length != 5) {
            System.out.println("Please check to make sure 5 answers are provided for the question!!!");
        } else {
            for (int i = 0; i < 5; i++) {
                answers[i] = ans[i];
            }
        }
    }

    @Override
    public void printQuestion() {
        System.out.print(question);
        String[] letters = {"A)", "B)", "C)", "D).", "E)"};
        for (int i = 0; i < answers.length; i++) {
            System.out.printf("%s %s%n", letters[i], answers[i]);
        }
    }

    @Override
    public void setMaxSelection(int maxSelection) {
        this.maxSelection = maxSelection;
    }

}
