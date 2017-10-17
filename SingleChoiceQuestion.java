/**
 * Created by Alfredo on 10/17/2017.
 */

/**
 * This class creates a single choice question with the ability
 * to pick only 1 out of 4 possible answers
 */
public class SingleChoiceQuestion implements Question{
    private String question;
    private String[] answers;
    private int maxSelection;
    private int numOfAnswers;

    /**
     * Constructors of this class allow for the question to be provided
     * first then answers, or both the question and answers at the same time.
     * Other parameters are set.
     */
    public SingleChoiceQuestion(String q){
        question = q;
        setMaxSelection(1);
        setNumOfAnswers(4);
    }

    public SingleChoiceQuestion(String q, String[] ans) {
        question = q;
        setMaxSelection(1);
        setNumOfAnswers(4);
        setAnswers(ans);
    }

    @Override
    public void setQuestion(String q){
        question = q;
    }

    @Override
    public String getQuestion(){
        return question;
    }

    @Override
    public void setNumOfAnswers(int n){
        numOfAnswers = 4;
    }

    @Override
    public void setAnswers(String[] ans){
        if(ans.length != numOfAnswers) {
            System.out.println("Make sure 4 possible answers are being submitted!!!");
        } else {
            for(int i = 0; i < numOfAnswers; i++){
                answers[i] = ans[i];
            }
        }
    }

    @Override
    public void printQuestion(){
        System.out.println(question);
        String[] letters = {"A)", "B)", "C)", "D)"};
        for (int i = 0; i < answers.length; i++){
            System.out.printf("%s %s%n", letters[i], answers[i]);
        }
    }

    @Override
    public void setMaxSelection(int maxSelection){
        this.maxSelection = maxSelection;
    }
}
