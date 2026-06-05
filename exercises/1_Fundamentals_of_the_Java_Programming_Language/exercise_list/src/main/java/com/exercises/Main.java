package com.exercises;
import com.exercises.ex_1.ex_1;
import com.exercises.ex_2.ex_2;
import com.exercises.ex_3.ex_3;
import com.exercises.ex_4.ex_4;

public class Main {

    private static void printSeparationLine(){
        System.out.println("This program has ended. Thanks for using it. \n--------------------------------------------------------------");
    }
    public static void main(String[] args) {
        // Exercise 1
        ex_1 exercise_1 = new ex_1();
        Object[] message = exercise_1.ex_1_getNameAndAge();
        System.out.println("Hello " + message[0] + ", you are " + message[1] + " years old");

        printSeparationLine();
        
        // Exercise 2
        ex_2 exercise_2 = new ex_2();
        double squareLength = exercise_2.ex_2_GetArea();
        System.out.println("The area of the square is: " + squareLength);
        
        printSeparationLine();
        
        // Exercise 3
        ex_3 exercise_3 = new ex_3();
        double rectangleArea = exercise_3.ex_3_getArea();
        if(rectangleArea != -1) {
            System.out.println("The area of the rectangle is: " + rectangleArea);
        } else {
            System.out.println("Something went wrong. Please try to run the program again.");
            System.exit(0);
        }
        
        printSeparationLine();
        
        // Exercise 4
        ex_4 exercise_4 = new ex_4();
        Object[] generalUserinfo = exercise_4.ex_4_getAgeGap();
        if(generalUserinfo != null && generalUserinfo[0] != null) {
            Object[] userOneInfo = (Object[]) generalUserinfo[0];
            Object[] userTwoInfo = (Object[]) generalUserinfo[1];
            int ageGap = (int) generalUserinfo[2];
            System.out.println("The age difference between the user " + userOneInfo[0] + " and the user " + userTwoInfo[0] + " is: " + ageGap + " years.");
        } else {
            System.out.println("Something went wrong. Please try to run the program again.");
            System.exit(0);
        }
        
        printSeparationLine();
    }
}