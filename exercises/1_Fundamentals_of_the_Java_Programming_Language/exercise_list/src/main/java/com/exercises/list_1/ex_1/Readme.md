## Exercise 1

Write a code that receives someone's name and year of birth and prints the following message on the screen: "Hello 'Name', you are 'X' years old".

You can find the code for this exercise [here](ex_1.java).

## Personal note

Here I took the liberty of improving the base code from the exercise, adding more validations by the use of the separation of concerns principle, personalized messages, and somewhat more interative than a simple input/output code.
Plus, I'll add more functionalities such as:

- [x] Add personalized messages for each validation failure, such as "Name cannot be empty" or "Birth year must be a valid number". This will help users understand why their input is invalid and how to correct it.
- [x] Add a feature to allow users to exit the program gracefully, such as by entering "exit" or "quit". This will improve the user experience by providing a clear way to end the program when they are finished.
- [x] Add error handling for unexpected exceptions that may occur during input validation or age calculation. This will help prevent the program from crashing and provide a better user experience.

I'll tick these items as I implement them in the code, and I'll update this section with the new functionalities added.

## How it works

The code is structured in two classes: `Main` and `ex_1`. The `Main` class is responsible for executing the program, while the `ex_1` class contains the logic to receive the user's name and year of birth, calculate their age, and return the information.

### `Main` class

In the `Main` class, we create an instance of the `ex_1` class and call the method `ex_1_getNameAndAge()`, which returns an array of objects containing the user's name and age. We then print a personalized message using this information.

```java
    public static void main(String[] args) {
        ex_1 exercise_1 = new ex_1();
        Object[] message = exercise_1.ex_1_getNameAndAge();
        System.out.println("Hello " + message[0] + ", you are " + message[1] + " years old");
    }
```

### `ex_1` class

The `ex_1` class contains the logic to receive the user's name and year of birth, calculate their age, validate both inputs, and return the information.

```java
    public Object[] ex_1_getNameAndAge() {

        String userName = getUserName();
        int userBirthYear = getBirthYear();

        return new Object[]{userName, userBirthYear};

    }
```

#### `getUserName()` method

This method runs in a loop until the user provides a valid name. Each input is read through `getUserInput()` and then passed to `nameValidation(String userName)`, which returns a `boolean` value that decides whether the loop continues or stops.
Once a valid name is received, the method returns it as a `String`.

```java
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
```

#### `nameValidation(String userName)` method

This method receives the user's name as a parameter and checks if it is valid. It returns `true` if the name is valid (not null, not empty, and at least 2 characters long), and `false` otherwise.

```java
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
```

#### `getBirthYear()` method

This method runs in a loop until the user provides a valid birth year. The value is read by `getUserInput()` and validated by `birthYearValidation(String birthYear)`, which decides whether the loop should continue.
Once a valid year of birth is received, the method calculates the user's age and returns it as an `int`.

```java
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
```

#### `birthYearValidation(String birthYear)` method

This method receives the user's year of birth as a parameter, first checks if it is a valid integer, and then checks if it is within a reasonable range (between 1876 and the current year). It returns `true` if the year of birth is valid, and `false` otherwise.

```java
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
```

#### `calculateAge(int birthYear)` method

This method receives the birth year as a parameter and returns the user's age by subtracting it from the current year.

```java
    private int calculateAge(int birthYear){
        return currentDate.getYear() - birthYear;
    }
```

#### `exitProgram(String messageValue)` method

This method checks whether the user typed `exit` or `quit`. If one of these commands is found, the program prints a goodbye message and ends gracefully.

```java
    private static void exitProgram(String messageValue){
        if(messageValue.equalsIgnoreCase("exit") || messageValue.equalsIgnoreCase("quit")) {
                System.out.println("Exiting the program. Goodbye!");
                System.exit(0);
            }
    }
```

#### `getUserInput()` method

This method is responsible for reading the user's input from the console. It uses a `try-catch` block to handle any potential exceptions that may occur during input reading with the `Scanner`.

```java
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
```
