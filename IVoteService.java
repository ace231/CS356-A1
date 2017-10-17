/**
 * Alfredo Ceballos
 * CS 356 - Object Oriented Design and Programming
 * Professor Yu Sun
 * Assignment 1
 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class IVoteService {
    private List<Student> students;
    private Question question;
    private HashMap<Student, String[]> studentToSubmissions;
    private int[] subCount;

    public IVoteService(List<Student> students) {
        this.students = students;
    }

    public IVoteService(String[] students) {
        for (int i = 0; i < students.length; i++) {
            this.students.add(new Student(students[i]));
        }
    }

    /**
     * To set the question the service will display, the question itself
     * can be provided as a string, but the user must specify what kind of
     * question is being asked. An integer value is used to differentiate
     * between what kind of question should be asked. A 0 is multiple choice,
     * a 1 is single choice. Any other kinds of questions can be added in as
     * other integer values. Also each time a question is set, an integer array
     * is created to count the number of submissions for each answer.
     */

    public void setQuestion(String question, String[] ans, int qType) {
        if (qType == 0) {
            this.question = new MultChoiceQuestion(question);
            this.question.setAnswers(ans);
            this.question.setNumOfAnswers(ans.length);
        } else if (qType == 1) {
            this.question = new SingleChoiceQuestion(question, ans);
            //this.question.setAnswers(ans);
            this.question.setNumOfAnswers(ans.length);
        } else {
            System.out.println("Incorrect parameters for question, please check documentation...");
        }
        subCount = new int[this.question.getNumOfAnswers()];
    }

    public void addStudent(String id) {
        students.add(new Student(id));
    }

    /**
     * A student and their choice(s) are passed as parameters to this method
     * where the student's previous choice(s) is(are) check against any previous
     * one(s), if different then their choice(s) is(are) updated. If the question
     * is a single choice question and multiple choices were picked, then the first
     * choice is counted. Any later submission will update to the newest submission.
     */
    public void takeSubmission(Student s, String choice) {
        String[] choices = choice.toLowerCase().split("[, ]");
        if(studentToSubmissions.get(s) == null || studentToSubmissions.isEmpty()) {
            studentToSubmissions.put(s, choices);
        } else{
            studentToSubmissions.replace(s, choices);
        }
    }

    /**
     * The entire list of students is accessed using an iterator object.
     * Each students choices are then accessed and checked based on what
     * kind of question was asked.
     */
    private void checkSubmissions() {
        Iterator<Student> it = students.iterator();
        String choice;
        String[] tempArr;

        if (this.question instanceof SingleChoiceQuestion) {

            while(it.hasNext()){
                tempArr = studentToSubmissions.get(it.next());
                choice = tempArr[0];
                if(choice.charAt(0) == 'a'){subCount[0]++;}
                else if(choice.charAt(0) == 'b'){subCount[1]++;}
                else if(choice.charAt(0) == 'c'){subCount[2]++;}
                else if(choice.charAt(0) == 'd'){subCount[3]++;}
            }

        } else if (this.question instanceof MultChoiceQuestion) {
            while(it.hasNext()){

                tempArr = studentToSubmissions.get(it.next());
                for (int i = 0; i < 3; i++){
                    if(tempArr[i].charAt(0) == 'a'){subCount[0]++;}
                    else if(tempArr[i].charAt(0) == 'b'){subCount[1]++;}
                    else if(tempArr[i].charAt(0) == 'c'){subCount[2]++;}
                    else if(tempArr[i].charAt(0) == 'd'){subCount[3]++;}
                    else if(tempArr[i].charAt(0) == 'e'){subCount[4]++;}
                }

            }

        } //End of if else if
    }//End of checkSubmissions

    public void displayQuestion() {
        this.question.printQuestion();
    }

    public void printResults() {
        checkSubmissions();
        String[] letters = {"A","B","C","D","E"};
        for(int i = 0; i < subCount.length; i++){
            System.out.printf("%s: %d",letters[i], subCount[i]);
        }
    }

}
