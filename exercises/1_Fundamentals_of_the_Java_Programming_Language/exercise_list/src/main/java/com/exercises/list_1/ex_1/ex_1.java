package com.exercises.ex_1;
import java.time.LocalDate;
import java.util.Scanner;

public class ex_1 {
    private Scanner scanner = new Scanner(System.in);
    private LocalDate currentDate = LocalDate.now();

    //All methods are based on the separation of concerns principle, which means that each method has a single responsibility. 
    //The getUsername method is responsible only for getting the user's name and validating it, while the nameValidation method is 
    //responsible only for validating the user's name based on simple criteria. This separation allows for better readability and maintainability of the code.
    //The same is true for any other method applied.
    private String getUserName(){
        boolean isValidName = false;
        String userName;

        do{//Runs ultil eventually the user prompts a valida name, which is not null, empty, or less than 2 characters long.
            System.out.println("Enter your name: ");
            userName = getUserInput();
            isValidName = nameValidation(userName);
            
        } while (!isValidName);

        return userName;
    }
    private static boolean nameValidation(String userName) {
        //The exitProgram method is called to check if the user wants to exit the program by entering "exit" or "quit".
        // If the user enters either of these commands, the program will print a goodbye message and terminate. 
        // This allows users to exit the program gracefully at any point during the input process.

        if(userName == null || userName.trim().isEmpty() || userName.length() < 2 || userName == null) {
            exitProgram(userName);
            System.out.println("Invalid name. Please enter a valid name with at least 2 characters.");
            return false;
        }
        exitProgram(userName);

        return true;
    }

    private int getBirthYear(){
        boolean isValidBirthYear = false;
        String birthYear;
        do{
            System.out.println("Enter your birth year, must be a valid number (ex.: 1990): ");
            birthYear = getUserInput();
            isValidBirthYear = birthYearValidation(birthYear);
        }while(!isValidBirthYear);

        return calculateAge(Integer.parseInt(birthYear)); //The calculateAge method is called to calculate the user's age based on the year of birth
    }


    private boolean birthYearValidation(String userBirthYear){
        int currentYear = currentDate.getYear();
        int userBirthYearInt;

        try{
        // The try-catch block is used to handle the potential NumberFormatException that may occur when trying to parse the user's input into an integer. 
        // If the user enters a non-numeric value, the catch block will catch the exception and print an error message.
            exitProgram(userBirthYear);
            userBirthYearInt = Integer.parseInt(userBirthYear);
        }catch(NumberFormatException e){
            System.out.println("Invalid input. Please enter a valid number for the birth year.");
            return false;
        }

        // The year of birth must be between 1876 and the current year, and the difference between the current year and the year of birth must be less than 150 years. 
        // This validation ensures that the user enters a realistic year of birth, considering the average human lifespan and historical context.
        if(userBirthYearInt < 1876 || userBirthYearInt > currentYear || currentYear - userBirthYearInt > 150) {
            System.out.println("It seens something is off, you're either too old or you haven't been born yet. Please enter a valid birth year between 1876 and the current year.");
            return false;
        }

        return true;
    }

    private int calculateAge(int birthYear){
        return currentDate.getYear() - birthYear;
    }

    private static void exitProgram(String messageValue){
        if(messageValue.equalsIgnoreCase("exit") || messageValue.equalsIgnoreCase("quit")) {
                System.out.println("Exiting the program. Goodbye!");
                System.exit(0);
            }
    }

    // The getUserInput method is responsible for reading the user's input from the console. 
    // It uses a try-catch block to handle any potential exceptions that may occur during input reading with the scanner.
    private String getUserInput(){
        String value = null;
        try{
            value = scanner.nextLine();
            return value.trim();
        } catch (Exception e) {
            System.out.println("The value must not be empty. Please try again.");
            return null;
        }
    }


    /**
     * @description: This class contains methods to receive a user's name and year of birth, validate both, and calculate the user's age based on the current date.
     * The main method in the Main class creates an instance of this class and calls the method to get the user's name and age, then prints a greeting message with 
     * the user's name and age.
     * @arguments: None
     * @return: String type, returns the user's name and age as a String in a welcoming message. 
     *  */
    public Object[] ex_1_getNameAndAge() {
        System.out.println("Welcome to the Name and Age Program! \nIf you wish to leave, just type 'exit' or 'quit' at any time.");
        
        try{
            String userName = getUserName();
            int userBirthYear = getBirthYear();

            return new Object[]{userName, userBirthYear};
        } catch (Exception e) {
            System.out.println("Something went wrong. \nPlease try to run the program again. Bye!");
            System.exit(0);
            return null;
        }
        
    }

}
