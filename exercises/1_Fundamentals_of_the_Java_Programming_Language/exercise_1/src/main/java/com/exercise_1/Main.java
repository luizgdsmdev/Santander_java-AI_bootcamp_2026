package com.exercise_1;
import com.exercise_1.ex_1.ex_1;
import com.exercise_1.ex_2.ex_2;
import com.exercise_1.ex_3.ex_3;
import com.exercise_1.ex_4.ex_4;

public class Main {
    public static void main(String[] args) {
        // Exercise 1
        // ex_1 exercise_1 = new ex_1();
        // Object[] message = exercise_1.ex_1_getNameAndAge();
        // System.out.println("Hello " + message[0] + ", you are " + message[1] + " years old");

        // Exercise 2
        // ex_2 exercise_2 = new ex_2();
        // double squareLength = exercise_2.ex_2_GetArea();
        // System.out.println("The area of the square is: " + squareLength);

        // Exercise 3
        // ex_3 exercise_3 = new ex_3();
        // double rectangleArea = exercise_3.ex_3_getArea();
        // if(rectangleArea != -1) {
        //     System.out.println("The area of the rectangle is: " + rectangleArea);
        // } else {
        //     System.out.println("Something went wrong. Please try to run the program again.");
        //     System.exit(0);
        // }

        // Exercise 4
        ex_4 exercise_4 = new ex_4();
        Object[] generalUserinfo = exercise_4.ex_4_getAgeGap();
        Object[] userOneInfo = (Object[]) generalUserinfo[0];
        Object[] userTwoInfo = (Object[]) generalUserinfo[1];
        int ageGap = (int) generalUserinfo[2];
        if(generalUserinfo[0] != null) {
            System.out.println("The age difference between the user " + userOneInfo[0] + " and the user " + userTwoInfo[0] + " is: " + ageGap + " years.");
        } else {
            System.out.println("Something went wrong. Please try to run the program again.");
            System.exit(0);
        }
    }
}