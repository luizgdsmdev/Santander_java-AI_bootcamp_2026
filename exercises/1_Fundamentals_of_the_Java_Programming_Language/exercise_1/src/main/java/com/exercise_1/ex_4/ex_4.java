package com.exercise_1.ex_4;
import java.util.Scanner;

public class ex_4 {
    private Scanner scanner = new Scanner(System.in);

    private String getUserInput(){
        try{
            String userInput = scanner.nextLine();
            return userInput;
        }catch (Exception e){
            System.out.println("An error occurred while reading input. Please try again.");
            return null;
        }
    }

    private Object[] validateYearOfBirth(String userInput){
        try{
            int yearOfBirth = Integer.parseInt(userInput);
            if(yearOfBirth < 1900 || yearOfBirth > 2026){
                System.out.println("Please enter a valid year of birth between 1900 and 2026.");
                return new Object[]{false, null};
            }
            return new Object[]{true, yearOfBirth};
        }catch (NumberFormatException e){
            System.out.println("Invalid input. Please enter a numeric value for the year of birth, ex.: 1990.");
            return new Object[]{false, null};
        }
    }

    private Object[] validateUserName(String userName){
        if(userName.trim().length() < 2){
            System.out.println("Name must be at least 2 characters long. Please enter a valid name, ex.: John Doe.");
            return new Object[]{false, null};

        }
        return new Object[]{true, userName};
    }

    private Object[] generalUserInputValidation(String userInput){
        if(userInput == null || userInput.trim().isEmpty()){
            System.out.println("Input cannot be empty. Please enter a valid value.");
            return new Object[]{false, null};
        }

        return new Object[]{true, userInput};
    }

    private void exitProgram(String userInput){
        if(userInput.trim().equalsIgnoreCase("quit") || userInput.trim().equalsIgnoreCase("exit")){
            System.out.println("Exiting the program. Goodbye!");
            System.exit(0);
        }
    }

    private int ageDifference(int userOne, int UserTwo){
        try{
            return Math.abs(userOne - UserTwo);
        }
        catch (Exception e){
            System.out.println("An error occurred while calculating the age difference.");
            return -1;
        }
    }

    private Object[] getUserInfo(String userNumber){
        boolean isValidNameInput = false;
        boolean isValidAgeInput = false;
        String userName = null;
        int yearOfBirth = 0;
        do{
            System.out.println("Please enter the " + userNumber + " user name:");
            String nameInput = getUserInput();

            Object[] generalValidationResult = generalUserInputValidation(nameInput);

            //Here, we're passing the beacon of validation through the different validation methods, ensuring that the input is not null or empty, 
            //then validating the name, and finally checking if the user wants to exit the program, which will control the flow of the program and 
            //prevent unnecessary validations if the user intends to quit. This way, we maintain a clear separation of concerns while ensuring a 
            //smooth user experience.
            isValidNameInput = (boolean) generalValidationResult[0];
            if(isValidNameInput){
                Object[] nameValidationResult = validateUserName(nameInput);
                isValidNameInput = (boolean) nameValidationResult[0];
                if(isValidNameInput){
                    exitProgram(nameInput);
                    userName = (String) nameValidationResult[1];
                    isValidNameInput = true;
                }
            }            
        }while(!isValidNameInput);
        
        do{
            System.out.println("Please enter the user " + userNumber + " year of birth:");
            String yearInput = getUserInput();

            Object[] generalValidationResult = generalUserInputValidation(yearInput);

            //Here, we're passing the beacon of validation through the different validation methods, ensuring that the input is not null or empty, 
            //then validating the name, and finally checking if the user wants to exit the program, which will control the flow of the program and 
            //prevent unnecessary validations if the user intends to quit. This way, we maintain a clear separation of concerns while ensuring a 
            //smooth user experience.
            isValidAgeInput = (boolean) generalValidationResult[0];
            if(isValidAgeInput){
                Object[] yearValidationResult = validateYearOfBirth(yearInput);
                isValidAgeInput = (boolean) yearValidationResult[0];
                if(isValidAgeInput){
                    exitProgram(yearInput);
                    yearOfBirth = (int) yearValidationResult[1];
                    isValidAgeInput = true;
                }
            }     
        }while(!isValidAgeInput);

        return new Object[]{userName, yearOfBirth};
    }

    public Object[] ex_4_getAgeGap(){
        System.out.println("Welcome to the find the age gap Program! \nIf you wish to leave, just type 'exit' or 'quit' at any time.");

        try{
            Object[] userOneInfo = getUserInfo("first");
            Object[] userTwoInfo = getUserInfo("second");
            int ageGap = ageDifference((int) userOneInfo[1], (int) userTwoInfo[1]);
            return new Object[]{userOneInfo, userTwoInfo, ageGap};
        }
        catch (Exception e){
            System.out.println("An error occurred while running the program. Please try again.");
            System.exit(0);
        }finally{
            scanner.close();
        }
        // This return is just to satisfy the method's return type, it will never be reached due to System.exit(0) in the catch block.
        return null;
    }
}
