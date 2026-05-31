## Exercise 1

Write a code that receives someone's name and year of birth and prints the following message on the screen: "Hello 'Name', you are 'X' years old".
You can find the code for this exercise [here](ex_1.java).

## Personal note

Here I took the liberty of improving the base code from the exercise, adding more validations by the use of the separation of concerns principle, personalized messages, and somewhat more interative than a simple input/output code.
Plus, I'll add more functionalities such as:

- [ ] Add personalized messages for each validation failure, such as "Name cannot be empty" or "Birth year must be a valid number". This will help users understand why their input is invalid and how to correct it.
- [ ] Add a feature to allow users to exit the program gracefully, such as by entering "exit" or "quit". This will improve the user experience by providing a clear way to end the program when they are finished.
- [ ] Add error handling for unexpected exceptions that may occur during input validation or age calculation. This will help prevent the program from crashing and provide a better user experience.
- [ ] Add a feature to allow users to input their birth date (day, month, year) instead of just the birth year. This will allow for a more accurate age calculation and provide a more personalized experience for the user.

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

This method runs on a loop until while the user privides a valid value of the `String` type, that is send for the `nameValidation(String userName)` method, that returns a `boolean` value type, defining if the loop continues or not.
Once a valid name is received, it returns the name as a string.

```java
    private String getUserName(){
        boolean isValidName;
        String userName;

        do{//Runs ultil eventually the user prompts a valida name, which is not null, empty, or less than 2 characters long.
            System.out.println("Enter your name: ");
            userName = scanner.nextLine();
            isValidName = nameValidation(userName);
        }while(!isValidName);

        return userName;
    }
```

#### `nameValidation(String userName)` method

This method receives the user's name as a parameter and checks if it is valid. It returns `true` if the name is valid (not null, not empty, and does not contain only whitespace), and `false` otherwise.

```java
    private static boolean nameValidation(String userName) {
        if(userName == null || userName.trim().isEmpty() || userName.length() < 2) {
            System.out.println("Invalid name. Please enter a valid name with at least 2 characters.");
            return false;
        }

        return true;
    }
```

#### `getBirthYear()` method

This method runs on a loop until while the user privides a valid value of the `String` type, that is send for the `birthYearValidation(String birthYear)` method, that returns a `boolean` value type, defining if the loop continues or not.
Once a valid year of birth is received, it calculates the user's age by subtracting the year of birth from the current year and returns the age as an integer.

```java
    private int getBirthYear(){
        String birthYear;
        boolean isValidBirthYear;
        do{
            System.out.println("Enter your birth year, must be a valid number (ex.: 1990): ");
            birthYear = scanner.nextLine();
            isValidBirthYear = birthYearValidation(birthYear);
        }while(!isValidBirthYear);

        return currentDate.getYear() - Integer.parseInt(birthYear);
    }

```

#### `birthYearValidation(String birthYear)` method

This method receives the user's year of birth as a parameter, first checks if it is a valid integer, and then checks if it is within a reasonable range (between 1876 and the current year). It returns `true` if the year of birth is valid, and `false` otherwise.

```java
        private boolean birthYearValidation(String userBirthYear){
        int currentYear = currentDate.getYear();

        try{
        // The try-catch block is used to handle the potential NumberFormatException that may occur when trying to parse the user's input into an integer.
        // If the user enters a non-numeric value, the catch block will catch the exception and print an error message.
            Integer.parseInt(userBirthYear);
        }catch(NumberFormatException e){
            System.out.println("Invalid input. Please enter a valid number for the birth year.");
            return false;
        }

        // The year of birth must be between 1876 and the current year, and the difference between the current year and the year of birth must be less than 150 years.
        // This validation ensures that the user enters a realistic year of birth, considering the average human lifespan and historical context.
        int userBirthYearInt = Integer.parseInt(userBirthYear);

        if(userBirthYearInt < 1876 || userBirthYearInt > currentYear || currentYear - userBirthYearInt > 150) {
            System.out.println("It seens something is off, you're either too old or you haven't been born yet. Please enter a valid birth year between 1876 and the current year.");
            return false;
        }

        return true;
    }
```
