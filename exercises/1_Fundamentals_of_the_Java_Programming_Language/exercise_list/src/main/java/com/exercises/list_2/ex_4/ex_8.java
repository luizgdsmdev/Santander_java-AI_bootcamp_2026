package main.java.com.exercises.list_2.ex_4;
import main.java.com.exercises.list_2.GeneralMethods;

public class ex_8 extends GeneralMethods{

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

    private boolean isBiggerThan(double first, double second){
        if(second > first){return true;}
            return false;
    }

    private Object[] isRestZero(double first, double second){
        double rest = second % first;
        if(rest == 0){return new Object[]{true, rest};}
            return new Object[]{false, rest};
    }

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

}
