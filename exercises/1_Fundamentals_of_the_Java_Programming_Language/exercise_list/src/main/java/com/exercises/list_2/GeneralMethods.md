## General methods for list 2 of exercises

This is a collection of general methods used in the exercises of list 2 of the "Fundamentals of the Java Programming Language" module. These methods are intended to provide a more robust and comprehensive learning experience, with added input validation, error handling, and personalized messages.
Differet from list 1, the methods in this list are designed to throw exceptions when invalid input is encountered, rather than simply printing error messages and continuing. This is intended to encourage better error handling practices and to provide a more realistic coding experience. If you prefer a simpler implementation, feel free to modify the code as needed or refer to the original exercises.
Also, this methods are intended to apply inherentence methods, which means that they are designed to be inherited by the main classes of each exercise, allowing for code reuse and a more organized code structure, rather than being rewittened for each exercise like before.

Get back to the [list 2](Readme.md) of exercises for the "Fundamentals of the Java Programming Language" module.

Acess the code file for this class [here](GeneralMethods.java).

#### parseToInt(String input)

This method takes a string input and attempts to parse it into an integer. It includes validation to ensure that the input is not null, not empty, and does not exceed a certain length to prevent parsing issues by calling the `intLimitingSize(trimmed)`. If the input is valid, it returns the parsed integer; otherwise, it throws an IllegalArgumentException with an appropriate error message.

```java
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

        return intLimitingSize(trimmed);
    }
```

#### intLimitingSize(String userInput)

This method checks if the input string exceeds the maximum or minimum limits for an integer. It first checks if the length of the input string is greater than 11 characters, which is a rough limit to prevent parsing issues with very large numbers. It also checks if the input starts with a negative sign and exceeds the length limit for negative numbers. If either of these conditions is true, it throws an IllegalArgumentException with an appropriate error message. If the input passes these checks, it attempts to parse it into an integer and returns the parsed value. If parsing fails due to a NumberFormatException, it catches the exception and throws a new IllegalArgumentException with a message indicating that the input is not a valid integer.

```java
   private int intLimitingSize(String userInput){

    if (userInput.length() > 11) {
        System.err.println("Number too large. The maximum allowed value is " + Integer.MAX_VALUE + ". Try something shorter.");
        throw new IllegalArgumentException("Number too large. The maximum allowed value is " + Integer.MAX_VALUE + ". Try something shorter.");
    }

    if (userInput.startsWith("-") && userInput.length() > 11) {
        System.err.println("Number too small. The minimum allowed value is " + Integer.MIN_VALUE + ". Try something bigger.");
        throw new IllegalArgumentException("Number too small. The minimum allowed value is " + Integer.MIN_VALUE + ". Try something bigger.");
    }

    try {
        int parsedInt = Integer.parseInt(userInput);
        return parsedInt;
    } catch (NumberFormatException e) {
        throw new IllegalArgumentException("'" + userInput + "' is not a valid integer. It exceeds the maximum allowed value of " + Integer.MAX_VALUE + ".", e);
    }
    }
```

#### parseToDouble(String input)

This method takes a string input and attempts to parse it into a double. It includes validation to ensure that the input is not null, not empty, and does not exceed a certain length to prevent parsing issues by calling the `doubleLimitingSize(trimmed)`. If the input is valid, it returns the parsed double; otherwise, it throws an IllegalArgumentException with an appropriate error message.

```java
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
```

#### doubleLimitingSize(String userInput)

This method checks if the input string exceeds the maximum or minimum limits for a double. It first checks if the length of the input string is greater than 50 characters, which is a rough limit to prevent parsing issues with very large numbers. If this condition is true, it throws an IllegalArgumentException with an appropriate error message. If the input passes this check, it attempts to parse it into a double. It also checks if the parsed value is infinite or NaN (Not a Number), and if so, it throws an IllegalArgumentException with an appropriate error message. If the input is valid and successfully parsed, it returns an object array containing a boolean value indicating that the input is valid and the parsed double value.

```java
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
```

#### parseToLong(String input)

This method takes a string input and attempts to parse it into a long. It includes validation to ensure that the input is not null, not empty, and does not exceed a certain length to prevent parsing issues by calling the `longLimitingSize(trimmed)`. If the input is valid, it returns the parsed long; otherwise, it throws an IllegalArgumentException with an appropriate error message.

```java
    private long parseToLong(String input){
       if (input == null) {
            System.err.println("Attempting to convert null String to long.");
            throw new IllegalArgumentException("Input value cannot be null at parseToLong method.");
        }

        String trimmed = input.trim();

        if (trimmed.isEmpty()) {
            System.err.println("Attempting to convert empty string to long.");
            throw new IllegalArgumentException("Input value cannot be empty at parseToLong method.");
        }

        try {
            Object[] result = longLimitingSize(trimmed);
            boolean isValid = (Boolean) result[0];
            if(!isValid){throw new IllegalArgumentException("Input value is out of the allowed range for expected value type.");}
            return (Long) result[1];
        } catch (NumberFormatException e) {
            System.err.println("Failed to convert '" + input + "' to long");
            throw new IllegalArgumentException(
                String.format("Invalid value: '%s'. Please enter a valid long.", input),
                e
            );
        }
    }
```

#### longLimitingSize(String userInput)

This method checks if the input string exceeds the maximum or minimum limits for a long. It first checks if the length of the input string is greater than 50 characters, which is a rough limit to prevent parsing issues with very large numbers. If this condition is true, it throws an IllegalArgumentException with an appropriate error message. If the input passes this check, it attempts to parse it into a long. It also checks if the parsed value is infinite or NaN (Not a Number), and if so, it throws an IllegalArgumentException with an appropriate error message. If the input is valid and successfully parsed, it returns an object array containing a boolean value indicating that the input is valid and the parsed long value.

```java
   private Object[] longLimitingSize(String userInput){

       // Avoid trying to parse strings absurdly long
        if (userInput.length() > 50) {
            throw new IllegalArgumentException("Number too large. The maximum allowed value is " + Long.MAX_VALUE + ". Try something shorter.");
        }

        try {
            long value = Long.parseLong(userInput);

            if (Long.isInfinite(value)) {
                throw new IllegalArgumentException("Number too large. The maximum allowed value is " + Long.MAX_VALUE + ". Try something shorter.");
            }
            if (Long.isNaN(value)) {
                throw new IllegalArgumentException("Invalid numeric value.");
            }

            return new Object[]{true, value};

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("'" + userInput + "' is not a valid decimal number.", e);
        }
    }
```

#### inputTypeValidation(String input, String expectedType)

This method takes a string input and an expected type (e.g., "integer", "double", "long") and attempts to validate and parse the input according to the expected type. It uses a switch statement to determine which parsing method to call based on the expected type. If the input is valid for the expected type, it returns an object array containing a boolean value indicating that the input is valid and the parsed value. If the input is invalid or if an unsupported type is specified, it throws an IllegalArgumentException with an appropriate error message.

```java
    public Object[] inputTypeValidation(String input, String expectedType) {
        try {
            switch (expectedType.toLowerCase()) {
                case "integer":
                    int intValue = parseToInt(input);

                    return new Object[]{true, intValue};
                case "double":
                        double doubleValue = parseToDouble(input);
                    return new Object[]{true, doubleValue};
                case "long":
                        long longValue = parseToLong(input);
                    return new Object[]{true, longValue};
                default:
                    System.err.println("Unsupported type: " + expectedType + ". Supported types are: integer, double, or Long. Check inputTypeValidation method.");
                    return new Object[]{false, null};
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Validation failed for input: '" + input + "' with expected type: " + expectedType + ".");
            System.err.println(e.getMessage());
            return new Object[]{false, null};
        }

    }
```

#### getUserInput()

This method is responsible for reading user input from the console. It uses a Scanner object to read a line of input and returns it as a string. If an error occurs while reading the input, it catches the exception, prints an error message along with the exception details, and returns null.

```java
    public String getUserInput(){
        try{
            return scanner.nextLine();
        }catch(Exception e){
            System.out.println("An error occurred while reading input. Please try again.");
            System.out.println("Exception: " + e.getMessage());
            return null;
        }
    }
```

#### isNegative(String input)

This method takes a string input and checks if it starts with a hyphen (-). It returns true if the input starts with a hyphen, and false otherwise.

```java
    public boolean isNegative(String input){
        return input.trim().startsWith("-");
    }
```
