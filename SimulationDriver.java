/**
 * Alfredo Ceballos
 * CS 356 - Object Oriented Design and Programming
 * Professor Yu Sun
 * Assignment 1
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class SimulationDriver {

    public static void main(String[] args) {
        List<Student> students = genStudents();
        IVoteService service = new IVoteService(students);

        String[] ans = {"Red", "Blue", "Green", "Yellow"};
        service.setQuestion("What is your favorite color out of the following", ans, 1);


    }// End of main

    // This method generates 5 students with random ID's
    private static List<Student> genStudents() {
        List<Student> studentList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int temp = rand.nextInt(9999);
            String tempStr = String.format("%04d", temp);
            studentList.add(new Student(tempStr));
        }
        return studentList;
    }// End of genStudents


}
