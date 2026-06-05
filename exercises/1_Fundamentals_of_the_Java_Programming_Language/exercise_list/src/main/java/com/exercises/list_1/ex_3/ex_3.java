package com.exercises.ex_3;
import java.util.Scanner;

public class ex_3 {
    private Scanner scanner = new Scanner(System.in);

    private String getUserInput(){
        try{
            String input = scanner.nextLine();
            return input.trim();
        }catch(Exception e){
            System.out.println("Something went wrong. Please try again.");
            System.out.println("Error details: " + e.getMessage());
            return null;
        }
    }

    private void exitProgram(String userInput){
        if(userInput.equalsIgnoreCase("exit") || userInput.equalsIgnoreCase("quit")){
            System.out.println("Goodbye!");
            System.exit(0);

        }
    }

    private Object[] inputValidation(String userInput){
        if(userInput == null || userInput.trim().isEmpty()){
            System.out.println("The value must not be empty, please try again.");
            return new Object[]{false, null};
        }
        return new Object[]{true, userInput};
    }

    private double convertInputToDouble(String userInput){
        try{
            double valueParsed = Double.parseDouble(userInput);
            return valueParsed;
        }catch(Exception e){
            System.out.println("Something went wrong. Check if the value is a valid number (ex.: 3.14).");
            return -1;
        }
    }

    private double getBaseRectangle(){
        boolean isValidInput = false;
        double validValue = -1;

        do{
            System.out.println("Enter the base of the rectangle: ");
            String baseValue = getUserInput();
            Object[] validation = inputValidation(baseValue);
            
            if((boolean) validation[0]){
                exitProgram(baseValue);
                double baseParsed = convertInputToDouble((String) validation[1]);
                if(baseParsed != -1){ isValidInput = true; validValue = baseParsed;}
            }
        }while(!isValidInput);
        return validValue;
    }

    private double getHeightRectangle(){
        boolean isValidInput = false;
        double validValue = -1;

        do{
            System.out.println("Enter the height of the rectangle: ");
            String heightValue = getUserInput();
            Object[] validation = inputValidation(heightValue);
            
            if((boolean) validation[0]){
                exitProgram(heightValue);
                double heightParsed = convertInputToDouble((String) validation[1]);
                if(heightParsed != -1){ isValidInput = true; validValue = heightParsed;}
            }
        }while(!isValidInput);
        return validValue;
    }

    private double calculateArea(double base, double height){
        return base * height;
    }

    public double ex_3_getArea(){
        System.out.println("Welcome to the find the area of a rectangle Program! \nIf you wish to leave, just type 'exit' or 'quit' at any time.");
        
        try{
            double base = getBaseRectangle();
            double height = getHeightRectangle();

            if(base != -1 && height != -1){ return calculateArea(base, height);}
            return -1; // Return an error value
        } catch (Exception e) {
            System.out.println("What went wrong: " + e.getMessage());
            return -1; // Return an error value
        }
    }
}
