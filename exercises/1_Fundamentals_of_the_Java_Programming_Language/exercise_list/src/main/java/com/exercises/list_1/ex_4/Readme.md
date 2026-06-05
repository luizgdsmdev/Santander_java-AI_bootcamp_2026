## Exercise 4

Write a code that receives the name and age of two people and prints the age difference between them.
You can find the code for this exercise [here](ex_4.java).

## How it works

The code is structured in two classes: `Main` and `ex_4`. The `Main` class is responsible for executing the program, while the `ex_4` class contains the logic to receive the user's input, validate it, and calculate the age difference.

### `Main` class

In the `Main` class, we create an instance of the `ex_4` class and call the method `ex_4_getAgeGap()`, which returns the age gap between the two users. We then print the age gap on the screen.

```java
    public static void main(String[] args) {
        ex_4 exercise_4 = new ex_4();
        Object[] generalUserinfo = exercise_4.ex_4_getAgeGap();
        Object[] userOneInfo = (Object[]) generalUserinfo[0];
        Object[] userTwoInfo = (Object[]) generalUserinfo[1];
        int ageGap = (int) generalUserinfo[2];
        if(generalUserinfo[0] != null) {
            System.out.println("The age difference between the user " + userOneInfo[0] + " and the user " + userTwoInfo[0] + " is: " + ageGap + " years.");
        } else {
            System.out.println("Something went wrong. Please try to run the program again.");
            System.exit(0);
        }
    }
```

### `ex_4` class

The `ex_4` class contains the logic to receive the user's input, validate it, calculate the age gap, and return the information.

```java
public Object[] ex_4_getAgeGap(){
        System.out.println("Welcome to the find the age gap Program! \nIf you wish to leave, just type 'exit' or 'quit' at any time.");

        try{
            Object[] userOneInfo = getUserInfo("first");
            Object[] userTwoInfo = getUserInfo("second");
            int ageGap = ageDifference((int) userOneInfo[1], (int) userTwoInfo[1]);
            return new Object[]{userOneInfo, userTwoInfo, ageGap};
        }
        catch (Exception e){
            System.out.println("An error occurred while running the program. Please try again.");
            System.exit(0);
        }finally{
            scanner.close();
        }
        // This return is just to satisfy the method's return type, it will never be reached due to System.exit(0) in the catch block.
        return null;
    }
```

#### `getUserInput()` method

This method is responsible solely for receiving the user's input and returning it as a `String`. It also contains a generic exception handling to catch any unexpected errors during the input process, providing a user-friendly message and details about the error.

```java
    private String getUserInput(){
        try{
            String userInput = scanner.nextLine();
            return userInput;
        }catch (Exception e){
            System.out.println("An error occurred while reading input. Please try again.");
            return null;
        }
    }
```

#### `validateYearOfBirth(String userInput)` method

This method receives the user's input for the year of birth as a parameter and checks if it is valid. It attempts to parse the input into an integer and checks if it falls within a reasonable range (between 1900 and 2026). If the input is valid, it returns an array containing `true` and the parsed year of birth. If the input is invalid, it returns an array containing `false` and `null`, along with an appropriate error message.

```java
    private Object[] validateYearOfBirth(String userInput){
        try{
            int yearOfBirth = Integer.parseInt(userInput);
            if(yearOfBirth < 1900 || yearOfBirth > 2026){
                System.out.println("Please enter a valid year of birth between 1900 and 2026.");
                return new Object[]{false, null};
            }
            return new Object[]{true, yearOfBirth};
        }catch (NumberFormatException e){
            System.out.println("Invalid input. Please enter a numeric value for the year of birth, ex.: 1990.");
            return new Object[]{false, null};
    }
    }

```

#### `validateUserName(String userName)` method

This method receives the user's input for the name as a parameter and checks if it is valid. It checks if the name is at least 2 characters long. If the input is valid, it returns an array containing `true` and the user's name. If the input is invalid, it returns an array containing `false` and `null`, along with an appropriate error message.

```java
    private Object[] validateUserName(String userName){
        if(userName.trim().length() < 2){
            System.out.println("Name must be at least 2 characters long. Please enter a valid name, ex.: John Doe.");
            return new Object[]{false, null};

        }
        return new Object[]{true, userName};
    }
```

#### `generalUserInputValidation(String userInput)` method

This method is a general validation method that checks if the user's input is not null and not empty. It returns an array containing `true` and the user's input if it is valid, or `false` and `null` if it is invalid, along with an appropriate error message.

```java
    private Object[] generalUserInputValidation(String userInput){
        if(userInput == null || userInput.trim().isEmpty()){
            System.out.println("Input cannot be empty. Please enter a valid value.");
            return new Object[]{false, null};
        }

        return new Object[]{true, userInput};
    }
```

#### `exitProgram(String userInput)` method

This method checks if the user's input is "exit" or "quit". If it is, the program will print a goodbye message and terminate. This allows users to exit the program gracefully at any point during the input process.

```java
    private void exitProgram(String userInput){
        if(userInput.trim().equalsIgnoreCase("quit") || userInput.trim().equalsIgnoreCase("exit")){
            System.out.println("Exiting the program. Goodbye!");
            System.exit(0);
        }
    }
```

#### `ageDifference(int userOne, int UserTwo)` method

This method receives the ages of the two users as parameters and calculates the absolute difference between them using `Math.abs()`. It includes exception handling to catch any unexpected errors during the calculation, providing a user-friendly message and details about the error. If an error occurs, it returns -1 to indicate that the age difference could not be calculated.

```java
    private int ageDifference(int userOne, int UserTwo){
        try{
            return Math.abs(userOne - UserTwo);
        }
        catch (Exception e){
            System.out.println("An error occurred while calculating the age difference.");
            return -1;
        }
    }
```

#### `getUserInfo(String userNumber)` method

This method is responsible for orchestrating the process of getting the user's name and year of birth. It runs two loops: one for validating the user's name and another for validating the user's year of birth. It uses the previously defined validation methods to ensure that the input is valid before proceeding to the next step. Once both pieces of information are successfully validated, it returns an array containing the user's name and year of birth.

```java
    private Object[] getUserInfo(String userNumber){
        boolean isValidNameInput = false;
        boolean isValidAgeInput = false;
        String userName = null;
        int yearOfBirth = 0;
        do{
            System.out.println("Please enter the " + userNumber + " user name:");
            String nameInput = getUserInput();

            Object[] generalValidationResult = generalUserInputValidation(nameInput);

            //Here, we're passing the beacon of validation through the different validation methods, ensuring that the input is not null or empty,
            //then validating the name, and finally checking if the user wants to exit the program, which will control the flow of the program and
            //prevent unnecessary validations if the user intends to quit. This way, we maintain a clear separation of concerns while ensuring a
            //smooth user experience.
            isValidNameInput = (boolean) generalValidationResult[0];
            if(isValidNameInput){
                Object[] nameValidationResult = validateUserName(nameInput);
                isValidNameInput = (boolean) nameValidationResult[0];
                if(isValidNameInput){
                    exitProgram(nameInput);
                    userName = (String) nameValidationResult[1];
                    isValidNameInput = true;
                }
            }
        }while(!isValidNameInput);

        do{
            System.out.println("Please enter the user " + userNumber + " year of birth:");
            String yearInput = getUserInput();

            Object[] generalValidationResult = generalUserInputValidation(yearInput);

            //Here, we're passing the beacon of validation through the different validation methods, ensuring that the input is not null or empty,
            //then validating the name, and finally checking if the user wants to exit the program, which will control the flow of the program and
            //prevent unnecessary validations if the user intends to quit. This way, we maintain a clear separation of concerns while ensuring a
            //smooth user experience.
            isValidAgeInput = (boolean) generalValidationResult[0];
            if(isValidAgeInput){
                Object[] yearValidationResult = validateYearOfBirth(yearInput);
                isValidAgeInput = (boolean) yearValidationResult[0];
                if(isValidAgeInput){
                    exitProgram(yearInput);
                    yearOfBirth = (int) yearValidationResult[1];
                    isValidAgeInput = true;
                }
            }
        }while(!isValidAgeInput);

        return new Object[]{userName, yearOfBirth};
    }
```
