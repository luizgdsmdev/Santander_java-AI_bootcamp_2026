## Exercise 4

Write a code where the user inputs an initial number, then N other numbers. The code execution will continue until the number entered and divided by the first number results in a remainder other than 0. Numbers smaller than the first number should be ignored.

Get back to the [listing 2](../Readme.md) of exercises for the "Fundamentals of the Java Programming Language" module.

## How it works

The code is structured in two classes: `Main` and `ex_8`. The `Main` class is responsible for executing the program and to receive the numbers, the "even or odd" option and execute the display. The methods used to do so are located in the [GeneralMethods](../GeneralMethods.md) class, which will be shared across all exercises in this listing, and also in the [ex_8](ex_8.java) class.

### `Main` class

This class is responsible for receiving the input from the user and executing the program. It also calls internal methods to execute the display and validation of the numbers, like the `getFisrtNumber()` method. If the input is valid, the `ex_8_remainderOtherThan_0()` method is called to execute the display and validation of the remainder other than 0 numbers.

```java
    public void ex_8_remainderOtherThan_0(){
        System.out.println("Welcome to the reminder other than 0 list! \nIf you wish to leave, just type 'exit' or 'quit' at any time.");

        try{
            boolean isValid = false;
            do{
                Object[] firstNumber = getFisrtNumber();
                Object[] secondNumber = getSecondNumber((Double) firstNumber[1]);
                Object[] result = isRestZero((Double) firstNumber[1], (Double) secondNumber[1]);
                if((boolean) result[0]){
                    System.out.println("\nRemainder of " + secondNumber[1] + " / " + firstNumber[1] + " = " +  result[1] + ". Please, try again.");
                    continue;
                }else{
                    isValid = true;
                    System.out.println("\nRemainder of " + secondNumber[1] + " / " + firstNumber[1] + " is not 0, it is " + result[1] + ". Thank you for using the remainder other than 0 list! See you next time!");
                }

            }while(!isValid);

        }catch (Exception e){
            System.err.println("Invalid input. Please, enter check the instructions and try again.");
            return;
        }

    }
```

### `getFisrtNumber()` method

This method is responsible for receiving the first number from the user and validating it according to the instructions.

```java
    private Object[] getFisrtNumber(){
        boolean isValid = false;

        do{
            System.out.println("\nEnter the first positive number, greater than 0: \n");
            String firstString = getUserInput();
            isExit(firstString);

            if(isNegative(firstString)){
                System.err.println("\nIt must be a positive number and greater than 0. Please, try again.\n");
                continue;
            }else{
                Object[] result = inputTypeValidation(firstString, "double");

                if(!(boolean) result[0] || (Double) result[1] <= 0){
                    System.err.println("\nIvalid input. Please, try again with a positive number greater than 0.\n");
                    continue;
                }else{
                    isValid = true;
                    return new Object[]{true, (Double) result[1]};
                }

            }

        }while(!isValid);

        return new Object[]{false, null};
    }
```

### `getSecondNumber(double firstNumber)` method

This method is responsible for receiving the second number from the user and validating it according to the instructions.

```java
    private Object[] getSecondNumber(double firstNumber){
        boolean isValid = false;

        do{
            System.out.println("\nEnter the second positive number, greater than 0 and " + firstNumber + ": \n");
            String secondString = getUserInput();
            isExit(secondString);

            if(isNegative(secondString)){
                System.err.println("\nIt must be a positive number and greater than 0 and " + firstNumber + ". Please, try again.\n");
                continue;
            }else{
                Object[] result = inputTypeValidation(secondString, "double");

                if(!(boolean) result[0] ||
                    (Double) result[1] <= 0 ||
                    !isBiggerThan(firstNumber, (Double) result[1])){
                    System.err.println("\nIvalid input. Please, try again with a positive number greater than 0 and " + firstNumber + ".\n");
                    continue;
                }else{
                    isValid = true;
                    return new Object[]{true, (Double) result[1]};
                }

            }

        }while(!isValid);

        return new Object[]{false, null};
    }
```

### `isBiggerThan(double first, double second)` method

This method is solely responsible for validating if the second number entered by the user is bigger than the first number.

```java
    private boolean isBiggerThan(double first, double second){
        if(second > first){return true;}
            return false;
    }
```

### `isRestZero(double first, double second)` method

This method is solely responsible for validating if the remainder from the numbers entered by the user is 0.

```java
    private Object[] isRestZero(double first, double second){
        double rest = second % first;
        if(rest == 0){return new Object[]{true, rest};}
            return new Object[]{false, rest};
    }
```
