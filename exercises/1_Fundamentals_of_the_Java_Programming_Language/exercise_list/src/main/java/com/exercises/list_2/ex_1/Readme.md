## Exercise 1

Write a code where the user enters a number and the multiplication table from 1 to 10 for that number is generated;

Get back to the [listing 2](../Readme.md) of exercises for the "Fundamentals of the Java Programming Language" module.

## How it works

The code is structured in two classes: `Main` and `ex_1`. The `Main` class is responsible for executing the program and to receive a number and execute the multiplication table from 1 to 10 for that number. The methods used to do so are located in the [GeneralMethods](../GeneralMethods.md) class, which will be shared across all exercises in this listing.

### `Main` class

This class contains the method `ex_5_multiplicationTable()`, which prompts the user to enter an integer, validates the input, and if valid, calls the method `printMultiplicationTable(int number)` to display the multiplication table for the entered number.

```java
public void ex_5_multiplicationTable() {
        System.out.println("\nPlease, enter an integer to see its multiplication table:");
        String userInput = getUserInput();
        Object[] validationResult = inputTypeValidation(userInput, "integer");

        boolean isValid = (boolean) validationResult[0];
        if(isValid) {
            try{
                printMultiplicationTable((int) validationResult[1]);
            }catch (IllegalArgumentException e){
                System.err.println("\nSomething wrong with the multiplication table, please try again.");
                System.err.println(e.getMessage());
            }
        } else {
            System.out.println("\nInvalid input. Please enter a valid integer for the multiplication table.");

        }
    }
```

### printMultiplicationTable(int number)

This method takes an integer `number` as a parameter and prints the multiplication table for that number from 1 to 10. It uses a `for` loop to iterate through the numbers 1 to 10 and prints the result of multiplying the input number by each of these numbers. The loop variable is of type `long` to handle larger multiplication results without overflow.

```java
private void printMultiplicationTable(int number) {
        System.out.println("Multiplication Table for " + number + ":");

        // Uses Long type for the loop variable to handle larger multiplication results without overflow
        for (long i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + ((long) number * i));
        }
    }
```
