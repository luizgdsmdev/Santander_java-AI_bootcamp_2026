## Exercise 2

Write a code where the user enters their height and weight, their BMI is calculated (BMI = weight / (height \* height)), and a message is displayed according to the result:

- If it is less than or equal to 18.5 "Underweight";
- If it is between 18.6 and 24.9 "Ideal weight";
- If it is between 25.0 and 29.9 "Slightly overweight";
- If it is between 30.0 and 34.9 "Grade I Obesity";
- If it is between 35.0 and 39.9 "Grade II (Severe) Obesity";
- If it is greater than or equal to 40.0 "Grade III (Morbid) Obesity";

Get back to the [listing 2](../Readme.md) of exercises for the "Fundamentals of the Java Programming Language" module.

## How it works

The code is structured in two classes: `Main` and `ex_2`. The `Main` class is responsible for executing the program and to receive a number and execute the multiplication table from 1 to 10 for that number. The methods used to do so are located in the [GeneralMethods](../GeneralMethods.md) class, which will be shared across all exercises in this listing.

### `Main` class

This class contains the method `ex_6_BmiCalculation()`, which prompts the user to enter their height in centimeters and weight in kilograms, validates the input, and if valid, calls the methods `BmiCalculation(String height, String weight)` to calculate the BMI and `BmiClassification(double bmi)` to classify the BMI result according to the specified categories.

```java
    public void ex_6_BmiCalculation(){
        System.out.println("\nWelcome to the BMI Calculator! \nIf you wish to leave, just type 'exit' or 'quit' at any time.");

        try{
            System.out.println("\nPlease, enter your height in cm:");
            String height = getUserInput();

            System.out.println("\nPlease, enter your weight in kg:");
            String weight = getUserInput();

            double result = BmiCalculation(height, weight);
            String classification = BmiClassification(result);

            System.out.println("\nThe result for your BMI with the height of " + height + "cm and weight of " + weight + "kg is: " + String.format("%.2f", result) + ". Your BMI classification is: " + classification);
        }catch (Exception e){
            System.err.println("Invalid input. Please, enter a valid number for height. Eg.: 170.5 and weight. Eg.: 70.5");
            return;
        }
    }
```

### BmiCalculation(String height, String weight)

This method takes the user's height and weight as input, validates them, and calculates the BMI using the formula: BMI = weight / (height \* height). The height is converted from centimeters to meters by dividing it by 100 to fit the BMI formula. The method returns the calculated BMI as a double value.

```java
    private double BmiCalculation(String height, String weight){
        double validHeight = inputValidation(height)/100; // Convert height from cm to m to fit the BMI formula
        double validWeight = inputValidation(weight);
        return validWeight/(validHeight*validHeight);
    }
```

### inputValidation(String input)

This method validates the user's input for height and weight. It first checks if the input is negative using the `isNegative(String input)` method. If the input is negative, it throws an `IllegalArgumentException` with a message indicating that a positive number is expected. Then, it uses the `inputTypeValidation(String input, String expectedType)` method to check if the input can be parsed as a double and if it is greater than 0. If the input is not valid, it throws another `IllegalArgumentException` with a message asking for a valid positive number. If the input passes both validations, it returns the parsed double value.

```java
    private double inputValidation(String input){
        boolean isNegativeHeight = isNegative(input);
        if(isNegativeHeight){
            throw new IllegalArgumentException("Invalid input, expected a positive number.");
        }

        Object[] isValidInput = inputTypeValidation(input, "double");
        if(isValidInput[0].equals(false) || (Double) isValidInput[1] <= 0){
            throw new IllegalArgumentException("Please, enter a valid positive number.");
        }

        return (Double) isValidInput[1];
    }
```

### BmiClassification(double bmi)

This method takes the calculated BMI as input and classifies it according to the specified categories. It checks the value of BMI against the defined thresholds and returns a string indicating the classification of the BMI result, such as "Underweight", "Ideal weight", "Slightly overweight", "Grade I Obesity", "Grade II (Severe) Obesity", or "Obese". If the BMI is negative or zero, it returns a message indicating that BMI cannot be neither negative nor zero and asks for valid height and weight values.

```java
    private String BmiClassification(double bmi){
        if(bmi <= 0){
            return "BMI cannot be negative or zero. Please, enter valid height and weight values.";

        }else if(bmi <= 18.5){
            return "Underweight";
        } else if (bmi >= 18.6 && bmi <= 24.9) {
            return "Ideal weight";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            return "Slightly overweight";
        } else if (bmi >= 30.0 && bmi <= 34.9) {
            return "Grade I Obesity";
        } else if (bmi >= 35.0 && bmi <= 39.9) {
            return "Grade II (Severe) Obesity";
        } else {
            return "Obese";

        }
    }
```
