/**
 * Alfredo Ceballos
 * CS 356 - Object Oriented Design and Programming
 * Professor Yu Sun
 * Assignment 1
 */

/**
 * The question interface only forces any classes that implement it
 * to create a question, a set of answers, the number of maximum
 * selections that can be made to that question, and the number of
 * answers for that question
 */
public interface Question {
    public void setQuestion(String q);
    public String getQuestion();
    public void setNumOfAnswers(int n);
    public void setAnswers(String[] ans);
	public void printQuestion();
	public void setMaxSelection(int maxSelection);
}
