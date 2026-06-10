## Exercise 3

Write a code where the user enters a first number, a second number greater than the first, and chooses between even and odd options; the code should then display all even or odd numbers (according to the initial selection) within the range of numbers entered, including the numbers entered, in descending order.

Get back to the [listing 2](../Readme.md) of exercises for the "Fundamentals of the Java Programming Language" module.

## How it works

The code is structured in two classes: `Main` and `ex_7`. The `Main` class is responsible for executing the program and to receive he numbers, the "even or odd" option and execute the display. The methods used to do so are located in the [GeneralMethods](../GeneralMethods.md) class, which will be shared across all exercises in this listing, and also in the [ex_7](ex_7.java) class.

### `Main` class

This class is responsible for executing the program and to receive the numbers, the "even or odd" option and execute the display. The data is receive trhouth the `getUserInput()` method, and than the `evenOrOdd()` method is called to execute the display and validation of the even or odd numbers between the two numbers entered by the user.

```java
    public void ex_7_evenOrOdd() {
        System.out.println("Welcome to the Even or Odd list! \nIf you wish to leave, just type 'exit' or 'quit' at any time.");

        try{
            System.out.println("\nPlease, enter a number: \n");
            String fisrtNumber = getUserInput();

            System.out.println("\nPlease, enter a number that is bigger than the previous one: \n");
            String secondNumber = getUserInput();

            System.out.println("\nNow, let's choose between 'even' or 'odd': \n");
            String evenOrOdd = getUserInput();

            evenOrOdd(fisrtNumber, secondNumber, evenOrOdd);

        }catch (Exception e){
            System.err.println("Invalid input. Please, enter check the instructions and try again.");
            return;
        }
    }
```

### isEvenOrOdd(String option)

This method is responsible for validating the "even or odd" option entered by the user. If the option is valid, it returns an array with a boolean value indicating that the option is valid and the option itself. If the option is invalid, it prints an error message and throws an exception.

```java
    private Object[] isEvenOrOdd(String option) {
        if (option.equalsIgnoreCase("even") || option.equalsIgnoreCase("odd")) {
            return new Object[]{true, option};
        } else {
            System.err.println("Invalid option. Please, choose between 'even' or 'odd'.");
            throw new IllegalArgumentException("Options at isEvenOrOdd method must be 'even' or 'odd'.");
        }
    }
```

### isSecondNumberBigger(int num1, int num2)

This method is responsible for validating if the second number entered by the user is bigger than the first number. If the second number is bigger, it returns true. If the second number is not bigger, it prints an error message and throws an exception.

```java
    private boolean isSecondNumberBigger(int num1, int num2) {
        if(num2 <= num1){
            System.err.println("The second number must be bigger than the first one. Please, try again.");
            throw new IllegalArgumentException("Invalid input at isSecondNumberBigger method. The second number must be bigger than the first one.");
        }
        return true;
    }
```

### printEvenOrOddNumbers(int num1, int num2, String evenOrOdd)

This method is responsible for printing the even or odd numbers between the two numbers entered by the user, in descending order. It receives the two numbers and the "even or odd" option as parameters, and prints the numbers accordingly.

```java
    private void printEvenOrOddNumbers(int num1, int num2, String evenOrOdd) {
        System.out.println("\nHere are the " + evenOrOdd.toLowerCase() + " numbers, in descending order, between " + num1 + " and " + num2 + ": \n");
        for(int i = num2; i >= num1; i--){
            if(evenOrOdd.equalsIgnoreCase("even") && i % 2 == 0){
                    System.out.print(i + ", ");
            } else if(evenOrOdd.equalsIgnoreCase("odd") && i % 2 != 0){
                    System.out.print(i + ", ");
            }
        }
    }
```

### evenOrOdd(String firstNumber, String secondNumber, String evenOrOdd)

This method is responsible for validating the inputs and executing the display of the even or odd numbers between the two numbers entered by the user. It receives the two numbers and the "even or odd" option as parameters, validates them and calls the methods to print the even or odd numbers accordingly.

```java
    private void evenOrOdd(String firstNumber, String secondNumber, String evenOrOdd) {
        Object[] num1 = inputTypeValidation(firstNumber, "integer");
        Object[] num2 = inputTypeValidation(secondNumber, "integer");
        Object[] optionResult = isEvenOrOdd(evenOrOdd);

        if((boolean) optionResult[0] && (boolean) num1[0] && (boolean) num2[0]) {
            int number1 = (int) num1[1];
            int number2 = (int) num2[1];

            isSecondNumberBigger(number1, number2);

            printEvenOrOddNumbers(number1, number2, (String) optionResult[1]);
            System.out.println("\n\nThank you for using the Even or Odd list! See you next time!");

        }else{
            System.err.println("Invalid input. Please, check the instructions and try again.");
            throw new IllegalArgumentException("Invalid input at evenOrOdd method.");
        }

    }
```
