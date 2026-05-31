package com.exercise_1.ex_1;
import java.util.Scanner;
import java.time.LocalDate;

//TODO:
// Add personalized messages for each validation failure, such as "Name cannot be empty" or "Birth year must be a valid number". This will help users understand why their input is invalid and how to correct it.
// Add a feature to allow users to exit the program gracefully, such as by entering "exit" or "quit". This will improve the user experience by providing a clear way to end the program when they are finished.
// Add error handling for unexpected exceptions that may occur during input validation or age calculation. [This will help prevent the program from crashing and provide a better user experience.
// Add a feature to allow users to input their birth date (day, month, year) instead of just the birth year. This will allow for a more accurate age calculation and provide a more personalized experience for the user.

public class ex_1 {
    private Scanner scanner = new Scanner(System.in);
    private LocalDate currentDate = LocalDate.now();

    //All methods are based on the separation of concerns principle, which means that each method has a single responsibility. 
    //The getUsername method is responsible only for getting the user's name and validating it, while the nameValidation method is 
    //responsible only for validating the user's name based on simple criteria. This separation allows for better readability and maintainability of the code.
    //The same is true for any other method applied.
    private String getUserName(){
        boolean isValidName;
        String userName;

        do{//Runs ultil eventually the user prompts a valida name, which is not null, empty, or less than 2 characters long.
            System.out.println("Enter your name: ");
            userName = scanner.nextLine();
            isValidName = nameValidation(userName);
        }while(!isValidName);

        return userName;
    }
    private static boolean nameValidation(String userName) {
        if(userName == null || userName.trim().isEmpty() || userName.length() < 2) {
            System.out.println("Invalid name. Please enter a valid name with at least 2 characters.");
            return false;
        }

        return true;
    }

    private int getBirthYear(){
        String birthYear;
        boolean isValidBirthYear;
        do{
            System.out.println("Enter your birth year, must be a valid number (ex.: 1990): ");
            birthYear = scanner.nextLine();
            isValidBirthYear = birthYearValidation(birthYear);
        }while(!isValidBirthYear);

        return currentDate.getYear() - Integer.parseInt(birthYear);
    }

    private boolean birthYearValidation(String userBirthYear){
        int currentYear = currentDate.getYear();

        try{
        // The try-catch block is used to handle the potential NumberFormatException that may occur when trying to parse the user's input into an integer. 
        // If the user enters a non-numeric value, the catch block will catch the exception and print an error message.
            Integer.parseInt(userBirthYear);
        }catch(NumberFormatException e){
            System.out.println("Invalid input. Please enter a valid number for the birth year.");
            return false;
        }

        // The year of birth must be between 1876 and the current year, and the difference between the current year and the year of birth must be less than 150 years. 
        // This validation ensures that the user enters a realistic year of birth, considering the average human lifespan and historical context.
        int userBirthYearInt = Integer.parseInt(userBirthYear);

        if(userBirthYearInt < 1876 || userBirthYearInt > currentYear || currentYear - userBirthYearInt > 150) {
            System.out.println("It seens something is off, you're either too old or you haven't been born yet. Please enter a valid birth year between 1876 and the current year.");
            return false;
        }

        return true;
    }

    /**
     * @description: This class contains methods to receive a user's name and year of birth, validate both, and calculate the user's age based on the current date.
     * The main method in the Main class creates an instance of this class and calls the method to get the user's name and age, then prints a greeting message with 
     * the user's name and age.
     * @arguments: None
     * @return: String type, returns the user's name and age as a String in a welcoming message. 
     *  */
    public Object[] ex_1_getNameAndAge() {
        
        String userName = getUserName();
        int userBirthYear = getBirthYear();

        return new Object[]{userName, userBirthYear};
        
    }

}
