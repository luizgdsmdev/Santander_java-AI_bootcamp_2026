package com.exercise_1;
import com.exercise_1.ex_1.ex_1;

public class Main {
    public static void main(String[] args) {
        ex_1 exercise_1 = new ex_1();
        Object[] message = exercise_1.ex_1_getNameAndAge();
        System.out.println("Hello " + message[0] + ", you are " + message[1] + " years old");
    }
}