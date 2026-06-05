package com.exercises.ex_2;

import java.util.Scanner;

public class ex_2 {
    private Scanner scanner = new Scanner(System.in);
    
    //All methods are based on the separation of concerns principle, which means that each method has a single responsibility.
    private String getUserInput(){
        try{
            String value = scanner.nextLine();
            return value.trim();
        } catch (Exception e) {
            // Generic message for any exception that may occur during user input, such as InputMismatchException or NoSuchElementException.

            System.out.println("Something went wrong. Please try to run the program again.");
            System.out.println("Error details: " + e.getMessage());
            return null;
        }
    }
    
    private Object[] inputValidation(String userInput){
        if(userInput == null || userInput.trim().isEmpty()) {
            System.out.println("The value must not be empty. Please try again.");
            return new Object[]{false, null};
        }
        exitProgram(userInput);

        try{
            double userInputParsed = Double.parseDouble(userInput);
            return new Object[]{true, userInputParsed};
        }catch(Exception e){
            System.out.println("Invalid input. Must a valid number (ex.: 3.14).");
            return new Object[]{false, null};
        }
    }
    private static void exitProgram(String userInput){
        if(userInput != null && (userInput.equalsIgnoreCase("exit") || userInput.equalsIgnoreCase("quit"))) {
            System.out.println("Goodbye!");
            System.exit(0);
        }
    }

    private double getSquareLength(){
        boolean isValidInput = false;
        String squareLength;
        double squareLengthParsed = 0;

        do{
            System.out.println("Enter the length of the square's side: ");
            squareLength = getUserInput();
            Object[] validationResult = inputValidation(squareLength);
            isValidInput = (boolean) validationResult[0];
            if(isValidInput){ squareLengthParsed = (double) validationResult[1];}
        }while(!isValidInput);
        return squareLengthParsed;
    }

    private double calculateArea(double sideLength){
        return sideLength * sideLength;
    }

    public double ex_2_GetArea(){
        System.out.println("Welcome to the find the area of a square Program! \nIf you wish to leave, just type 'exit' or 'quit' at any time.");
        
        try{
            double squareLength = getSquareLength();
            return calculateArea(squareLength);
        } catch (Exception e) {
            System.out.println("Something went wrong. Please try to run the program again.");
            System.exit(0);
            return -1; // Return an error value
        }
    }
}
