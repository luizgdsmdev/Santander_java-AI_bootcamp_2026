package com.exercise_1;
import com.exercise_1.ex_1.ex_1;
import com.exercise_1.ex_2.ex_2;
import com.exercise_1.ex_3.ex_3;

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
        ex_3 exercise_3 = new ex_3();
        double rectangleArea = exercise_3.ex_3_getArea();
        if(rectangleArea != -1) {
            System.out.println("The area of the rectangle is: " + rectangleArea);
        } else {
            System.out.println("Something went wrong. Please try to run the program again.");
            System.exit(0);
        }
    }
}