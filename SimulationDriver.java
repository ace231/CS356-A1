/**
 * Alfredo Ceballos
 * CS 356 - Object Oriented Design and Programming
 * Professor Yu Sun
 * Assignment 1
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.List;

public class SimulationDriver {

    public static void main(String[] args) {
        List<Student> students = genStudents();
        Iterator<Student> it = students.iterator();
        System.out.print("Students generated with IDs: ");
        while(it.hasNext()){
            Student currStudent = it.next();
            System.out.print(currStudent.getID() + " ");
        }
        System.out.println();

        IVoteService service = new IVoteService(students);

        String q = "What is your favorite color out of the following? Pick one.";
        String[] ans = {"Red", "Blue", "Green", "Yellow"};
        service.setQuestion(q, ans, 1);
        service.displayQuestion();

        it = students.iterator();
        while(it.hasNext()){
            Student currStudent = it.next();
            String choice = genSingleChoice();
            System.out.printf("Student %s picked %s", currStudent.getID(), choice);
            service.takeSubmission(currStudent, choice);
        }
        service.printResults();

    }// End of main

    // This method generates 5 students with random ID's
    public static List<Student> genStudents() {
        List<Student> studentList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int temp = rand.nextInt(9999);
            String tempStr = String.format("%04d", temp);
            studentList.add(new Student(tempStr));
        }
        return studentList;
    }// End of genStudents

    public static String genSingleChoice(){
        Random rand = new Random();
        int randInt = rand.nextInt(3); // Can be 0, 1, 2, 4
        String[] letterChoices  = {"a", "b", "c", "d"};
        return letterChoices[randInt];
    }

}
