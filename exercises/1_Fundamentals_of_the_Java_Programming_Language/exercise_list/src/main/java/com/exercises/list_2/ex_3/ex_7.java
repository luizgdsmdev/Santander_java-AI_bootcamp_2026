package main.java.com.exercises.list_2.ex_3;
import main.java.com.exercises.list_2.GeneralMethods;

public class ex_7 extends GeneralMethods {

    private Object[] isEvenOrOdd(String option) {
        if (option.equalsIgnoreCase("even") || option.equalsIgnoreCase("odd")) {
            return new Object[]{true, option};
        } else {
            System.err.println("Invalid option. Please, choose between 'even' or 'odd'.");
            throw new IllegalArgumentException("Options at isEvenOrOdd method must be 'even' or 'odd'.");
        }
    }

    private boolean isSecondNumberBigger(int num1, int num2) {
        if(num2 <= num1){
            System.err.println("The second number must be bigger than the first one. Please, try again.");
            throw new IllegalArgumentException("Invalid input at isSecondNumberBigger method. The second number must be bigger than the first one.");
        }
        return true;
    }

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

    public void ex_7_evenOrOdd() {
        System.out.println("Welcome to the Even or Odd list! \nIf you wish to leave, just type 'exit' or 'quit' at any time.");

        try{
            System.out.println("\nPlease, enter a number: \n");
            String fisrtNumber = getUserInput();
            isExit(fisrtNumber);

            System.out.println("\nPlease, enter a number that is bigger than the previous one: \n");
            String secondNumber = getUserInput();
            isExit(secondNumber);

            System.out.println("\nNow, let's choose between 'even' or 'odd': \n");
            String evenOrOdd = getUserInput();
            isExit(evenOrOdd);

            evenOrOdd(fisrtNumber, secondNumber, evenOrOdd);

        }catch (Exception e){
            System.err.println("Invalid input. Please, enter check the instructions and try again.");
            return;
        }
    }

}
