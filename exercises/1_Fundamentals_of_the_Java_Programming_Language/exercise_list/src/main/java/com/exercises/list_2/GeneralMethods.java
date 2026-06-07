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
     * @description This method is solely responsible for parsing user input into an integer. It accepts a string input and returns an integer value, 
     * or throws an exception if the parsing fails. The method includes detailed error handling to provide informative feedback in case of invalid input.
     * @param input The user input string to be parsed into an integer.
     * @return An integer value parsed from the input string, or throws an IllegalArgumentException if the input is null, empty, or cannot be parsed 
     * as an integer.
    */
   private int parseToInt(String input){
       if (input == null) {
           System.err.println("Attempting to convert null String to integer.");
           throw new IllegalArgumentException("Input value cannot be null at parseToInt method.");
        }

        String trimmed = input.trim();

        if (trimmed.isEmpty()) {
            System.err.println("Attempting to convert empty string to integer.");
            throw new IllegalArgumentException("Input value cannot be empty at parseToInt method.");
        }
        
        boolean isValid = intLimitingSize(trimmed);
        if(!isValid){throw new IllegalArgumentException("Input value is out of the allowed range for expected value type.");}
        
        try {
            int valor = Integer.parseInt(trimmed);

            System.out.println("Conversion successful: '" + input + "' -> " + valor + ".");
            return valor;
        } catch (NumberFormatException e) {
            System.err.println("Failed to convert '" + input + "' to integer");
            throw new IllegalArgumentException(
                String.format("Invalid value: '%s'. Please enter a valid integer.", input), 
                e
            );
        }
    }

    /**
     * @description This method checks if the input string exceeds the maximum or minimum limits for an integer. It throws an IllegalArgumentException if the input is out of range.
     * @param userInput The user input string to be checked for size limits.
     * @return true if the input is within the allowed range, otherwise throws an exception.
     */
   private boolean intLimitingSize(String userInput){

        if (userInput.length() > 11) {// 11 digits as the maximum possible for int
            throw new IllegalArgumentException("Number too large. The maximum allowed value is " + Integer.MAX_VALUE + ". Try something shorter.");
        }

        if (userInput.startsWith("-") && userInput.length() > 11) {
            throw new IllegalArgumentException("Number too small. The minimum allowed value is " + Integer.MIN_VALUE + ". Try something bigger.");
        }

        return true;
    }

    /**
     * @description This method is solely responsible for parsing user input into an double. It accepts a string input and returns an double value, 
     * or throws an exception if the parsing fails. The method includes detailed error handling to provide informative feedback in case of invalid input.
     * @param input The user input string to be parsed into an double.
     * @return An double value parsed from the input string, or throws an IllegalArgumentException if the input is null, empty, or cannot be parsed 
     * as an double.
     */
    private double parseToDouble(String input){
       if (input == null) {
            System.err.println("Attempting to convert null String to double.");
            throw new IllegalArgumentException("Input value cannot be null at parseToDouble method.");
        }

        String trimmed = input.trim();

        if (trimmed.isEmpty()) {
            System.err.println("Attempting to convert empty string to double.");
            throw new IllegalArgumentException("Input value cannot be empty at parseToDouble method.");
        }

        try {
            Object[] result = doubleLimitingSize(trimmed);
            boolean isValid = (Boolean) result[0];
            if(!isValid){throw new IllegalArgumentException("Input value is out of the allowed range for expected value type.");}
            return (Double) result[1];
        } catch (NumberFormatException e) {
            System.err.println("Failed to convert '" + input + "' to double");
            throw new IllegalArgumentException(
                String.format("Invalid value: '%s'. Please enter a valid double.", input), 
                e
            );
        }
    }

    /**
     * @description This method checks if the input string exceeds the maximum or minimum limits for an double. It throws an IllegalArgumentException if the input is out of range.
     * @param userInput The user input string to be checked for size limits.
     * @return An object array containing a boolean value and a double value, or throws an exception. The boolean value indicates whether the input is within the allowed range, 
     * and the double value is the parsed double if valid.
     */
   private Object[] doubleLimitingSize(String userInput){

        // Avoid trying to parse strings absurdly long
        if (userInput.length() > 50) {
            throw new IllegalArgumentException("Number too large. The maximum allowed value is " + Double.MAX_VALUE + ". Try something shorter.");
        }

        try {
            double value = Double.parseDouble(userInput);

            if (Double.isInfinite(value)) {
                throw new IllegalArgumentException("Number too large. The maximum allowed value is " + Double.MAX_VALUE + ". Try something shorter.");
            }
            if (Double.isNaN(value)) {
                throw new IllegalArgumentException("Invalid numeric value.");
            }

            return new Object[]{true, value};

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("'" + userInput + "' is not a valid decimal number.", e);
        }
    }

    /**
     * @description This method validates user input based on the expected type. It accepts a string input and a string expectedType, 
     * which specifies the expected type of the input. The method attempts to parse the input according to the expected type and returns an 
     * array containing a boolean indicating whether the validation was successful and the parsed value (or null if validation fails).
     * @param input The user String input to be validated.
     * @param expectedType The expected type of the input (e.g., "integer", "double").
     * @return An array containing a boolean indicating whether the validation was successful and the parsed value (or null if validation fails).
     */
    public Object[] inputTypeValidation(String input, String expectedType) {
        try {
            switch (expectedType.toLowerCase()) {
                case "integer":
                    int intValue = parseToInt(input);

                    return new Object[]{true, intValue};
                    case "double":
                        double doubleValue = parseToDouble(input);
                    return new Object[]{true, doubleValue};
                default:
                    System.err.println("Unsupported type: " + expectedType + ". Supported types are: integer, double. Check inputTypeValidation method.");
                    return new Object[]{false, null};
            }
        } catch (NumberFormatException e) {
            System.err.println("Validation failed for input: '" + input + "' with expected type: " + expectedType + ". Check inputTypeValidation method.");
            return new Object[]{false, null};
        }

    }

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
