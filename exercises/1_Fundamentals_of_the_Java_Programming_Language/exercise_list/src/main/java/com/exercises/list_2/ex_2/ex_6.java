package com.exercises.list_2.ex_6;
import main.java.com.exercises.list_2.GeneralMethods;
public class ex_6 extends GeneralMethods{

    private double BmiCalculation(String height, String weight){
        double validHeight = inputValidation(height)/100; // Convert height from cm to m to fit the BMI formula
        double validWeight = inputValidation(weight);
        return validWeight/(validHeight*validHeight);
    }

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

}
