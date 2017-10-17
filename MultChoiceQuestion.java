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
public class MultChoiceQuestion implements Question{
    /**
     * The question is stored as a String, answers are saved in an
     * array of String for quick access, an integer array is used
     * to count
     */
    private String question;
    private String[] answers;
    private int[] answerCount;
    private int maxSelection;

    /**
     * Constructors of this class must either receive a question first,
     * allowing for questions later, or receive the question and set of
     * answers at the same time. The set of answers must be 5 possible answers
     */
    public MultChoiceQuestion(String q) {
        setQuestion(q);
        setMaxSelection(3);
    }

    public MultChoiceQuestion(String q, String[] ans) {
        question = q;
        setAnswers(ans);
        setMaxSelection(3);
    }

    @Override
    public void setQuestion(String q) {
        question = q;
    }

    @Override
    public String getQuestion() {
        return question;
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
    }

    @Override
    public void setMaxSelection(int maxSelection) {
        this.maxSelection = maxSelection;
    }

}
