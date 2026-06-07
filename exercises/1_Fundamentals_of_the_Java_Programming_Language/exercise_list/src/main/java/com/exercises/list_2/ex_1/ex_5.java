package com.exercises.list_2.ex_1;

import main.java.com.exercises.list_2.GeneralMethods;

public class ex_5 extends GeneralMethods {
    
    private void printMultiplicationTable(int number) {
        System.out.println("Multiplication Table for " + number + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }

    public void ex_5_multiplicationTable() {
        System.out.println("\nPlease, enter an integer to see its multiplication table:");
        String userInput = getUserInput();
        Object[] validationResult = inputTypeValidation(userInput, "integer");
        
        boolean isValid = (boolean) validationResult[0];
        if(isValid) {
            try{
                printMultiplicationTable((int) validationResult[1]);
            }catch (IllegalArgumentException e){
                System.err.println("\nSomething wrong with the multiplication table, please try again.");
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println("\nInvalid input. Please enter a valid integer for the multiplication table.");

        }
    }

}
