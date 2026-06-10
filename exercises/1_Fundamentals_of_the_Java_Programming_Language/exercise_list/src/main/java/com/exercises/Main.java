package com.exercises;
import java.util.Scanner;

import com.exercises.ex_1.ex_1;
import com.exercises.ex_2.ex_2;
import com.exercises.ex_3.ex_3;
import com.exercises.ex_4.ex_4;
import com.exercises.list_2.ex_1.ex_5;
import com.exercises.list_2.ex_6.ex_6;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static void printSeparationLine(){
        System.out.println("\nThis part of the program has ended. Thanks for using it. \n--------------------------------------------------------------");
    }

    private static void exerciseListOne(){
        System.out.println("\nWelcome to the Exercise List 1! \nType 'exit' at any moment to close the program.");
        System.out.println("Let's start with the options! Please, select the exercise you want to run: \n0 - Return to the main menu \n1 - Age consult \n2 - The area of the square \n3 - The area of the rectangle \n4 - The age difference\nexit - Close the program\n");
        boolean isRunning = false;
        
        do{
            try{
                String userInput = getUserInput();
                int exerciseSelected = userinputValidation(userInput);

                if(exerciseSelected != -1){
                    if(exerciseSelected == 0){
                        isRunning = true;
                        System.out.println("\nReturning to the main menu...\n");
                        main(null);
                        return;
                    } else if(exerciseSelected == 1){
                    // Exercise 1
                    isRunning = true;
                    ex_1 exercise_1 = new ex_1();
                    Object[] message = exercise_1.ex_1_getNameAndAge();
                    System.out.println("Hello " + message[0] + ", you are " + message[1] + " years old");
                    printSeparationLine();
                    
                    exerciseListOne();// Return to the main menu of the exercise list 1

                    } else if(exerciseSelected == 2){
                        // Exercise 2
                        isRunning = true;
                        ex_2 exercise_2 = new ex_2();
                        double squareLength = exercise_2.ex_2_GetArea();
                        System.out.println("The area of the square is: " + squareLength);
                        printSeparationLine();

                        exerciseListOne();// Return to the main menu of the exercise list 1

                    } else if(exerciseSelected == 3){
                        // Exercise 3
                        isRunning = true;
                        ex_3 exercise_3 = new ex_3();
                        double rectangleArea = exercise_3.ex_3_getArea();
                        if(rectangleArea != -1) {
                            System.out.println("The area of the rectangle is: " + rectangleArea);
                        } else {
                            System.out.println("Something went wrong. Please try to run the program again.");
                            System.exit(0);
                        }
                        printSeparationLine();

                        exerciseListOne();// Return to the main menu of the exercise list 1

                    } else if(exerciseSelected == 4){
                        // Exercise 4
                        isRunning = true;
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

                        exerciseListOne();// Return to the main menu of the exercise list 1

                    } else {
                        System.out.println("\nPlease, review the options: \n0 - Return to the main menu \n1 - Age consult \n2 - The area of the square \n3 - The area of the rectangle \n4 - The age difference\nexit - Close the program\n");
                    }
                
                } else {
                    System.out.println("\nPlease, review the options: \n0 - Return to the main menu \n1 - Age consult \n2 - The area of the square \n3 - The area of the rectangle \n4 - The age difference\nexit - Close the program\n");
                }
        } catch (Exception e) {
            System.out.println("Something went wrong. Please try to run the program again.");
            System.exit(0);
        }

        }while(!isRunning);
    }
        
    private static void exerciseListTwo(){
        System.out.println("\nWelcome to the Exercise List 2! \nType 'exit' at any moment to close the program.");
        System.out.println("Let's start with the options! Please, select the exercise you want to run: \n0 - Return to the main menu \n1 - Multiplication table \n2 - BMI calculation \nExit - Close the program\n");
        boolean isRunning = false;
        
        do{
            try{
                String userInput = getUserInput();
                int exerciseSelected = userinputValidation(userInput);

                if(exerciseSelected != -1){
                    if(exerciseSelected == 0){
                        isRunning = true;
                        System.out.println("\nReturning to the main menu...\n");
                        main(null);
                        return;
                    } else if(exerciseSelected == 1){
                        // Exercise 1
                        isRunning = true;
                        
                        ex_5 ex_5 = new ex_5();
                        ex_5.ex_5_multiplicationTable();
                        printSeparationLine();
                        
                        exerciseListTwo();// Return to the main menu of the exercise list 2

                    } else if(exerciseSelected == 2){
                        // Exercise 2
                        isRunning = true;
                        
                        ex_6 ex_6 = new ex_6();
                        ex_6.ex_6_BmiCalculation();
                        printSeparationLine();
                        
                        exerciseListTwo();// Return to the main menu of the exercise list 2

                    }else {
                        System.err.println("\nPlease, review the options: \n0 - Return to the main menu \n1 - Multiplication table \n2 - BMI calculation \nExit - Close the program\n");
                    }
                
                } else {
                    System.err.println("\nPlease, review the options: \n0 - Return to the main menu \n1 - Multiplication table \n2 - BMI calculation \nExit - Close the program\n");
                }
        } catch (Exception e) {
            System.err.println("Something went wrong. Please try to run the program again.");
            System.exit(0);
        }

        }while(!isRunning);
    }
    
    private static String getUserInput(){
        try{
            String input = scanner.nextLine();
            return input.trim();
        }catch(Exception e){
            System.err.println("Something went wrong while getting your response. Please try to run the program again.");
            System.exit(0);
        }
        return null;
    }
    
    private static void exitProgram(String userInput){
        if(userInput.equalsIgnoreCase("exit")){
            System.out.println("Goodbye!");
            System.exit(0);
        }

    }
    private static int parseToInt(String userInput){
        try{
            int valueParsed = Integer.parseInt(userInput);
            return valueParsed;
        }catch(Exception e){
            System.err.println("\nSomething went wrong with your response. Please, review the open options. \n");
            return -1;
        }
    }

    private static boolean isNotEmptyInput(String userInput){
        if(userInput == null || userInput.trim().isEmpty()){
            System.err.println("The value must not be empty, please try again.\n");
            return false;
        }
        return true;
    }

    private static int userinputValidation(String userInput){
        boolean isValid = isNotEmptyInput(userInput);
        
        if(isValid){
            exitProgram(userInput);
            int userInputParsed = parseToInt(userInput);
            if(userInputParsed != -1){
                return userInputParsed;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {

        try{
            System.out.println("Welcome to the Java exercises! \nPlease select the exercise list you want to run: \n1 - Exercise List 1 \n2 - Exercise List 2 \nType 'exit' to close the program.");

            do{
                String userInput = getUserInput();
                int exerciseListSelected = userinputValidation(userInput);

                if(exerciseListSelected == 1){
                    exerciseListOne();
                    break;
                } else if(exerciseListSelected == 2){
                    exerciseListTwo();
                    break;
                } else {
                    System.out.println("Select the exercise list you want to run: \n1 - Exercise List 1 \n2 - Exercise List 2");
                }
            }while(true);

        }catch(Exception e){
            System.out.println("Something went wrong. Please try to run the program again.");
            System.exit(0);
        }finally{
            scanner.close();
        }
    }
}