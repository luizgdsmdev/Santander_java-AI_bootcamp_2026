package main.java.com.exercises.list_2;
import java.util.Scanner;

/**
 * @description This class contains general methods that can be used across different exercises in the list 2. It serves as a base class for other 
 * exercise classes, allowing them to inherit common functionality and avoid code duplication.
 * @method getUserInput() This method prompts the user for input and returns the entered string. It handles any exceptions that may occur during 
 * input reading and provides feedback to the user in case of errors.
 */
public class GeneralMethods {
    private Scanner scanner = new Scanner(System.in);

    /**
     * @description This method prompts the user for input and returns the entered string. It handles any exceptions that may occur during 
     * input reading and provides feedback to the user in case of errors.
     * @return The string entered by the user, or null if an error occurs.
     */
    public String getUserInput(){
        try{
            return scanner.nextLine();
        }catch(Exception e){
            System.out.println("An error occurred while reading input. Please try again.");
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }

}
