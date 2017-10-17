/**
 * Alfredo Ceballos
 * CS 356 - Object Oriented Design and Programming
 * Professor Yu Sun
 * Assignment 1
 */

/**
 * The question interface only forces any classes that implement it
 * to create a question and a set of answers, and the number of maximum
 * selections that can be made to that question.
 */
public interface Question {
    public void setQuestion(String q);
    public String getQuestion();
    public void setAnswers(String[] ans);
	public void printQuestion();
	public void setMaxSelection(int maxSelection);
}
