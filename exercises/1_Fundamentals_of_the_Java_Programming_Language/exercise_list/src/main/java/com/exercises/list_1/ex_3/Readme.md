## Exercise 3

Write a code that receives the base and height of a rectangle, calculates its area, and displays it on the screen by the formula: area = base x height

You can find the code for this exercise [here](ex_3.java).

## How it works

The code is structured in two classes: `Main` and `ex_3`. The `Main` class is responsible for executing the program, while the `ex_3` class contains the logic to receive the user's number, validate it, and print the Fibonacci series.

### `Main` class

In the `Main` class, we create an instance of the `ex_3` class and call the method `ex_3_getArea()`, which returns the area of the rectangle. We then print the area.

```java
    public static void main(String[] args) {
        ex_3 exercise_3 = new ex_3();
        double rectangleArea = exercise_3.ex_3_getArea();
        if(rectangleArea != -1) {
            System.out.println("The area of the rectangle is: " + rectangleArea);
        } else {
            System.out.println("Something went wrong. Please try to run the program again.");
            System.exit(0);
        }
    }
```

### `ex_3`

The `ex_3` class contains the logic to receive the user's number, validate it, calculate the area, and return the series.

```java
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
            String input = scanner.nextLine();
            return input.trim();
        }catch(Exception e){
            System.out.println("Something went wrong. Please try again.");
            System.out.println("Error details: " + e.getMessage());
            return null;
        }
    }
```

#### `exitProgram(String userInput)` method

This method is called to check if the user wants to exit the program by entering "exit" or "quit". If the user enters either of these commands, the program will print a goodbye message and terminate. This allows users to exit the program gracefully at any point during the input process.

```java
    private void exitProgram(String userInput){
        if(userInput.equalsIgnoreCase("exit") || userInput.equalsIgnoreCase("quit")){
            System.out.println("Goodbye!");
            System.exit(0);

        }
    }
```

#### `inputValidation(String userInput)` method

This method is responsible for validating the user's input, ensuring it is a valid string. It checks for empty strings, null values, and returns an object array containing a boolean indicating whether the input is valid and the trimmed user input itself. If the input is invalid, it prompts the user the information and returns false in the boolean value of the array.

```java
    private Object[] inputValidation(String userInput){
        if(userInput == null || userInput.trim().isEmpty()){
            System.out.println("The value must not be empty, please try again.");
            return new Object[]{false, null};
        }
        return new Object[]{true, userInput};
    }
```

#### `convertInputToDouble(String userInput)` method

This method is responsible for converting the user's input to a double value. It uses a try-catch block to handle any exceptions that may occur during the conversion process, such as `NumberFormatException`. If the conversion is successful, it returns the parsed double value; otherwise, it prints an error message and returns -1 to indicate an error.

```java
    private double convertInputToDouble(String userInput){
        try{
            double valueParsed = Double.parseDouble(userInput);
            return valueParsed;
        }catch(Exception e){
            System.out.println("Something went wrong. Check if the value is a valid number (ex.: 3.14).");
            return -1;
        }
    }
```

#### `getBaseRectangle()` method

This method runs in a loop until the user provides a valid input for the base of the rectangle. The input is read through `getUserInput()` and then validated by `inputValidation(String userInput)`, which returns an array containing a boolean indicating whether the input is valid and the trimmed user input itself. Once a valid input is received, the method converts it to a double value using `convertInputToDouble(String userInput)` and returns it.

````java
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

```java
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
````

#### `getHeightRectangle()` method

This method runs in a loop until the user provides a valid input for the height of the rectangle. The input is read through `getUserInput()` and then validated by `inputValidation(String userInput)`, which returns an array containing a boolean indicating whether the input is valid and the trimmed user input itself. Once a valid input is received, the method converts it to a double value using `convertInputToDouble(String userInput)` and returns it.

```java
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
```

### `calculateArea(double base, double height)` method

This method receives the base and height of the rectangle as parameters, calculates the area using the formula `area = base x height`, and returns the calculated area as a `double`.

```java
    private double calculateArea(double base, double height){
        return base * height;
    }
```
