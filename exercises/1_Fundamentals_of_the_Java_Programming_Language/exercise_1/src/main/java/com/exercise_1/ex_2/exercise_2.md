## Exercise 2

Write a code that receives the side length of a square, calculates its area, and displays it on the screen by the formula: area = side x side

You can find the code for this exercise [here](ex_2.java).

## How it works

The code is structured in two classes: `Main` and `ex_2`. The `Main` class is responsible for executing the program, while the `ex_2` class contains the logic to receive the user's number, validate it, and print the Fibonacci series.

### `Main` class

In the `Main` class, we create an instance of the `ex_2` class and call the method `ex_2_GetArea()`, which returns the area of the square. We then print the area.

```java
    public static void main(String[] args) {
        ex_2 exercise_2 = new ex_2();
        double area = exercise_2.ex_2_GetArea();
        System.out.println("The area of the square is: " + area);
    }
```

### `ex_2` class

The `ex_2` class contains the logic to receive the user's number, validate it, calculate the area, and return the series.

```java
    public double ex_2_GetArea(){
        System.out.println("Welcome to the find the area of a square Program! \nIf you wish to leave, just type 'exit' or 'quit' at any time.");

        try{
            double squareLength = getSquareLength();
            return calculateArea(squareLength);
        } catch (Exception e) {
            System.out.println("Something went wrong. Please try to run the program again.");
            System.exit(0);
            return -1; // Return an error value
        }finally {
            scanner.close();
        }
    }
```

#### `getUserInput()` method

This method is responsible solely for receiving the user's input and returning it as a `String`. It also contains a generic exception handling to catch any unexpected errors during the input process, providing a user-friendly message and details about the error.

```java
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
```

#### `inputValidation(String userInput)` method

This method is responsible for validating the user's input, ensuring it is a valid number. It checks for empty strings, null values, and ensures the input can be parsed as a `double` value.

```java
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
```

#### `exitProgram(String userInput)` method

This method is responsible for validating the user's input for quitting the program by the use of a simple check for the presence of the words "exit" or "quit". If either of these words is found, the program will print a goodbye message and terminate gracefully.

```java
private static void exitProgram(String userInput){
        if(userInput != null && (userInput.equalsIgnoreCase("exit") || userInput.equalsIgnoreCase("quit"))) {
            System.out.println("Goodbye!");
            System.exit(0);
        }
    }
```

#### `getSquareLength()` method

This method runs in a loop until the user provides a valid input for the length of the square's side. The input is read through `getUserInput()` and then validated by `inputValidation(String userInput)`, which returns an array containing a boolean indicating whether the input is valid and the parsed double value if it is valid. Once a valid input is received, the method returns the parsed double value.

```java
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
```

#### `calculateArea(double sideLength)` method

This method receives the length of the square's side as a parameter, calculates the area using the formula `area = side x side`, and returns the calculated area as a `double`.

```java
private double calculateArea(double sideLength){
        return sideLength * sideLength;
    }
```
